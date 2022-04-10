package com.recursion.recursionIntroduction;

public class NumbersExample {
    public static void main(String[] args) {
        print(1);
    }

    // Each function is a separate function call in the call stack
    // When the nested functions will be called
    private static void print(int n) {
        // Base Condition
        // If no base condition, function keeps calling, stackoverflow
        if (n >= 5) {
            // This function will return from where it was called
            return;
        }
        System.out.println(n);
        // This is called tail recursion, because this is the last recursion call
        print(n + 1);
    }
}
