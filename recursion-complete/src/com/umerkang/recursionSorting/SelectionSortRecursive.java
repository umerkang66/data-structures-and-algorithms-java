package com.umerkang.recursionSorting;

import java.util.Arrays;

public class SelectionSortRecursive {
    public static void main(String[] args) {
        int[] nums = {33, 12, 56, 9, 6, 11, 99, 30};
        sort(nums, nums.length, 0, 0);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int a, int b, int max) {
        if (a == 0) {
            return;
        }
        if (b < a) {
            if (nums[b] > nums[max]) {
                sort(nums, a, b + 1, b);
            } else {
                sort(nums, a, b + 1, max);
            }
        } else {
            swap(nums, a - 1, max);
            sort(nums, a - 1, 0, 0);
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
