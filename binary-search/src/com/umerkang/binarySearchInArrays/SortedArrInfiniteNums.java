package com.umerkang.binarySearchInArrays;

public class SortedArrInfiniteNums {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 20, 23, 30, 32};
        int target = 15;

        int searchedIndex = sortedArrInfiniteNums(nums, target);
        System.out.println(searchedIndex);
    }

    private static int sortedArrInfiniteNums(int[] nums, int target) {
        // Find the range
        // Start with box of size 2
        int start = 0;
        int end = 1;

        // Condition for the target to lie in the range
        while (target > nums[end]) {
            int newStart = end + 1;
            // double the box size
            // end = previousEnd + (sizeOfBox * 2)
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(nums, target, start, end);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // Find the middle element
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
