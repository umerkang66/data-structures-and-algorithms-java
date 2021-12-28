package com.umerkang.binarySearchInArrays;

public class ArrRotationCount {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 6, 7};
        int rotationCount = rotationCount(nums);
        System.out.println(rotationCount);
    }

    private static int rotationCount(int[] nums) {
        int pivot = findPivot(nums);
        // Array is rotated the pivot times + 1
        return pivot + 1;
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                // It is pivot because it is the largest number in the array
                // In an ascending rotated sorted array every element will be smaller
                // than the next element except the largest element in array
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                // If the mid is smaller than the previous element then the previous
                // element is the largest element i.e. that is the pivot
                // Because in normal ascending sorted array element will be always
                // larger than the previous element
                return mid - 1;
            }
            if (nums[mid] < nums[start]) {
                end = mid - 1;
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
