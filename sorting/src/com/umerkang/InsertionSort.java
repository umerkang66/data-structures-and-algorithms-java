package com.umerkang;

import java.util.Arrays;

// For every index: put that element in the correct index of left-hand side
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 1, 2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        // We have to decrease the "i" by 1 from the length - 1 (< length) because "j"
        // is considered as i + 1, if "i" will point to the last element, "j" will
        // become index out of bounds
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                // This loop will run from next element from i, and starts the loop to
                // previous element till it reaches 0 + 1, because it checks for j - 1
                // element in the array. It checks if the element is smaller than the
                // previous element is just swap it till it reaches the start of the
                // array.
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    // If j is not smaller than j - 1 (it is sorted) we know that all
                    // the elements before that should also be sorted, because that's
                    // what we did in the upper if block, we can break the loop here
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
