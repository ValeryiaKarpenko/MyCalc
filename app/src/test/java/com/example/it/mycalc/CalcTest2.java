package com.example.it.mycalc;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static junit.framework.Assert.assertSame;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
public class CalcTest2 {
    @InjectMocks
    private MainActivity mActivity;
    private Calc mCalc;
    @Mock
    private Calc CalcObj;

    @Before
    public void create(){
        CalcObj = mock(Calc.class);
        mCalc = spy(Calc.class);
        when(CalcObj.plus(1, 2)).thenReturn(3);
        when(CalcObj.plus(0, 2)).thenReturn(2);
        when(CalcObj.plus(-1, 2)).thenReturn(1);
        when(CalcObj.min(2,1)).thenReturn(1);
        when(CalcObj.min(-1,1)).thenReturn(-2);
        when(mCalc.multiply(anyInt(),eq(0))).thenReturn(0);
        when(mCalc.divide(anyInt(),eq(0))).thenThrow(new ArithmeticException());

    }

    @Test(expected = ArithmeticException.class)
    public void test(){
        assertSame(3,CalcObj.plus(1,2));
        assertSame(2,CalcObj.plus(0,2));
        assertSame(1,CalcObj.plus(-1,2));
        assertSame(1,CalcObj.min(2,1));
        assertSame(-2,CalcObj.min(-1,1));
        assertSame(mCalc.multiply(2,0),0);
        mCalc.divide(1,0);
    }



}

