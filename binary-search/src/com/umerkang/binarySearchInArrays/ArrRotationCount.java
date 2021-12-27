package com.umerkang.binarySearchInArrays;

public class ArrRotationCount {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 0, 1, 2, 3};
        int count = arrRotationCount(nums);

        System.out.println(count);
    }

    private static int arrRotationCount(int[] nums) {
        int pivot = findPivot(nums);
        return pivot + 1;
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Case 1:
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // Case 2:
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            // Case 3:
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } // Case 4:
            else if (nums[mid] > nums[start]) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
