package com.umerkang;

import java.util.Arrays;

// Time Complexity: Worst Case O(N^2)
// Select an Element and put it at its correct index (swap with the element that is
// present on the correct index)
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 2, 0, 0, 1, 9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // First the largest element's index and its correctIndex, then swap them
            // both, then find the second largest and its correct index, then swap and
            // so on, so on, till all the array is sorted
            int correctLastIndex = nums.length - i - 1;
            int largestNumInUnsortedArrIndex = getLargestNumInUnsortedArray(nums, i);
            swap(nums, largestNumInUnsortedArrIndex, correctLastIndex);
        }
    }

    // Get the largest element, but not return that was the largest in the previous
    // loop, that's why we use the index of first loop, that will be minus (-) from the
    // nums length, because the largest element from the previous loop will be at last,
    // that will be ignored if we subtract the index of first loop from nums.length
    private static int getLargestNumInUnsortedArray(int[] nums, int i) {
        int maxElement = Integer.MIN_VALUE;
        int maxElementIndex = -1;
        for (int j = 0; j < nums.length - i; j++) {
            if (nums[j] > maxElement) {
                maxElement = nums[j];
                maxElementIndex = j;
            }
        }
        return maxElementIndex;
    }

    // Swap the two elements from nums
    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
