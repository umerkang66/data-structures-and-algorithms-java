package com.recursion.recursionEasy;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 1342;
        System.out.println(sumOfDigitsRecursive(n));
        System.out.println(sumOfDigitsIterative(n));
    }

    private static int sumOfDigitsRecursive(int n) {
        if (n==0) {
            return 0;
        }
        return n % 10 + sumOfDigitsRecursive(n / 10);
    }

    private static int sumOfDigitsIterative(int n) {
        int sum = 0;
        while (n != 0) {
            // getting the last digit
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
