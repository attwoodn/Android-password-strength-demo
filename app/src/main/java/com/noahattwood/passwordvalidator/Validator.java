package com.noahattwood.passwordvalidator;

public class Validator {

    private static final int NUM_RULES = 2;
    private static final int MIN_LEN = 8;

    public int validate(String password){

        int numRules = NUM_RULES;

        if (password.equalsIgnoreCase("password")){
            numRules --;
        }

        if (password.length() < MIN_LEN){
            numRules --;
        }

        return numRules;
    }
}
