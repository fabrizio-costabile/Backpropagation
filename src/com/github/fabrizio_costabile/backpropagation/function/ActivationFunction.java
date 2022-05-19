package com.github.fabrizio_costabile.backpropagation.function;

/**
 * Activation Function interface
 *
 * @author Fabrizio Costabile
 */
public interface ActivationFunction {

    /**
     * Calculation of the function's value for input value <code>x</code>
     *
     * @param x the value to evaluate
     * @return the function evaluation
     */
    double evaluate(double x);

    /**
     * Calculation of the function's derivative value for input value <code>x</code>
     *
     * @param x the value to evaluate
     * @return the function's derivative evaluation
     */
    double evaluateDerivative(double x);

}
