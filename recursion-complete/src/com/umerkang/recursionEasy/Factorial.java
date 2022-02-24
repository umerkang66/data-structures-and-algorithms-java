package com.umerkang.recursionEasy;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        // factorial of 5 is 5 * 4 * 3 * 2 * 1
        if (n <= 1) {
            // At n == 0, we don't want to manipulate the result
            // Because we are multiplying, so return 1, because any number * 1 ==
            // any number
            return 1;
        }
        return n * factorial(n - 1);
    }
}
