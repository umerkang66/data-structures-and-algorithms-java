package com.umerkang.binarySearchIn2dArrays;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int target = 16;
        System.out.println(Arrays.toString(search(matrix, target)));
    }

    private static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // Be cautious matrix may be empty
        if (rows == 1) {
            // If matrix has only one row, then apply binary search from start to end
            // of it, i.e. is colStart that is 0 to colEnd that length of cols - 1
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        // Run the loop till 2 rows are remaining, if rowStart and rowEnd - 1 becomes
        // equal the loop will over.
        int rowStart = 0;
        int rowEnd = rows - 1;
        int midCol = (cols - 1) / 2;
        while (rowStart < rowEnd - 1) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            if (target == matrix[rowMid][midCol]) {
                return new int[]{rowMid, midCol};
            } else if (target < matrix[rowMid][midCol]) {
                // All the rows after rowMid should be ignored
                rowEnd = rowMid;
            } else {
                // All the rows before rowMid should be ignored
                rowStart = rowMid;
            }
        }
        // After running this loop only two rows will be remaining
        // Now check if the target is in the mid-column of both rows, rowStart, rowEnd
        if (matrix[rowStart][midCol] == target) {
            return new int[]{rowStart, midCol};
        }
        if (matrix[rowEnd][midCol] == target) {
            return new int[]{rowEnd, midCol};
        }
        // If target does not present in the middle column, we have to check in all the
        // four sides of the middle column
        if (target < matrix[rowStart][midCol]) {
            // Here checking in both sides of rowStart array
            // Search in 1st half
            return binarySearch(matrix, rowStart, 0, midCol - 1, target);
        } else if (target > matrix[rowStart][midCol] && target <= matrix[rowStart][cols - 1]) {
            // Search in 2nd half
            return binarySearch(matrix, rowStart, midCol + 1, cols - 1, target);
        } else if (target < matrix[rowEnd][midCol]) {
            // Now check in both sides of rowEnd array
            // Search in 3rd half
            return binarySearch(matrix, rowEnd, 0, midCol - 1, target);
        } else {
            // if (target > matrix[rowEnd][midCol])
            // Search in 4th half
            return binarySearch(matrix, rowEnd, midCol + 1, cols - 1, target);
        }
    }

    // In which row you want to search, we also have to check in which column to which
    // column you have to search
    private static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd
        , int target) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if (target < matrix[row][mid]) {
                colEnd = mid - 1;
            } else {
                colStart = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
