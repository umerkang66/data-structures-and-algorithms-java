package com.recursion.recursionIntroduction;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(fibonacciIterative(7));
    }

    private static int fibonacci(int n) {
        // For number 0, 1, 2 their fibonacci numbers will also be 0, 1, 1
        // respectively we don't need to calculate here
        // we can also do for n==2, but let's just calculate for n==2
        if (n == 0 || n == 1) {
            return n;
        }
        // When we return from the recursive function call, they actually become the
        // value of the functions from they are returned, and can be accessed from
        // where the function was called
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int fibonacciIterative(int n) {
        // for 0, answer will be 0, for 1 answer will be 1,
        // It is actually number 2, that we have calculate from.
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int currentAns = first + second;
            first = second;
            second = currentAns;
        }
        return second;
    }
}
