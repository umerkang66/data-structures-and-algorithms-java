package com.umerkang.binarySearchInArrays;
// https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountainArr {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 3, 2};
        int target = 5;
        int searchedIndex = findInMountainArr(nums, target);
        System.out.println(searchedIndex);
    }

    private static int findInMountainArr(int[] nums, int target) {
        int peak = peakIndexMountainArr(nums);
        int search = orderAgnosticBinarySearch(nums, target, 0, peak);
        if (search == -1) {
            // If it didn't find, find it on the right side of peak
            search = orderAgnosticBinarySearch(nums, target, peak + 1,
                nums.length - 1);
        }
        return search;
    }

    private static int peakIndexMountainArr(int[] nums) {
        // Explanation of this algorithm is in PeakIndexMountainArr
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end) {
        boolean isAscending = nums[start] < nums[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (isAscending) {
                if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
