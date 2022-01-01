package com.umerkang.binarySearchInArrays;

public class MinDiffElement {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 10, 15};
        int target = 14;
        int[] nums1 = {4, 6, 10};
        int target1 = 7;

        int minDifference1 = minDiffElement(nums, target);
        System.out.println(minDifference1);
        int minDifference2 = minDiffElement(nums1, target1);
        System.out.println(minDifference2);
    }

    private static int minDiffElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // Return the element if it is found
                return mid;
            }
        }
        // If the element does not found we have to check for cases
        // Check if the target element is more close to end (previous element)
        // or start (after element)
        // We can check this condition by checking the difference (subtraction) between
        // (target and end) and (target and start)
        // The one that has less difference is return
        if (target - nums[end] < nums[start] - target) {
            // As we need the absolute value without (-) or (+) signs we need to do these
            // 1: In the FIRST check we have to subtract end element from target
            //    because end (previous element) will be smaller than target (array is
            //    sorted)
            // 2: In the SECOND check we have to subtract target from start element
            //    because target will be smaller than start (after element) (array is
            //    sorted)
            return end;
        } else {
            return start;
        }
    }
}
