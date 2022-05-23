package com.github.fabrizio_costabile.backpropagation.main;

import com.github.fabrizio_costabile.backpropagation.data.Data;
import com.github.fabrizio_costabile.backpropagation.data.DataSet;
import com.github.fabrizio_costabile.backpropagation.function.SigmoidFunction;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Testing the "Back-Propagation" learning algorithm on a "Feed-Forward Neural Network" by predicting sinusoid values.
 *
 * Setup: sinusoid values are calculated given a series of fixed-step (0.01) inputs.
 *
 * The test consists in, given 10 consecutive sinusoid values, to predict the next sinusoid value.
 * It will result positive if the "Mean Absolute Error" (MAE) is less then 5%.
 *
 * @author Fabrizio Costabile
 */
public class SinusoidPredictionTest {

    private final int SINUSOID_POINTS = 100000;
    private final int TRAINING_POINTS = SINUSOID_POINTS * 2 / 3;
    private final double STEP = 0.01;

    private final int INPUT_LAYER_SIZE = 10;
    private final int OUTPUT_LAYER_SIZE = 1;
    private final int[] SIZES_OF_LAYERS = {INPUT_LAYER_SIZE, 5, OUTPUT_LAYER_SIZE};

    private Backpropagation backpropagation;
    private DataSet dataSet = buildDataSet();

    private DataSet buildDataSet() {
        DataSet dataSet = new DataSet();
        for (int i = 0; i < TRAINING_POINTS; i++) {
            double[] inputs = new double[INPUT_LAYER_SIZE];
            for (int j = 0; j < inputs.length; j++) {
                double x = (i + j) * STEP;
                inputs[j] = normalizedSin(x);
            }
            double x = (i + inputs.length) * STEP;
            double[] outputs = {normalizedSin(x)};
            dataSet.addData(new Data(inputs, outputs));
        }
        return dataSet;
    }

    @Before
    public void learnFromTrainingData() {
        backpropagation = new Backpropagation(SIZES_OF_LAYERS, new SigmoidFunction());
        backpropagation.learn(dataSet, 0.85, 0);
    }

    @Test
    public void meanAbsoluteErrorTest() {
        double mae = 0;
        int firstPoint = TRAINING_POINTS + 1;
        int testingPoints = SINUSOID_POINTS - TRAINING_POINTS;
        for (int i = firstPoint; i < firstPoint + testingPoints; i++) {
            double[] inputs = new double[INPUT_LAYER_SIZE];
            for (int j = 0; j < inputs.length; j++) {
                double x = (i + j) * STEP;
                inputs[j] = normalizedSin(x);
            }
            double x = (i + inputs.length) * STEP;
            double expected = normalizedSin(x);
            double predicted = backpropagation.predict(inputs)[0];
            mae += Math.abs(expected - predicted);
        }
        mae /= testingPoints;
        assertTrue(mae < 0.05);
    }

    private double normalizedSin(double x) {
        return (Math.sin(x) + 1) / 2;
    }

}
