package com.noahattwood.passwordvalidator;

import android.graphics.Color;

public class Validator {

    public enum PasswordStrength {
        WEAK(Color.RED),
        MEDIUM(Color.YELLOW),
        STRONG(Color.GREEN);

        public final int colour;

        PasswordStrength(int colour){
            this.colour = colour;
        }

        /**
         * Takes a percentage value from 0.0-1.0 and returns the corresponding password strength
         * @param percentage - the number of rules that the password passed
         * @return WEAK, MEDIUM, or STRONG
         */
        public static PasswordStrength getStrength (double percentage){
            if (percentage <= 0.5){
                return WEAK;
            } else if (percentage <= 0.75){
                return MEDIUM;
            } else {
                return STRONG;
            }
        }
    }

    private static final int NUM_RULES = 5;
    private static final int MIN_LEN = 8;

    public PasswordStrength validate(String password){

        int numRules = NUM_RULES;

        if (password.equalsIgnoreCase("password")){
            numRules --;
        }

        if (password.length() < MIN_LEN){
            numRules --;
        }

        // Special characters
        if (!password.matches(".*[!@#$%^&*?~].*")){
            numRules --;
        }

        // Numbers
        if (!password.matches(".*[0-9].*")){
            numRules --;
        }

        // Uppercase and lowercase characters
        if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")){
            numRules --;
        }

        double strengthPerc = numRules / (double) NUM_RULES;
        return PasswordStrength.getStrength(strengthPerc);
    }
}
