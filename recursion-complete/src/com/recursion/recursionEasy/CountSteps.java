package com.recursion.recursionEasy;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class CountSteps {
    public static void main(String[] args) {
        // Count the steps to reduce a number to zero
        int n = 14;
        System.out.println(countSteps(n, 0));
    }

    private static int countSteps(int n, int stepNum) {
        if (n == 0) {
            return stepNum;
        }
        // To reduce the number to zero, if the num is divisible by 2, then divide it,
        // otherwise subtract that number with 1
        if (n % 2 == 0) {
            return countSteps(n / 2, stepNum + 1);
        }
        return countSteps(n - 1, stepNum + 1);
    }
}
