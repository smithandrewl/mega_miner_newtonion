package com.bike.rusty.ai.fuzzylogic;

public class FuzzyMembership {
    private FuzzyMembership() {}

    public float triangle(float x, float a, float b, float m) {
        if(x <= a) return 0f;

        if((a < x) && (x <= m)) {
            return (x-a)/(m-a);
        }

        if((m<x) && (x<b)) {
            return (b - x) / (b - m);
        }

        if(x >= b) {
            return 0f;
        }

        return 0f;
    }

    public float left(float x, float d, float c) {
        if(x > d) return 0.0f;

        if((c <= x) && (x <=d)) {
            return (d - x) / (d - c);
        }

        if(x < c) {
            return 1.0f;
        }

        return 0.0f;
    }

    public float right(float x, float a, float b) {
        if(x < a) return 0.0f;
        if((a<=x)&& (x<= b)) return (x-a)/(b-a);
        if(x>b) return 1.0f;

        return 0.0f;
    }
}
