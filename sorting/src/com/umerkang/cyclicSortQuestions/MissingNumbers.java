package com.umerkang.cyclicSortQuestions;
// https://leetcode.com/problems/missing-number/

public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1, 5, 2 };
        int missingNumber = missingNumbers(nums);
        System.out.println(missingNumber);
    }

    private static int missingNumbers(int[] nums) {
        // Using cyclic sort algorithm
        int start = 0;
        while (start < nums.length) {
            // Because the range is from 0 to n, correctIndex of elements should be
            // equal to the elements itself, so don't subtract it with anything
            int correctIndex = nums[start];
            // Always check if correctIndex should always be less than nums.length, in
            // this case we will not check for the largest element in the array, that
            // automatically comes at the last index. If we don't check for this case,
            // this will return an error, because largest element's correctIndex is
            // always greater than the last index of array (it actually has index equal
            // to nums.length)
            if (correctIndex < nums.length && nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        // After the while loop (cyclic sort) will run, array will be sorted, there
        // will be one element missing at the certain index (other element will be
        // present at that index) return the index (because array element will be equal
        // to index)
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        // If all the elements are present at the correctIndex, it means the element
        // missing is number that comes after the last element of array, hence we
        // return the nums.length (nums.length - 1 is the last element of array)
        return nums.length;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
