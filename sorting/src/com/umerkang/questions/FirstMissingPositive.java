package com.umerkang.questions;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1};
        int missingPositive = missing(nums);
        System.out.println(missingPositive);
    }

    private static int missing(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            if (nums[start] > 0 && nums[start] < nums.length && nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
