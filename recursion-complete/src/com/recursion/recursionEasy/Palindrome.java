package com.recursion.recursionEasy;

public class Palindrome {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(palindrome(n));
    }

    private static boolean palindrome(int n) {
        return n == reverseNumber(n, 0);
    }

    private static int reverseNumber(int n, int ans) {
        if (n == 0) {
            return ans;
        }
        int lastDigit = n % 10;
        ans = ans * 10 + lastDigit;
        return reverseNumber(n / 10, ans);
    }
}
