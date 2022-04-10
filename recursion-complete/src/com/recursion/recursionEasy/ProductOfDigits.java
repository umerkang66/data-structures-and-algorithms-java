package com.recursion.recursionEasy;

public class ProductOfDigits {
    public static void main(String[] args) {
        int n = 13402;
        System.out.println(productOfDigits(n));
    }

    private static int productOfDigits(int n) {
        if (n == 0) {
            // Don't return 0 here, because if 0 is multiplied with anything, the whole
            // answer will become zero
            return 1;
        }
        return n % 10 * productOfDigits(n / 10);
    }
}
