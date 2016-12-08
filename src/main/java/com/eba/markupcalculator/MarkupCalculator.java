package com.eba.markupcalculator;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * This is the main class, which is the markup calculator.
 */
public class MarkupCalculator {
    private float flatMarkup;
    private float personMarkup;
    private Collection<MarkupCategory> markupCategories;
    private float defaultMarkup;

    public MarkupCalculator(float flatMarkup, float personMarkup, Collection<MarkupCategory> markupCategories,
            float defaultMarkup) {
        this.flatMarkup = flatMarkup;
        this.personMarkup = personMarkup;
        this.markupCategories = markupCategories;
        this.defaultMarkup = defaultMarkup;
    }

    public BigDecimal calculate(BigDecimal basePrice, int numberPeople, String category) {
        return null;
    }
}
