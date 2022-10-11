package com.recursion.recursionSorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = { 8, 3, 4, 12, 5, 6 };
        int[] sortedNumbers = sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));
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
}
