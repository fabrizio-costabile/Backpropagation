package com.github.fabrizio_costabile.backpropagation;

import com.github.fabrizio_costabile.backpropagation.function.ActivationFunction;
import com.github.fabrizio_costabile.backpropagation.network.Activations;
import com.github.fabrizio_costabile.backpropagation.network.Weights;
import com.github.fabrizio_costabile.backpropagation.data.Data;
import com.github.fabrizio_costabile.backpropagation.data.DataSet;

/**
 * <strong>Back-Propagation</strong> learning algorithm for <strong>Feed-Forward Neural Networks</strong>
 *
 * @author Fabrizio Costabile
 */
public class Backpropagation {

    private Activations activations;
    private Weights weights;

    private ActivationFunction activationFunction;

    /**
     * Constructs the Back-Propagation learning algorithm for Feed-Forward Neural Networks
     *
     * @param sizesOfLayers the array containing the sizes of each layer
     * @param activationFunction the activation function
     */
    public Backpropagation(int[] sizesOfLayers, ActivationFunction activationFunction) {
        this.activations = new Activations(sizesOfLayers);
        this.weights = new Weights(sizesOfLayers);
        this.activationFunction = activationFunction;
    }

    /**
     * Train this network with the Back-Propagation learning algorithm
     *
     * @param dataSet the data set to learn from
     * @param learningRate the learning rate
     * @param seed the initial seed used to randomize the weights
     */
    public void learn(DataSet dataSet, double learningRate, int seed) {
        weights.setRandomWeights(seed);
        for (Data data : dataSet) {
            propagateInputsForward(data);
            double[][] deltas = propagateDeltasBackward(data);
            updateWeights(deltas, learningRate);
        }
    }

    /**
     * Predict the outputs given some inputs
     *
     * @param inputs the values to predict the output
     * @return predicted outputs
     */
    public double[] predict(double[] inputs) {
        propagateInputsForward(inputs);
        return activations.getOutputNeuronsValues();
    }

    private void propagateInputsForward(double[] inputs) {
        int outputLayerSize = weights.getSize(weights.getSize() - 1);
        propagateInputsForward(new Data(inputs, new double[outputLayerSize]));
    }

    /* Propagate the inputs forward to compute the outputs */
    private void propagateInputsForward(Data data) {
        for (int j = 0; j < activations.getSize(0); j++) {
            activations.setNeuronValue(0, j, data.getInputs()[j]);
        }
        for (int i = 1; i < activations.getSize(); i++) {
            for (int j = 0; j < activations.getSize(i); j++) {
                double x = computeInputSum(i, j);
                activations.setNeuronValue(i, j, activationFunction.evaluate(x));
            }
        }
    }

    private double computeInputSum(int i, int j) {
        double weightMultipliedNeuronValue = 0;
        for (int l = 0; l < weights.getSize(i - 1); l++) {
            double weight = weights.getWeight(i - 1, l, j);
            double neuronValue = activations.getNeuronValue(i - 1, l);
            weightMultipliedNeuronValue += weight * neuronValue;
        }
        return weightMultipliedNeuronValue;
    }

    /* Propagate deltas backward from output layer to input layer */
    private double[][] propagateDeltasBackward(Data data) {
        double[][] deltas = initDeltas();
        for (int j = 0; j < deltas[deltas.length - 1].length; j++) {
            double x = computeInputSum(deltas.length - 1, j);
            double derivative = activationFunction.evaluateDerivative(x);
            double difference = data.getOutputs()[j] - activationFunction.evaluate(x);
            deltas[deltas.length - 1][j] = derivative * difference;
        }
        for (int i = activations.getSize() - 2; i >= 1; i--) {
            for (int j = 0; j < activations.getSize(i); j++) {
                double x = computeInputSum(i, j);
                double derivative = activationFunction.evaluateDerivative(x);
                deltas[i][j] = derivative * computeSumOfWeightsMultipliedByDeltas(deltas, i, j);
            }
        }
        for (int j = 0; j < activations.getSize(0); j++) {
            double derivative = activationFunction.evaluateDerivative(data.getInputs()[j]);
            deltas[0][j] = derivative * computeSumOfWeightsMultipliedByDeltas(deltas, 0, j);
        }
        return deltas;
    }

    private double[][] initDeltas() {
        double[][] deltas = new double[weights.getSize()][];
        for (int i = 0; i < deltas.length; i++) {
            deltas[i] = new double[weights.getSize(i)];
        }
        return deltas;
    }

    private double computeSumOfWeightsMultipliedByDeltas(double[][] deltas, int i, int j) {
        double sum = 0;
        for (int k = 0; k < weights.getSize(i, j); k++) {
            sum += weights.getWeight(i, j, k) * deltas[i + 1][k];
        }
        return sum;
    }

    /* Update every weight in network using deltas */
    private void updateWeights(double[][] deltas, double learningRate) {
        for (int i = 0; i < weights.getSize()- 1; i++) {
            for (int j = 0; j < weights.getSize(i); j++) {
                for (int k = 0; k < weights.getSize(i, j); k++) {
                    double increment = learningRate * activations.getNeuronValue(i, j) * deltas[i + 1][k];
                    weights.setWeight(i, j, k, weights.getWeight(i, j, k) + increment);
                }
            }
        }
    }

}
