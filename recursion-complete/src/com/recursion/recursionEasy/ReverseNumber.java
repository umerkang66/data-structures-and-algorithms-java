package com.recursion.recursionEasy;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 3821;
        int numDigits = (int) Math.log10(n) + 1;

        System.out.println(reverseNumber(n, numDigits));
        System.out.println(reverseNumber2(n, 0));
    }

    private static int reverseNumber(int n, int numDigits) {
        if (numDigits == 1) {
            return n;
        }
        int lastDigit = n % 10;
        // add last digit in the beginning, and reverse the other elements
        // get the first digit to the numDigits place
        int firstDigitToAdd = lastDigit * (int) Math.pow(10, numDigits - 1);
        return firstDigitToAdd + reverseNumber(n / 10, numDigits - 1);
    }

    private static int reverseNumber2(int n, int ans) {
        if (n == 0) {
            return ans;
        }
        int lastDigit = n % 10;
        // add the last digit to the ans in the next 10th position,
        // so multiply the ans with 10, to add the next 10th position,
        // then add the correct number
        ans = ans * 10 + lastDigit;
        return reverseNumber2(n / 10, ans);
    }
}
