package com.umerkang.cyclicSortQuestions;
// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int missingPositive = missing(nums);
        System.out.println(missingPositive);
    }

    private static int missing(int[] nums) {
        // Ignore negatives because positive numbers are asked
        // Start checking from one, zero is not included because zero can be positive
        // or negative
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            // Start checking from 1 till the element that is equal to nums.length
            // because number starting from one, then largest number will equal to the
            // length of array, ignore the elements are that are greater than nums.length
            // Zero should not be included
            if (nums[start] > 0 && nums[start] <= nums.length && nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        // After the array is sorted, it will start from 1, and all the other elements
        // that are out of range should be present in the array but not according to
        // their correct index, hence we can find them and return accordingly (number
        // that is missing)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                // The first element that is not equal to its correctIndex, return it
                return i + 1;
            }
        }
        // If all the elements are sorted and present in the array, return the element
        // that is the largest element + 1
        return nums.length + 1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
