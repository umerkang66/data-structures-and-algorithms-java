package com.recursion.recursionEasy;

public class Palindrome {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(palindrome(n));
    }

    private static boolean palindrome(int n) {
        int numLength = (int) (Math.log10(n) + 1);
        return n == reverseNumber(n, numLength);
    }

    private static int reverseNumber(int n, int numLength) {
        // Explanation is in reverseNumber question
        if (n / 10 <= 0) {
            return n;
        }
        int remainder = n % 10;
        return remainder * (int) Math.pow(10, numLength - 1) + reverseNumber(n / 10,
            numLength - 1);
    }
}
