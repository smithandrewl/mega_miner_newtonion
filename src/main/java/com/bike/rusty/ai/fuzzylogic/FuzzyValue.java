package com.bike.rusty.ai.fuzzylogic;

public class FuzzyValue {
    private float value;

    public FuzzyValue(float value) {
        this.value = value;
    }
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public FuzzyValue and(FuzzyValue other) {
        return new FuzzyValue(Math.min(value, other.getValue()));
    }

    public FuzzyValue or(FuzzyValue other) {
        return new FuzzyValue(Math.max(value, other.getValue()));
    }

    public FuzzyValue not() {
        return new FuzzyValue(1.0f - value);
    }
}
