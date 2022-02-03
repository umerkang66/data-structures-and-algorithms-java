package com.umerkang.recursionIntroduction;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    // Time complexity is golden-ratio ^ N (2 ^ N)
    private static int fibonacci(int n) {
        if (n <= 1) {
            // For number 0, 1, 2 their fibonacci numbers will also be 0, 1, 1
            // respectively we don't need to calculate here
            return n;
        }
        // When we return from the recursive function call, they actually become the
        // value of the functions from they are returned, and can be accessed from
        // where the function was called
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
