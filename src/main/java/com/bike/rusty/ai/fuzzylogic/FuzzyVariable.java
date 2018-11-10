package com.bike.rusty.ai.fuzzylogic;

public class FuzzyVariable {
    private FuzzyValue low;
    private FuzzyValue med;
    private FuzzyValue high;

    public FuzzyValue getLow() {
        return low;
    }

    public void setLow(FuzzyValue low) {
        this.low = low;
    }

    public FuzzyValue getMed() {
        return med;
    }

    public void setMed(FuzzyValue med) {
        this.med = med;
    }

    public FuzzyValue getHigh() {
        return high;
    }

    public void setHigh(FuzzyValue high) {
        this.high = high;
    }

    public FuzzyVariable() {
        low = new FuzzyValue(0.0f);
        med = new FuzzyValue(0.0f);
        high = new FuzzyValue(0.0f);
    }
}
