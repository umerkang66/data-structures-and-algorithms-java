package com.umerkang.cyclicSortQuestions;
// https://leetcode.com/problems/find-the-duplicate-number/

public class FindTheDuplicateNum {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 3, 2};
        int duplicateNum = duplicateNum(nums);
        System.out.println(duplicateNum);
    }

    private static int duplicateNum(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // If the element is not equal to index + 1, it means it can be unsorted, or
            // it can be duplicate, if it is unsorted we have to sort it by swapping
            // it, if it is sorted it means this number is the second one (duplicate)
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;
                // If the element is not at its correct index swap it
                if (nums[i] != nums[correctIndex]) {
                    swap(nums, i, correctIndex);
                } else {
                    // Otherwise, it is duplicate return it
                    return nums[i];
                }
            } else {
                // If the element is equal to index + 1, move the loop
                i++;
            }
        }
        // If there aren't any duplicates
        return -1;
    }

    // This algorithm has additional for loop
    private static int duplicateNumber(int[] nums) {
        // Using cyclic sort, because of 1 to N range, explanation is in the missing
        // number question
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            if (nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        // If some element is not present at its correctIndex, It is duplicated
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
