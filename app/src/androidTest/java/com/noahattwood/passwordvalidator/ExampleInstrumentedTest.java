package com.noahattwood.passwordvalidator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

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
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.noahattwood.passwordvalidator", appContext.getPackageName());
    }

    @Test
    public void typeWeakPassword() {
        ViewInteraction validateButton = onView(withId(R.id.validateButton));
        ViewInteraction passwordTextField = onView(withId(R.id.passwordTextField));
        ViewInteraction strengthTextField = onView(withId(R.id.strengthTextField));

        passwordTextField.perform(typeText("password"));

        validateButton.perform(click());

        strengthTextField.check(matches(withText("WEAK")));
    }
}
