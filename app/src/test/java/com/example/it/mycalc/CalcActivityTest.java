package com.example.it.mycalc;

import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CalcActivityTest {

    private MainActivity mActivity;
    private ActivityController<MainActivity> mActivityController;

    @Before
    public void initTest() {
        mActivityController = Robolectric.buildActivity(MainActivity.class).create().visible().start().resume();
        mActivity = mActivityController.get();

    }


    @Test
    public void testCalculaor(){

        EditText mFirstEditText = (EditText) mActivity.findViewById(R.id.first_value_edit_text);
        assertNotNull("", mFirstEditText);

        EditText mSecondEditText = (EditText) mActivity.findViewById(R.id.second_value_edit_text);
        assertNotNull("", mSecondEditText);

        boolean isPlusButtonEnabled = mActivity.findViewById(R.id.plus_button).isEnabled();
        assertEquals(isPlusButtonEnabled, true);
        assertTrue(isPlusButtonEnabled);

        boolean isMinusButtonEnabled = mActivity.findViewById(R.id.minus_button).isEnabled();
        assertEquals(isMinusButtonEnabled, true);
        assertTrue(isMinusButtonEnabled);

        boolean isMultiplyButtonEnabled = mActivity.findViewById(R.id.multiply_button).isEnabled();
        assertEquals(isMultiplyButtonEnabled, true);
        assertTrue(isMultiplyButtonEnabled);

        boolean isDevideButtonEnabled = mActivity.findViewById(R.id.devide_button).isEnabled();
        assertEquals(isDevideButtonEnabled, true);
        assertTrue(isDevideButtonEnabled);

        boolean isCButtonEnabled = mActivity.findViewById(R.id.c_button).isEnabled();
        assertEquals(isCButtonEnabled, true);
        assertTrue(isCButtonEnabled);

        TextView mResultTextView = (TextView) mActivity.findViewById(R.id.result_text_view);
        assertNotNull("", mResultTextView);
    }

    @After
    public void destroyActivity(){
        mActivityController.pause().stop().destroy();
    }

}
