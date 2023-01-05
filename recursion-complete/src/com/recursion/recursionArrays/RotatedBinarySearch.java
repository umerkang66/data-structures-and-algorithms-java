package com.recursion.recursionArrays;

import java.util.Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(binarySearch(nums, target, 0, nums.length - 1));
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        // In rotatedArray, there are two ascending sorted arrays
        // If there is only one element in the array, and it is also
        // mid, in that case we are also handling here
        if (nums[start] <= nums[mid]) {
            // if mid is in the first sorted part of array, then if target is
            // present between start and mid, apply binary search to only this
            // part (start to mid)
            if (target >= nums[start] && target < nums[mid]) {
                return binarySearch(nums, target, start, mid - 1);
            }
            // if mid is present in first sorted part of array, but element is
            // not present in it, then apply binary search to the remaining
            // part of first sorted array to the end (including second part of
            // sorted array) that is from mid + 1, to end
            return binarySearch(nums, target, mid + 1, end);
        }
        // if mid is in the second sorted array, then the same upper login applies here
        if (target > nums[mid] && target <= nums[end]) {
            return binarySearch(nums, target, mid + 1, end);
        }
        return binarySearch(nums, target, start, mid - 1);
    }
}
