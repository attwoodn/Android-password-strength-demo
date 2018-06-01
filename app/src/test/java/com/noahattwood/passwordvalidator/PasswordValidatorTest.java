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
    public void testBadPassword(){
        assertEquals(1, passwordValidator.validate("password"));
        assertEquals(1, passwordValidator.validate("PASSWORD"));
        assertEquals(1, passwordValidator.validate("PaSsWoRd"));
    }

    @Test
    public void testShortPassword(){
        assertEquals(1, passwordValidator.validate("short"));
        assertEquals(1, passwordValidator.validate("1"));
        assertEquals(1, passwordValidator.validate(""));
    }
}
