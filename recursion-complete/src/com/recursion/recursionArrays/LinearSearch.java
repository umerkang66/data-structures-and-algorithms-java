package com.recursion.recursionArrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 18, 18, 9};
        System.out.println(linearSearch(nums, 18, 0));

        ArrayList<Integer> ansWithArrayList = new ArrayList<>();
        System.out.println(linearSearchMultiple(nums, 18, 0, ansWithArrayList));

        System.out.println(linearSearchWithListInBody(nums, 18, 0));
        System.out.println(linearSearchWithListInBody(nums, 18, 0));
    }

    private static int linearSearch(int[] nums, int target, int i) {
        // We have to check for the last element in array, so when index is greater
        // than last element, then return -1
        if (i == nums.length) {
            return -1;
        }
        if (target == nums[i]) {
            return i;
        }
        return linearSearch(nums, target, ++i);
    }

    // With Inside ArrayList
    private static ArrayList<Integer> linearSearchMultiple(int[] nums, int target,
                                                           int i, ArrayList<Integer> ans) {
        // We have to check for the last element in array, so when index is greater
        // than last element, then return -1
        if (i == nums.length) {
            return ans;
        }
        if (target == nums[i]) {
            ans.add(i);
        }
        return linearSearchMultiple(nums, target, ++i, ans);
    }

    // Create List in Function Body
    private static ArrayList<Integer> linearSearchWithListInBody(int[] nums, int target, int i) {
        if (i == nums.length) {
            // Return this empty list, we will add the answers in when we will
            // return the functions
            return new ArrayList<>();
        }
        ArrayList<Integer> returnedList = linearSearchWithListInBody(nums, target, i + 1);
        if (target == nums[i]) {
            returnedList.add(i);
        }
        // This should be in opposite direction
        return returnedList;
    }
}
