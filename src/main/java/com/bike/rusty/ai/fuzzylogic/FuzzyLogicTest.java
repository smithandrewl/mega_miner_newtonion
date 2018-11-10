package com.bike.rusty.ai.fuzzylogic;

public class FuzzyLogicTest  {
    public static void main(String[] args) {
        System.out.println("Low, Med, High");

        for(int i = 0; i < 101; i++) {
            FuzzyVariable output = FuzzyMembership.grade(i, 0.0f, 100.0f);

            System.out.println(String.format("%f, %f, %f", output.getLow().getValue(), output.getMed().getValue(), output.getHigh().getValue()));
        }
    }
}
