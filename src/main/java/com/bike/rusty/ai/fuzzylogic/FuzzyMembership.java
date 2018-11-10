package com.bike.rusty.ai.fuzzylogic;

public class FuzzyMembership {
    private FuzzyMembership() {}

    public static float triangle(float value, float lowerLimit, float upperLimit, float middle) {
        if(value <= lowerLimit) return 0f;

        if((lowerLimit < value) && (value <= middle)) {
            return (value-lowerLimit)/(middle-lowerLimit);
        }

        if((middle<value) && (value<upperLimit)) {
            return (upperLimit - value) / (upperLimit - middle);
        }

        if(value >= upperLimit) {
            return 0f;
        }

        return 0f;
    }

    public static float left(float value, float upperLimit, float upperSupportLimit) {
        if(value > upperLimit) return 0.0f;

        if((upperSupportLimit <= value) && (value <=upperLimit)) {
            return (upperLimit - value) / (upperLimit - upperSupportLimit);
        }

        if(value < upperSupportLimit) {
            return 1.0f;
        }

        return 0.0f;
    }

    public static float right(float value, float lowerLimit, float lowerSupportLimit) {
        if(value < lowerLimit) return 0.0f;
        if((lowerLimit<=value)&& (value<= lowerSupportLimit)) return (value-lowerLimit)/(lowerSupportLimit-lowerLimit);
        if(value>lowerSupportLimit) return 1.0f;

        return 0.0f;
    }

    public static FuzzyVariable grade(float value, float low, float high) {


        float middle = (high - low) / 2.0f;

        FuzzyValue medValue  = new FuzzyValue(triangle(value, middle / 2.0f, middle + (middle / 2.0f), middle));
        FuzzyValue lowValue  = new FuzzyValue(left(value, middle, middle / 2.0f));
        FuzzyValue highValue = new FuzzyValue(right(value, middle, middle + (middle / 2.0f)));

        FuzzyVariable result = new FuzzyVariable();

        result.setLow(lowValue);
        result.setMed(medValue);
        result.setHigh(highValue);

        return result;
    }
}
