package com.umerkang.questions;
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;

public class AllNumbersMissingArr {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        ArrayList<Integer> missingNums = missingNumbers(nums);
        System.out.println(missingNums);
    }

    private static ArrayList<Integer> missingNumbers(int[] nums) {
        ArrayList<Integer> missingNums = new ArrayList<Integer>();
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            if (nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                missingNums.add(i + 1);
            }
        }
        return missingNums;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
