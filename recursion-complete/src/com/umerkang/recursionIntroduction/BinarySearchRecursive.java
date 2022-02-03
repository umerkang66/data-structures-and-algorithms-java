package com.umerkang.recursionIntroduction;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 9, 12, 19};
        int target = 3;
        System.out.println(binarySearchRecursive(nums, target, 0, nums.length - 1));
    }

    private static int binarySearchRecursive(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (target < nums[mid]) {
            // Always return the recursive call, because in the last function call (if
            // it finds the value "mid" will return), then this returned value will
            // become the value of function from where it is returned, then we have to
            // return that "value of function" (that is function itself) to pass that
            // value through the call stack
            return binarySearchRecursive(nums, target, start, mid - 1);
        } else if (target > nums[mid]) {
            return binarySearchRecursive(nums, target, mid + 1, end);
        } else {
            return mid;
        }
    }
}
