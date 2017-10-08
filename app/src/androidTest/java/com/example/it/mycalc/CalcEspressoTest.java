package com.example.it.mycalc;

import android.content.Intent;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class CalcEspressoTest {

    private ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);

    private void pCheckResult(final String val){
        onView(withId(R.id.result_text_view)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!((TextView) view).getText().toString().equals(val)) {
                    throw new IllegalStateException("result wrong.");
                }
            }
        });
    }

    @Test
    public void testActivityRun() {
        mActivity.launchActivity(new Intent());

        onView(withId(R.id.first_value_edit_text)).perform(typeText("1"));
        onView(withId(R.id.second_value_edit_text)).perform(typeText("2"));

        ViewInteraction mPlusButton = onView(withId(R.id.plus_button));
        mPlusButton.check(matches(isEnabled()));
        mPlusButton.perform(click());
        pCheckResult("3.0");

        ViewInteraction mMinusButton = onView(withId(R.id.minus_button));
        mMinusButton.check(matches(isEnabled()));
        mMinusButton.perform(click());
        pCheckResult("-1.0");

        ViewInteraction mMultiplyButton = onView(withId(R.id.multiply_button));
        mMultiplyButton.check(matches(isEnabled()));
        mMultiplyButton.perform(click());
        pCheckResult("2.0");

        ViewInteraction mDevideButton = onView(withId(R.id.devide_button));
        mDevideButton.check(matches(isEnabled()));
        mDevideButton.perform(click());
        pCheckResult("0.5");
    }


}