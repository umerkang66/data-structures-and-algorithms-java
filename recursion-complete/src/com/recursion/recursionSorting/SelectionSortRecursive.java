package com.recursion.recursionSorting;

import java.util.Arrays;

public class SelectionSortRecursive {
    public static void main(String[] args) {
        int[] nums = {33, 12, 56, 9, 6, 11, 99, 30};
        sort(nums, nums.length - 1, 0, 0);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int a, int b, int max) {
        if (a == 0) {
            return;
        }
        if (b <= a) {
            // Because we passed nums.length - 1 as "a" (a is last element), and we will
            // iterate (recurse actually) using b, that will always be till the last
            // index element
            if (nums[b] > nums[max]) {
                // If "b" (through which we are iterating) is greater than max element
                // then "b" element becomes max element, and being pass through to the
                // next function call as max parameter
                // "b + 1" means move to the next element
                sort(nums, a, b + 1, b);
            } else {
                // "b + 1" means move to the next element
                // "b" element is less than max element, so actual max element should
                // be passed as the max parameter
                sort(nums, a, b + 1, max);
            }
            return;
        }
        // If "b" is not smaller or equal than "a" (length - 1), it means "b" has already
        // iterated over the array, and found the max element
        // Swap it with the last possible element, respectively ("'a' index" is the
        // last possible element)
        swap(nums, a, max);
        // Then again start sorting, but here this should be the next (first for
        // loop in iterative method), and start the second (for loop) recursive
        // iteration from zero
        sort(nums, a - 1, 0, 0);
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
