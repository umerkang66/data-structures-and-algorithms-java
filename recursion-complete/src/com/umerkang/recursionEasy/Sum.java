package com.umerkang.recursionEasy;

public class Sum {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        if (n <= 1) {
            // Don't further run the functions when n becomes 1
            return 1;
        }
        return n + sum(n - 1);
    }
}
