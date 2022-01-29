package com.umerkang.binarySearchIn2dArrays;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };
        int target = 28;
        System.out.println(Arrays.toString(search(matrix, target)));
    }

    private static int[] search(int[][] matrix, int target) {
        // Take the smallest element that is first element as starting point
        int row = 0;
        // Take the most right element in the first array of 2d array
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return new int[]{row, col};
            // If the element of 2d array is greater than target, then all the elements
            // in the column is also greater than the target, so ignore the whole
            // column, and decrease the column by 1
            if (matrix[row][col] > target) col--;
            // If the element of 2d array is smaller than target, then all the elements
            // previous from element in the row will also be smaller than target, so
            // ignore the whole row, and increase the row by 1
            if (matrix[row][col] < target) row++;
        }
        return new int[]{-1, -1};
    }
}
