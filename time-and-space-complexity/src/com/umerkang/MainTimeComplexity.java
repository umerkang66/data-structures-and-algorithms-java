package com.umerkang;

public class MainTimeComplexity {
    public static void main(String[] args) {
        int fib = fibonacci(7);
        System.out.println(fib);

        int fibIterative = fibonacciIterative(7);
        System.out.println(fibIterative);
    }

    private static int fibonacci(int m) {
        // Explanation of this algorithm is in the Recursion Basic
        if (m <= 1) {
            return m;
        }
        return fibonacci(m - 1) + fibonacci(m - 2);
    }

    // This is much resource friendlier than recursive approach
    private static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        // This fib can be for value 2
        int fib = 1;
        // This fib can be for previous value than 2 i.e. 1
        // The fib of one is also one
        int previousFib = 0;
        for (int i = 2; i <= n; i++) {
            int temp = fib;
            // Fib at a certain value is actually fibonacci of previous 2 values
            fib += previousFib;
            previousFib = temp;
        }
        return fib;
    }
}
