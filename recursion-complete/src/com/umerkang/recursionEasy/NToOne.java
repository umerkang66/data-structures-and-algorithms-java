package com.umerkang.recursionEasy;

public class NToOne {
    public static void main(String[] args) {
        int n = 5;
        both(n);
    }

    private static void nToOne(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        nToOne(n - 1);
    }

    private static void oneToN(int n) {
        if (n == 0) {
            return;
        }
        oneToN(n - 1);
        // Run this when you are emptying the stack after the last function has
        // returned meaning (n == 0)
        System.out.println(n);
    }

    private static void both(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        both(n - 1);
        System.out.println(n);
    }
}
