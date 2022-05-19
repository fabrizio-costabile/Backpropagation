package com.github.fabrizio_costabile.backpropagation.function;

/**
 * Linear Function
 *
 * @author Fabrizio Costabile
 */
public class LinearFunction implements ActivationFunction {

    @Override
    public double evaluate(double x) {
        return x;
    }

    @Override
    public double evaluateDerivative(double x) {
        return 1;
    }

}
