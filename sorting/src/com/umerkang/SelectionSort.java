package com.umerkang;

import java.util.Arrays;

// Time Complexity: Worst Case O(N^2) also Best Case: O(N^2)
// Select an Element and put it at its correct index (swap with the element that is
// present on the correct index)
// It is not a Stable Algorithm
// It performs well on small pieces
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
            // CorrectLastIndex is the lastIndex of unsorted array (Important! not sorted
            // array), hence we have to find the maximum in array till this
            // correctLastIndex because after this all the elements are already sorted
            int maxIndex = getMaxIndex(nums, correctLastIndex);
            // Swap the both elements at given indexes
            swap(nums, maxIndex, correctLastIndex);
        }
    }

    private static int getMaxIndex(int[] nums, int end) {
        // As start is always start from 0
        int start = 0;
        // First put the max whatever the first element is
        int max = start;
        // Start the loop from start till end (end included), end is already subtracted
        // "i" and "1" from nums.length, so it will not be indexed out of bounds
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    // Swap the two elements from nums
    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
