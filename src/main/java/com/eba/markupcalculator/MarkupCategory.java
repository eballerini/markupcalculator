package com.eba.markupcalculator;

/**
 * Represents a markup name with the name which is the identifier and the markup
 */
public class MarkupCategory {
    private String name;
    private float markup;

    public MarkupCategory(String name, float markup) {
        this.name = name;
        this.markup = markup;
    }

    public String getName() {
        return name;
    }

    public float getMarkup() {
        return markup;
    }
}
