package com.example.healthcalculator;

public class Utilities {
    public static Float FloatSafe(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return Float.NaN;
        }
    }
}
