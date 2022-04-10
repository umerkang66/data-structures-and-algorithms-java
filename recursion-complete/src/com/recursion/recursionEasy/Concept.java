package com.recursion.recursionEasy;

public class Concept {
    public static void main(String[] args) {
        fun(5);
    }

    private static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        // This one will pass the value first, then subtract it
        // fun(n--);
        // This one subtract the value first, then pass the value
        fun(--n);
    }
}
