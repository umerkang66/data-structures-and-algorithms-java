package com.umerkang.recursionArrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 5, 8, 11, 15, 21, 9};
        System.out.println(sortedArray(nums, 0));
    }

    private static boolean sortedArray(int[] nums, int i) {
        if (i == nums.length - 1) {
            // If index is equal to last index of array, means recursion loop has
            // reached the last element of array, means array is sorted
            return true;
        }
        // Only if this comparison is true, run the next one, and this i + 1, will
        // never be out of bounds
        return nums[i] < nums[i + 1] && sortedArray(nums, ++i);
    }
}
