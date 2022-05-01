package fabri.ai.ann;

import fabri.ai.function.SigmoidFunction;
import fabri.ai.data.Data;
import fabri.ai.data.DataSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Testing the "Back-Propagation" learning algorithm on a "Feed-Forward Neural Network" by predicting sinusoid values.
 *
 * Setup: sinusoid values are calculated given a series of fixed-step inputs.
 *
 * The test consists in, given 4 consecutive sinusoid values, to predict the next sinusoid value.
 * It will result positive if the "Mean Absolute Percentage Error" (MAPE) is less then 1%.
 *
 * @author Fabrizio Costabile
 */
public class SinusoidPredictionTest {

    private final int SINUSOID_POINTS = 1000;
    private final int TRAINING_POINTS = SINUSOID_POINTS * 2 / 3;

    private final double STEP = Math.PI / 10;

    private final int INPUT_LAYER_SIZE = 4;
    private final int OUTPUT_LAYER_SIZE = 1;
    private final int[] SIZES_OF_LAYERS = {INPUT_LAYER_SIZE, 4, 4, OUTPUT_LAYER_SIZE};

    private Backpropagation backpropagation;
    private DataSet dataSet = buildDataSet();

    private DataSet buildDataSet() {
        DataSet dataSet = new DataSet();
        for (int i = 0; i < TRAINING_POINTS; i++) {
            double[] inputs = new double[INPUT_LAYER_SIZE];
            for (int j = 0; j < inputs.length; j++) {
                inputs[j] = Math.sin((i + j) * STEP);
            }
            double[] outputs = {Math.sin((i + inputs.length) * STEP)};
            dataSet.addData(new Data(inputs, outputs));
        }
        return dataSet;
    }

    @Before
    public void learnFromTrainingData() {
        backpropagation = new Backpropagation(SIZES_OF_LAYERS, new SigmoidFunction());
        backpropagation.learn(dataSet, 1, 0);
    }

    @Test
    public void meanAbsolutePercentageErrorLessThenOne() {
        double mape = 0;
        int firstPoint = TRAINING_POINTS + 1;
        int testingPoints = SINUSOID_POINTS - TRAINING_POINTS;
        for (int i = firstPoint; i < firstPoint + testingPoints; i++) {
            double[] inputs = new double[INPUT_LAYER_SIZE];
            for (int j = 0; j < inputs.length; j++) {
                inputs[j] = Math.sin((i + j) * STEP);
            }
            double expected = Math.sin(inputs[3] + STEP);
            double prediction = backpropagation.predict(inputs)[0];
            mape += Math.abs((expected - prediction) / expected);
        }
        mape /= testingPoints;
        assertTrue(mape < 1.0);
    }

}
