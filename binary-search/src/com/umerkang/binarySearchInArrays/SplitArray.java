package com.umerkang.binarySearchInArrays;
// https://leetcode.com/problems/split-array-largest-sum/

public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int timesToSplit = 2;
        System.out.println(splitArray(nums, timesToSplit));
    }

    private static int splitArray(int[] nums, int m) {
        // Explanation of this algorithm in Book Allocation Problem
        int start = 0;
        int end = 0;
        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    sum = num;
                    pieces++;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
