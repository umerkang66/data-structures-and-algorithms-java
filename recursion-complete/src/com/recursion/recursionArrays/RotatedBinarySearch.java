package com.recursion.recursionArrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(rotatedBinarySearch(nums, 9, 0, nums.length - 1));
    }

    private static int rotatedBinarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        // CONDITION # 1
        if (nums[start] <= nums[mid]) {
            // Here we are in the sorted-part of the array
            if (target >= nums[start] && target <= nums[mid]) {
                // Check if the target exist in the sorted part of array, if it is,
                // apply binary search only on this part
                return rotatedBinarySearch(nums, target, start, mid - 1);
            } else {
                // If the target doesn't exist in the sorted part of array, apply
                // binary search on other (non-sorted) part of the array
                return rotatedBinarySearch(nums, target, mid + 1, end);
            }
        }
        // We are also searching in the second part of array in CONDITION # 1, but if
        // start element is not smaller than the mid (first part of the array is not
        // sorted)
        // Then we have to check in the second part of the array
        if (target >= nums[mid] && target <= nums[end]) {
            // Here it is certain that this part of array will be sorted
            return rotatedBinarySearch(nums, target, mid + 1, end);
        }
        // If we are searching for the pivot element, then search from start to mid - 1
        return rotatedBinarySearch(nums, target, start, mid - 1);
    }
}
