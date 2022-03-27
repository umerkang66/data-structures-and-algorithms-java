package com.umerkang.recursionSorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {8, 3, 4, 12, 5, 6};
        int[] sortedNums = sort(nums);
        System.out.println(Arrays.toString(sortedNums));

        // Pass the index till end, because mergeInPlace will check for second sub-array
        // index is less than end, so it automatically becomes end - 1
        sortInPlace(nums,0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] sort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = sort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] ansArr = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                ansArr[k] = first[i];
                i++;
            } else {
                ansArr[k] = second[j];
                j++;
            }
            k++;
        }
        // It may be possible if one of the array is not completed
        // While first array is completed, copy the remaining elements in ansArr
        while (i < first.length) {
            ansArr[k] = first[i];
            i++;
            k++;
        }
        // While second array is completed, copy the remaining elements in ansArr
        while (j < second.length) {
            ansArr[k] = second[j];
            j++;
            k++;
        }
        return ansArr;
    }

    private static void sortInPlace(int[] nums, int start, int end) {
        // Return if there is only one element in array
        if (end - start == 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        // Pass the index till mid, because mergeInPlace will check for first sub-array
        // index is less than mid, so it automatically becomes mid - 1
        sortInPlace(nums, start, mid);
        // Pass the index till end, because mergeInPlace will check for second sub-array
        // index is less than end, so it automatically becomes end - 1
        sortInPlace(nums, mid, end);
        mergeInPlace(nums, start, mid, end);
    }

    private static void mergeInPlace(int[] nums, int start, int mid, int end) {
        int[] ansArr = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (nums[i] < nums[j]) {
                ansArr[k] = nums[i];
                i++;
            } else {
                ansArr[k] = nums[j];
                j++;
            }
            k++;
        }
        // It may be possible that one of the array is not complete
        while (i < mid) {
            ansArr[k] = nums[i];
            i++;
            k++;
        }
        while (j < end) {
            ansArr[k] = nums[j];
            j++;
            k++;
        }
        for (int l = 0; l < ansArr.length; l++) {
            // Start adding the in the original array from start, from where this merge
            // function is called
            nums[start + l] = ansArr[l];
        }
    }
}
