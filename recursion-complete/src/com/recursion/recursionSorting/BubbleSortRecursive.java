package com.recursion.recursionSorting;

import java.util.Arrays;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int[] nums = {33, 12, 56, 9, 6, 11, 99, 30};
        bubbleSortRecursive(nums, nums.length - 1, 0);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSortRecursive(int[] nums, int a, int b) {
        // Here we are checking the last element that is at index 0, but in bubble
        // sort, last element is always in sorted position, we don't need to do this.
        // BUT here we are just doing it
        if (a == -1) {
            return;
        }
        if (b < a) {
            // "b" should be less than "a" (lastIndex) because we check for the element
            // at index "b + 1"
            if (nums[b] > nums[b + 1]) {
                swap(nums, b, b + 1);
            }
            bubbleSortRecursive(nums, a, b + 1);
        }
        bubbleSortRecursive(nums, a - 1, 0);
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
