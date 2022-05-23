package com.github.fabrizio_costabile.backpropagation.main.util;

/**
 * Matrix of activation values of each neuron
 *
 * @author Fabrizio Costabile
 */
public class Activations {

    private double[][] activations;

    /**
     * Constructs the neuron's activation values matrix
     *
     * @param sizesOfLayers the size of each layer in the network
     */
    public Activations(int[] sizesOfLayers) {
        activations = new double[sizesOfLayers.length][];
        for (int i = 0; i < activations.length; i++) {
            activations[i] = new double[sizesOfLayers[i]];
        }
    }

    /**
     * Set the activation value for neuron index <code>j</code> in layer index <code>i</code>
     *
     * @param i the layer index
     * @param j the neuron index
     * @param value the value to be set
     */
    public void setNeuronValue(int i, int j, double value) {
        activations[i][j] = value;
    }

    /**
     * Get the activation value for neuron index <code>j</code> in layer index <code>i</code>
     *
     * @param i the layer index
     * @param j the neuron index
     * @return the value for neuron index <code>j</code> in layer index <code>i</code>
     */
    public double getNeuronValue(int i, int j) {
        return activations[i][j];
    }

    /**
     * Get the number of layers
     *
     * @return the number of layers
     */
    public int getSize() {
        return activations.length;
    }

    /**
     * Get the number of neurons by layer
     *
     * @param i the layer index
     * @return the number of neurons in layer index <code>i</code>
     */
    public int getSize(int i) {
        return activations[i].length;
    }

    /**
     * Get the activation values of each neuron in the output layer
     *
     * @return the values of each neuron in the output layer
     */
    public double[] getOutputNeuronsValues() {
        return activations[activations.length - 1];
    }

}
