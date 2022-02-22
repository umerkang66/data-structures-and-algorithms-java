package com.umerkang;

public class FindUnique {
    public static void main(String[] args) {
        int[] nums = {1, 8, 3, 7, 8, 3, 1, 7, 9};
        System.out.println(findUnique(nums));
    }

    private static int findUnique(int[] nums) {
        // xorResult can be also called as unique
        // When we xor a number with that number, this will return 0
        // When we xor a number with 0, it will return that number,
        // When we xor a number with 1, it will give complement of that number
        // When we will xor entire array one by one, it will duplicate will return 0,
        // then 0 ^ to the non-duplicate will return that number (that is not duplicate)
        int xorResult = 0;
        for (int n : nums) {
            xorResult ^= n;
        }
        return xorResult;
    }
}
