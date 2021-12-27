package com.umerkang.binarySearchIn2dArrays;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 6;

        System.out.println(Arrays.toString(search(arr, target)));
    }

    private static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix may be empty

        if (cols == 0) {
            return new int[]{-1, -1};
        }

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols / 2;

        // run the loop till 2 rows are remaining
        // while this is true it will have more than 2 rows
        // RowStart is less than rowEnd - 1, means always two rows will remaining
        while (rowStart < (rowEnd - 1)) {
            int mid = rowStart + (rowEnd - rowStart) / 2;

            if (matrix[mid][colMid] == target) {
                return new int[]{mid, colMid};
            }

            if (target < matrix[mid][colMid]) {
                rowEnd = mid;
            } else {
                rowStart = mid;
            }
        }

        // now we have two rows
        // check whether the target is in the col of 2 rows
        if (matrix[rowStart][colMid] == target) {
            return new int[]{rowStart, colMid};
        }

        if (matrix[rowStart + 1][colMid] == target) {
            return new int[]{rowStart + 1, colMid};
        }

        // search in 1st half
        if (target <= matrix[rowStart][colMid - 1]) {
            return binarySearch(matrix, rowStart, 0, colMid - 1, target);
        }

        // search in 2nd half
        if (target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][cols - 1]) {
            return binarySearch(matrix, rowStart, colMid + 1, cols - 1, target);
        }

        // search in 3rd half
        if (target <= matrix[rowStart + 1][colMid - 1]) {
            return binarySearch(matrix, rowStart + 1, 0, colMid - 1, target);
        } else {
            return binarySearch(matrix, rowStart + 1, colMid + 1, cols - 1, target);
        }
    }

    // search in the row provided between the cols provided
    private static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;

            if (target == matrix[row][mid]) {
                return new int[]{row, mid};
            }

            if (target < matrix[row][mid]) {
                colStart = mid - 1;
            } else {
                colEnd = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
