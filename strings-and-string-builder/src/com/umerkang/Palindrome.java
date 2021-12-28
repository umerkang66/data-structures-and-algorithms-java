package com.umerkang;

public class Palindrome {
    public static void main(String[] args) {
        String str = "tibit";
        boolean isPalindrome = palindrome(str);
        System.out.println(isPalindrome);
    }

    private static boolean palindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
