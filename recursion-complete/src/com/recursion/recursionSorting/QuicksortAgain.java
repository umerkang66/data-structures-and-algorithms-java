package com.recursion.recursionSorting;

import java.util.Arrays;

public class QuicksortAgain {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 4, 12, 5, 6};
        sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int startPointer = start;
        int endPointer = end;
        int pivot = nums[mid];

        while (startPointer <= endPointer) {
            while (nums[startPointer] < pivot) {
                startPointer++;
            }
            while (nums[endPointer] > pivot) {
                endPointer--;
            }
            if (startPointer <= endPointer) {
                swap(nums, startPointer, endPointer);
                startPointer++;
                endPointer--;
            }
        }

        sort(nums, start, endPointer);
        sort(nums, startPointer, end);
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
