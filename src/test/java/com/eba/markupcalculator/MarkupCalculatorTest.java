package com.eba.markupcalculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class MarkupCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Collection<MarkupCategory> markupCategories = new HashSet<>();
        markupCategories.add(new MarkupCategory("drugs", 0.075f));
        markupCategories.add(new MarkupCategory("food", 0.13f));
        markupCategories.add(new MarkupCategory("electronics", 0.02f));

        MarkupCalculator markupCalculator = new MarkupCalculator(0.05f, 0.012f, markupCategories, 0f);
        assertEquals(new BigDecimal("1591.58"), markupCalculator.calculate(new BigDecimal("1299.99"), 3, "food"));
        assertEquals(new BigDecimal("6199.81"), markupCalculator.calculate(new BigDecimal("5432"), 1, "drugs"));
        assertEquals(new BigDecimal("13707.63"), markupCalculator.calculate(new BigDecimal("12456.95"), 4, "books"));
    }

    @Test
    public void testNoMarkup() throws Exception {
        MarkupCalculator markupCalculator = new MarkupCalculator(0f, 0f, null, 0f);
        assertEquals(new BigDecimal("1299.99"), markupCalculator.calculate(new BigDecimal("1299.99"), 3, "food"));
    }

    @Test(expected = MarkupCalculatorException.class)
    public void testInvalidBasePrice() throws Exception {
        MarkupCalculator markupCalculator = new MarkupCalculator(0f, 0f, null, 0f);
        markupCalculator.calculate(null, -1, "books");
    }
}
