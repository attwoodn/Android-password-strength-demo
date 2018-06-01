package com.noahattwood.passwordvalidator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    private Validator passwordValidator;

    @Before
    public void setupTest(){
        passwordValidator = new Validator();
    }

    @Test
    public void testWeakPassword(){
        assertEquals(Validator.PasswordStrength.WEAK, passwordValidator.validate("password"));
        assertEquals(Validator.PasswordStrength.WEAK, passwordValidator.validate("PASSWORD"));
        assertEquals(Validator.PasswordStrength.WEAK, passwordValidator.validate("PaSsWoRd"));
        assertEquals(Validator.PasswordStrength.WEAK, passwordValidator.validate("short"));
        assertEquals(Validator.PasswordStrength.WEAK, passwordValidator.validate("h3h3"));
        assertEquals(Validator.PasswordStrength.WEAK, passwordValidator.validate("shadow"));
    }

    @Test
    public void testMediumPassword(){
        assertEquals(Validator.PasswordStrength.MEDIUM, passwordValidator.validate("AbCd?"));
        assertEquals(Validator.PasswordStrength.MEDIUM, passwordValidator.validate("Hunter2"));
        assertEquals(Validator.PasswordStrength.MEDIUM, passwordValidator.validate("shadow5525"));
    }

    @Test
    public void testStrongPassword(){
        assertEquals(Validator.PasswordStrength.STRONG, passwordValidator.validate("Abcde123***?"));
        assertEquals(Validator.PasswordStrength.STRONG, passwordValidator.validate("NewElderScrollsGamePls!$"));
        assertEquals(Validator.PasswordStrength.STRONG, passwordValidator.validate("thisIs$trong4#"));
    }
}
