package fabri.ai.function;

/**
 * Sigmoid Function
 *
 * @author Fabrizio Costabile
 */
public class SigmoidFunction implements ActivationFunction {

    @Override
    public double evaluate(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    @Override
    public double evaluateDerivative(double x) {
        return Math.exp(-x) / Math.pow((Math.exp(-x) + 1), 2);
    }

}
