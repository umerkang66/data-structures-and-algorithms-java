package com.umerkang.binarySearchInArrays;

public class SearchNearlySortedArray {
    public static void main(String[] args) {
        // Nearly sorted means the target can be at mid, mid + 1, or mid - 1
        int[] nums = {5, 10, 30, 20, 40};
        int target = 40;

        System.out.println(nearlySortedBinarySearch(nums ,target));
    }

    private static int nearlySortedBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (mid < end && target == nums[mid + 1]) {
                return mid + 1;
            } else if (mid > start && target == nums[mid - 1]) {
                return mid - 1;
            }
            // We have to move by 2 elements either left or right
            if (target < nums[mid]) {
                end = mid - 2;
            } else if (target > nums[mid]) {
                start = mid + 2;
            }
        }
        return -1;
    }
}
