package com.umerkang.cyclicSortQuestions;
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;

public class AllNumbersMissingArr {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        ArrayList<Integer> missingNums = missingNumbers(nums);
        System.out.println(missingNums);
    }

    private static ArrayList<Integer> missingNumbers(int[] nums) {
        ArrayList<Integer> missingNums = new ArrayList<>();
        // Using cyclic sort
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            // Explanation of the below line in Missing Number question
            if (correctIndex < nums.length && nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        // The numbers are in the range, if 2 only numbers are missing, only two
        // numbers greater than the missing will be present in the array, so we can
        // ignore that greater 2 elements, and find the missing elements using the
        // indexes in the cyclic sort
        for (int i = 0; i < nums.length; i++) {
            // We have to compare it with i + 1, because numbers start from 1 not 0
            if (nums[i] != i + 1) {
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
