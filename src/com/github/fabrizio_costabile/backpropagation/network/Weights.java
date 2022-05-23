package com.github.fabrizio_costabile.backpropagation.network;

import java.util.Random;

/**
 * 3D matrix of connection weights between neurons
 *
 * @author Fabrizio Costabile
 */
public class Weights {

    private double[][][] weights;

    /**
     * Constructs a 3D weight matrix by number of neurons in each layer
     *
     * @param sizesOfLayers the number neurons of each layer (including input & output layers)
     */
    public Weights(int[] sizesOfLayers) {
        weights = new double[sizesOfLayers.length][][];
        for (int i = 0; i < sizesOfLayers.length; i++) {
            weights[i] = new double[sizesOfLayers[i]][];
        }
        for (int i = 0; i < sizesOfLayers.length - 1; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                int nextLayerSize = weights[i + 1].length;
                weights[i][j] = new double[nextLayerSize];
            }
        }
        int outputLayerSize = sizesOfLayers[sizesOfLayers.length - 1];
        weights[weights.length - 1][outputLayerSize - 1] = new double[0];
    }

    /**
     * Set every weight to a random value
     *
     * @param seed the initial seed
     */
    public void setRandomWeights(int seed) {
        Random random = new Random(seed);
        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                for (int k = 0; k < weights[i][j].length; k++) {
                    weights[i][j][k] = random.nextDouble();
                }
            }
        }
    }

    /**
     * Get number of layers
     *
     * @return the number of layers
     */
    public int getSize() {
        return weights.length;
    }

    /**
     * Get the number of neurons by layer
     *
     * @param i the layer index
     * @return the number of neurons in layer index <code>i</code>
     */
    public int getSize(int i) {
        return weights[i].length;
    }

    /**
     * Get the number of connection weights for a given neuron & the neuron's layer
     *
     * @param i the layer index
     * @param j the neuron in layer index <code>i</code>
     * @return the number of connection weights for neuron index <code>j</code> in layer index <code>i</code>
     */
    public int getSize(int i, int j) {
        return weights[i][j].length;
    }

    /**
     * Set the connection weight between neuron index <code>j</code>, in layer index <code>i</code>,
     * and neuron index <code>k</code>, in layer index <code>i + 1</code>
     *
     * @param i the layer index
     * @param j the neuron in layer index <code>i</code>
     * @param k the neuron in layer index <code>i + 1</code>
     * @param weight the connection weight between neuron index <code>j</code>, in layer index <code>i</code>,
     * and neuron index <code>k</code>, in layer index <code>i + 1</code>
     */
    public void setWeight(int i, int j, int k, double weight) {
        weights[i][j][k] = weight;
    }

    /**
     * Get the connection weight by layer and neurons
     *
     * @param i the layer index
     * @param j the neuron in layer index <code>i</code>
     * @param k the neuron in layer index <code>i + 1</code>
     * @return the connection weight between neuron index <code>j</code>, in layer index <code>i</code>,
     * and neuron index <code>k</code>, in layer index <code>i + 1</code>
     */
    public double getWeight(int i, int j, int k) {
        return weights[i][j][k];
    }

}
