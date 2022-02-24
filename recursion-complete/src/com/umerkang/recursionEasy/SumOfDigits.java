package com.umerkang.recursionEasy;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 1342;
        System.out.println(sumOfDigits(n));
    }

    private static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }
}
