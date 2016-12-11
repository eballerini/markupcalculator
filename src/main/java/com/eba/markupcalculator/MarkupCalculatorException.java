package com.eba.markupcalculator;

/**
 * Exception thrown when {@link MarkupCalculator} cannot calculate a project cost
 */
public class MarkupCalculatorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MarkupCalculatorException(String message) {
        super(message);
    }
}
