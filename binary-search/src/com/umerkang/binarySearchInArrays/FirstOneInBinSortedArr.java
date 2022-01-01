package com.umerkang.binarySearchInArrays;

public class FirstOneInBinSortedArr {
    public static void main(String[] args) {
        // Array is infinite hence last index is infinite
        int[] nums = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        int target = 1;
        int firstOne = firstOneInBinSortedArr(nums, target);

        System.out.println(firstOne);
    }

    private static int firstOneInBinSortedArr(int[] nums, int target) {
        // Explanation of this algorithm is in SortedArrInfiniteNums question
        int start = 0;
        int end = 1;
        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + (end - start) * 2;
            start = newStart;
        }
        return binarySearch(nums, target, start, end);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // We will only look on the left side
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }
}
