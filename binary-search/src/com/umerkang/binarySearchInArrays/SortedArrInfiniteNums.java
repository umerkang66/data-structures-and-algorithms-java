package com.umerkang.binarySearchInArrays;

public class SortedArrInfiniteNums {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 20, 23, 30, 32};
        int target = 15;
        int searchedIndex = sortedArrInfiniteNums(nums, target);
        System.out.println(searchedIndex);
    }

    private static int sortedArrInfiniteNums(int[] nums, int target) {
        int start = 0;
        int end = 1;
        // Once the target is less than end, we can apply binary search
        // from start to end
        while (target > nums[end]) {
            int newStart = end + 1;
            // Double the box size
            // end = previousEnd + (sizeOfBox) * 2;
            // sizeOfBox = (end - start) * 2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(nums, target, start, end);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
