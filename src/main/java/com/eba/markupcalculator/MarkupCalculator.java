package com.eba.markupcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This is the main class, which is the markup calculator.
 */
public class MarkupCalculator {
    private float flatMarkup;
    private float personMarkup;
    private Map<String, MarkupCategory> markupCategotyNameToCategory;
    private float defaultMarkup;

    /**
     * Main constructor
     *
     * @param flatMarkup
     *            the flat markup applied to the base price of the project
     * @param personMarkup
     *            the markup for each person
     * @param markupCategories
     *            the categories with their associated markup
     * @param defaultMarkup
     *            the default markup to use in case there is no defined markup for the category of items to be handled
     */
    public MarkupCalculator(float flatMarkup, float personMarkup, Collection<MarkupCategory> markupCategories,
            float defaultMarkup) {
        this.flatMarkup = flatMarkup;
        this.personMarkup = personMarkup;
        this.defaultMarkup = defaultMarkup;
        initMarkupCategories(markupCategories);
    }

    /**
     * Main method which calculates the project cost based on the flat markup, the person markup, the categories and the default markup.
     *
     * @param basePrice
     *            the base price of the project
     * @param numberPeople
     *            the number of people needed to do the job
     * @param category
     *            the category of products that need to be handled
     * @return the total cost of the project
     */
    public BigDecimal calculate(BigDecimal basePrice, int numberPeople, String category) {
        validateBasePrice(basePrice);
        BigDecimal basePriceWithFlatMarkup = calculateBasePriceWithFlatMarkup(basePrice);
        BigDecimal personCost = calculatePersonCost(basePriceWithFlatMarkup, numberPeople);
        BigDecimal markupCategoryCost = calculateMarkupCategoryCost(basePriceWithFlatMarkup, category);
        return calculateFinalCost(basePriceWithFlatMarkup, personCost, markupCategoryCost);
    }

    private void validateBasePrice(BigDecimal basePrice) {
        if (basePrice == null) {
            throw new MarkupCalculatorException("Cannot calculate project cost: base price is invalid = " + basePrice);
        }
    }

    private void initMarkupCategories(Collection<MarkupCategory> markupCategories) {
        if (markupCategories == null) {
            this.markupCategotyNameToCategory = Collections.<String, MarkupCategory> emptyMap();
        } else {
            this.markupCategotyNameToCategory = markupCategories.stream().collect(
                    Collectors.toMap(MarkupCategory::getName, Function.identity()));
        }
    }

    private BigDecimal calculateBasePriceWithFlatMarkup(BigDecimal basePrice) {
        return basePrice.add(basePrice.multiply(new BigDecimal(flatMarkup)));
    }

    private BigDecimal calculatePersonCost(BigDecimal basePriceWithFlatMarkup, int numberPeople) {
        return basePriceWithFlatMarkup.multiply(new BigDecimal(personMarkup * numberPeople));
    }

    private BigDecimal calculateMarkupCategoryCost(BigDecimal basePriceWithFlatMarkup, String category) {
        MarkupCategory markupCategory = markupCategotyNameToCategory.get(category);
        float markupRate = defaultMarkup;
        if (markupCategory != null) {
            markupRate = markupCategory.getMarkup();
        }
        return basePriceWithFlatMarkup.multiply(new BigDecimal(markupRate));
    }

    private BigDecimal calculateFinalCost(BigDecimal basePriceWithFlatMarkup, BigDecimal personCost,
            BigDecimal markupCategoryCost) {
        return basePriceWithFlatMarkup.add(personCost).add(markupCategoryCost).setScale(2, RoundingMode.HALF_UP);
    }
}
