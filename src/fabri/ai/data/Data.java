package fabri.ai.data;

/**
 * Data for training and/or testing purposes, made of input values and corresponding output values.
 *
 * @author Fabrizio Costabile
 */
public class Data {

    private double[] inputs;
    private double[] outputs;

    /**
     * Constructs data by input & corresponding output values
     *
     * @param inputs the input values
     * @param outputs the output values
     */
    public Data(double[] inputs, double[] outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }

    /**
     * Get the input values of this data
     *
     * @return the input values
     */
    public double[] getInputs() {
        return inputs;
    }

    /**
     * Get the output values of this data
     *
     * @return the output values
     */
    public double[] getOutputs() {
        return outputs;
    }

}
