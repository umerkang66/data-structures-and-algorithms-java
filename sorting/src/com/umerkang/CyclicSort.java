package com.umerkang;

import java.util.Arrays;

// Whenever you are provided by the range of 1 to N type questions use cyclic sort
public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 2, 4};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void cyclicSort(int[] nums) {
        // Start the pointer with 0
        int start = 0;
        while (start < nums.length) {
            // Because the numbers in array starts from 1, so the correctIndex cannot
            // be same as the number element in array, but is going to be subtracted
            // by 1
            int correctIndex = nums[start] - 1;
            // If currentElement of in the loop (nums[start]) != the element that is
            // present at the correctIndex of (nums[start]), then swap the both
            // elements, and by swapping one by one in the loop, whole array sorts
            if (nums[start] != nums[correctIndex]) {
                // Don't move loop forward if nums[start] becomes equal to
                // nums[correctIndex], keep checking on the same index until the
                // currentIndex (start) has the correct element placed on it
                swap(nums, start, correctIndex);
            } else {
                // If the element is at its correctIndex just move the loop to the
                // next position
                start++;
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
