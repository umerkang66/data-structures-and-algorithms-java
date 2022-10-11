package com.recursion.recursionArrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 5, 8, 11, 15, 21};
        System.out.println(isSortedArray(nums, 0));
    }

    private static boolean isSortedArray(int[] nums, int i) {
        if (i == nums.length - 1) {
            // If index is equal to last index of array, means
            // recursion loop has reached the last element of
            // array, means array is sorted.
            // don't have to check the last element
            return true;
        }
        // Only if this comparison is true, run the next one,
        // and this i + 1, will never be out of bounds
        return nums[i] < nums[i + 1] && isSortedArray(nums, i + 1);
    }
}
