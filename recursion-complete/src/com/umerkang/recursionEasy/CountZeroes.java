package com.umerkang.recursionEasy;

public class CountZeroes {
    public static void main(String[] args) {
        int n = 302140900;
        System.out.println(countZeroes(n, 0));
    }

    private static int totalRecursionCount = 1;

    private static int countZeroes(int n, int totalZeroes) {
        if (totalRecursionCount == 1 && n == 0) {
            return 1;
        }
        if (n == 0) {
            // This base case explanation is in the reverseNumber question
            return totalZeroes;
        }
        int remainder = n % 10;
        if (remainder == 0) {
            totalRecursionCount++;
            return countZeroes(n / 10, totalZeroes + 1);
        }
        totalRecursionCount++;
        return countZeroes(n / 10, totalZeroes);
    }
}
