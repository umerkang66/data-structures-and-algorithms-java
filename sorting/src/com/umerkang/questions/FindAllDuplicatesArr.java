package com.umerkang.questions;
// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;

public class FindAllDuplicatesArr {
    public static void main(String[] args) {
        int[] nums = {4, 3, 4, 2, 7, 8, 2, 3, 1};
        ArrayList<Integer> duplicates = allDuplicates(nums);
        System.out.println(duplicates);
    }

    private static ArrayList<Integer> allDuplicates(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            if (nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }

        ArrayList<Integer> duplicates = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicates.add(nums[i]);
            }
        }
        return duplicates;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
