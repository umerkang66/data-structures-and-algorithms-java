package com.umerkang;

import java.util.Arrays;

// STABLE SORTING ALGORITHMS: If the array has two same elements (colored balls) with the
// different color, but when sorted the order is maintained means (if the black ball
// comes first to the red ball with same value in the original array, it also comes first
// in the sorted array)
// UNSTABLE SORTING ALGORITHMS: It is opposite to stable sorting algorithms, the order
// is not maintained here in the sorted one

class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 2, 0, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //  In every step you are comparing the adjacent elements, if second element is larger
    //  than the first element, then swap it. It is also known as sinking sort,
    //  exchange sort
    private static void bubbleSort(int[] arr) {
        // We need to use swapped, because if the array is already sorted or almost
        // sorted, so we have to stop loop inner loop right there, we can do this by
        // checking if for a particular inner loop the value of "j" never swapped hence
        // the array after that element is already sorted, break the outer loop
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            // Reset the isSwapped to false
            isSwapped = false;
            //  At every step, the largest element from an unsorted array will come
            //  to the respective end, hence it will form sorting from the end. Hence,
            //  should not be comparing the sorted part of the array.
            //  When the outer loop "i" is 1, one the largest element will have come to
            //  an end (array is sorted by 1 element), we don't need to check for the
            //  last element
            //  Hence, "j" will run to the < arr.length - i
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true;
                }
            }
            // If isSwapped is false it means for whole inner loop not a single one is
            // swapped, hence the array after is sorted, break the outer (main) loop, So,
            // in the best case time complexity becomes O(1)
            if (!isSwapped) {
                break;
            }
        }
    }
}
