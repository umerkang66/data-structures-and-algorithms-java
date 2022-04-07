package com.umerkang.recursionSorting;

import java.util.Arrays;

/*
    Find the pivot, after the first iteration, all the elements
    that are less than pivot, should be on the left side of pivot,
    and others should on the right side of pivot, then recursion comes in,
    and it will start putting the pivot elements in their correct position,
    In every function call, recursion will be called on the sub-arrays
    on the left and right side of pivot element (at its correct position)
    After every pass, you are putting pivot at its correct position
    HOW TO PUT PIVOT AT ITS CORRECT POSITION
    Initialize the two pointers from start, and end, (check these two elements
    start, and end if they are at their equal position, if not swap them),
    if we find the violation to the RULE (elements greater than pivot should
    be on the right side of pivot, and the smaller elements should be on the
    left side of pivot), then swap the both elements, then move the start pointer
    forward by 1, and move the end pointer backward by 1
    TAKE THE MID ELEMENT OF CURRENT ARRAY IS PIVOT
*/
public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 4, 12, 5, 6};
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    private static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            // When high, and low will be pointing to the same element, after swapping
            // that element, high will move forward, and low will move backward, thus
            // high will become greater than low, thus returning from this recursive
            // function
            return;
        }
        int start = low;
        int end = high;
        // Start, and end are same as low, and high, respectively
        int mid = start + (end - start) / 2;
        int pivot = numbers[mid];
        // We will move the start, and end pointers, (not low, and high), so check for
        // while loop conditions using start, and end (not low, and high)
        while (start <= end) {
            // Also, the reason, if it is already sorted, it will not swap
            while (numbers[start] < pivot) {
                // start-element is less than pivot, means it is at its correct position
                // just move the pointer forward, don't swap
                start++;
            }
            while (numbers[end] > pivot) {
                // end-element is greater than pivot, means it is at its correct position
                // just move the pointer backward, don't swap
                end--;
            }
            // After these loops, both start and end element should be violating the
            // conditions, so swap them
            if (start <= end) {
                // It can happen in the loops that start will become greater than end
                // again check that condition here, because it can happen that start
                // become greater than mid, but that will be checked in the next iteration
                // of main while-loop
                swap(numbers, start, end);
                start++;
                end--;
            }
        }
        // Now my pivot is at current index, sort the two halves now
        // After the while loop, end will be before the pivot (mid)
        quickSort(numbers, low, end);
        // After the while loop, start will be after the pivot (mid)
        quickSort(numbers, start, high);
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
