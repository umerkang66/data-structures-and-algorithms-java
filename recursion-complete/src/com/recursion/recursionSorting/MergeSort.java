package com.recursion.recursionSorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 4, 12, 5, 6};
        int[] sortedNumbers = sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));

        // Pass the index till end, because mergeInPlace will check for second sub-array
        // index is less than end, so it automatically becomes end - 1
        sortInPlace(numbers,0, numbers.length);
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] sort(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        }
        int mid = numbers.length / 2;
        int[] left = sort(Arrays.copyOfRange(numbers, 0, mid));
        int[] right = sort(Arrays.copyOfRange(numbers, mid, numbers.length));
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

    private static void sortInPlace(int[] numbers, int start, int end) {
        // Return if there is only one element in array
        if (end - start == 1) {
            // After this return, mergeInPlace will start to be called, Here there will
            // be only one element in pointed by indexes (treat it as a single array),
            // there will be two arrays at the end, then mergeInPlace will sort them
            // then merge them
            return;
        }
        int mid = start + (end - start) / 2;
        // Pass the index till mid, because mergeInPlace will check for first sub-array
        // index is less than mid, so it automatically becomes mid - 1
        sortInPlace(numbers, start, mid);
        // Pass the index till end, because mergeInPlace will check for second sub-array
        // index is less than end, so it automatically becomes end - 1
        sortInPlace(numbers, mid, end);

        // Merging
        // We are also passing mid, so we can separate the two sub-arrays from
        // single-array
        mergeInPlace(numbers, start, mid, end);
    }

    private static void mergeInPlace(int[] numbers, int start, int mid, int end) {
        int[] ansArr = new int[end - start];
        // We are treating these as two arrays
        // Imagine first array starts from "start", and ends at "mid"
        int i = start;
        // Imagine second array starts from "mid", and ends at "end"
        int j = mid;
        // "k" pointer use to iterate over this "ansArr"
        int k = 0;
        while (i < mid && j < end) {
            if (numbers[i] < numbers[j]) {
                ansArr[k] = numbers[i];
                i++;
            } else {
                ansArr[k] = numbers[j];
                j++;
            }
            k++;
        }
        // It may be possible that one of the array is not complete
        while (i < mid) {
            ansArr[k] = numbers[i];
            i++;
            k++;
        }
        while (j < end) {
            ansArr[k] = numbers[j];
            j++;
            k++;
        }
        for (int l = 0; l < ansArr.length; l++) {
            // Start adding the in the original array from start, from where this merges
            // function is called
            numbers[start + l] = ansArr[l];
        }
    }
}
