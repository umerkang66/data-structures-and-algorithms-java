package com.umerkang.binarySearchInArrays;

public class CountArrElement {
    public static void main(String[] args) {
        int[] nums = {2, 4, 10, 10, 10, 18, 20};
        int target = 10;

        int totalCount = countArrElement(nums, target);
        System.out.println(totalCount);
    }

    private static int countArrElement(int[] nums, int target) {
        int leastLeftIndex = binarySearchOnBothSides(nums, target, true);
        int extremeRightIndex = -1;
        if (leastLeftIndex != -1) {
            extremeRightIndex = binarySearchOnBothSides(nums, target, false);
        }
        return extremeRightIndex - leastLeftIndex + 1;
    }

    private static int binarySearchOnBothSides(int[] nums, int target, boolean moveLeft) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                if (moveLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                result = mid;
            }
        }
        return result;
    }
}
