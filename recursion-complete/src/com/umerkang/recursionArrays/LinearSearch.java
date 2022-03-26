package com.umerkang.recursionArrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 18, 18, 9};
        System.out.println(linearSearch(nums, 18, 0));

        linearSearchMultiple(nums, 18, 0);
        System.out.println(numsAns);

        ArrayList<Integer> ansWithArrayList = new ArrayList<>();
        System.out.println(linearSearchMultipleWithArrayList(nums, 18, 0, ansWithArrayList));

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

    // With Outside ArrayList
    static ArrayList<Integer> numsAns = new ArrayList<>();

    private static void linearSearchMultiple(int[] nums, int target, int i) {
        // We have to check for the last element in array, so when index is greater
        // than last element, then return -1
        if (i == nums.length) {
            return;
        }
        if (target == nums[i]) {
            numsAns.add(i);
        }
        linearSearchMultiple(nums, target, ++i);
    }

    // With Inside ArrayList
    private static ArrayList<Integer> linearSearchMultipleWithArrayList(
        int[] nums,
        int target, int i, ArrayList<Integer> ans) {
        // We have to check for the last element in array, so when index is greater
        // than last element, then return -1
        if (i == nums.length) {
            return ans;
        }
        if (target == nums[i]) {
            ans.add(i);
        }
        return linearSearchMultipleWithArrayList(nums, target, ++i, ans);
    }

    // Create List in Function Body
    // This is not optimized because objects are creating again and again
    private static ArrayList<Integer> linearSearchWithListInBody(int[] nums, int target
        , int i) {
        if (i == nums.length) {
            // Return this empty list, we will add the answers in when we will
            // return the functions
            return new ArrayList<Integer>();
        }
        // This will contain the answer from current function call only
        ArrayList<Integer> ansList = new ArrayList<>();
        if (target == nums[i]) {
            ansList.add(i);
        }
        ArrayList<Integer> returnedList = linearSearchWithListInBody(nums, target, ++i);
        returnedList.addAll(ansList);
        // This should be in opposite direction
        return returnedList;
    }
}
