package com.noahattwood.passwordvalidator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EspressoPasswordTest {

    private ViewInteraction validateButton;
    private ViewInteraction passwordTextField;
    private ViewInteraction strengthTextField;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void grabUiReferences(){
        validateButton = onView(withId(R.id.validateButton));
        passwordTextField = onView(withId(R.id.passwordTextField));
        strengthTextField = onView(withId(R.id.strengthTextField));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.noahattwood.passwordvalidator", appContext.getPackageName());
    }

    @Test
    public void typeWeakPassword() {
        passwordTextField.perform(typeText("password"));
        ViewActions.closeSoftKeyboard();

        validateButton.perform(click());

        strengthTextField.check(matches(withText("WEAK")));
    }

    @Test
    public void typeMediumPassword() {
        passwordTextField.perform(typeText("Hunter2"));
        ViewActions.closeSoftKeyboard();

        validateButton.perform(click());

        strengthTextField.check(matches(withText("MEDIUM")));
    }

    @Test
    public void typeStrongPassword() {
        passwordTextField.perform(typeText("thisIs$trong4#"));
        ViewActions.closeSoftKeyboard();

        validateButton.perform(click());

        strengthTextField.check(matches(withText("STRONG")));
    }
}
