package com.recursion.recursionArrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 5, 0, nums.length - 1));
    }

    private static int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        // In rotatedArray, two arrays are two ascending sorted arrays are created
        if (nums[start] <= nums[mid]) {
            // if mid is in the first sorted part of array, then if target is
            // present between start and mid, apply binary search to only this
            // part (start to mid)
            if (target >= nums[start] && target <= nums[mid]) {
                return search(nums, target, start, mid);
            }
            // if mid is present in first sorted part of array, but element is
            // not present in it, then apply binary search to the remaining
            // part of first sorted array to the end (including second part of
            // sorted array) that is from mid + 1, to end
            return search(nums, target, mid + 1, end);
        }
        // if mid is in the second sorted part of array, then the same upper login applies here
        if (target >= nums[mid] && target <= nums[end]) {
            return search(nums, target, mid + 1, end);
        }
        return search(nums, target, start, mid - 1);
    }
}
