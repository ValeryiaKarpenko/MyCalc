package com.example.it.mycalc;


class Calc {

    int plus(int a, int b) {
        return a + b;
    }

    int min(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Divide by 0");
            return 0;
        }
    }

}
