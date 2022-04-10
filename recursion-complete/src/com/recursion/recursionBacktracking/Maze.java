package com.recursion.recursionBacktracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(countingPaths(3, 3));
        printingPaths("", 3, 3);
        System.out.println(printingPathsArray("", 3, 3));
        System.out.println(printingPathsDiagonalArray("", 3, 3));
    }

    private static int countingPaths(int row, int col) {
        if (row == 1 || col == 1) {
            // If either of rows, or cols become 1, there will be only
            // one path to reach the destination, so return 1
            return 1;
        }
        // On the right-hand side, we are decreasing row by 1
        int left = countingPaths(row - 1, col);
        // On the left-hand side, we are decreasing col by 1
        int right = countingPaths(row, col - 1);
        return left + right;
    }

    private static void printingPaths(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            // Only stop the execution if both row, and col are 1
            // The execution will continue, even one of row, or col is not 1
            System.out.println(processed);
            return;
        }
        if (row > 1) {
            // If by any chance, row has already reached one, by col has not,
            // so stop this recursion calls
            printingPaths(processed + "V", row - 1, col);
        }
        if (col > 1) {
            // If by any chance, col has already reached one, by row has not,
            // so stop this recursion calls
            printingPaths(processed + "H", row, col - 1);
        }
    }

    // Explanation is in above method
    private static ArrayList<String> printingPathsArray(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> pathsInternal = new ArrayList<>();
            pathsInternal.add(processed);
            return pathsInternal;
        }
        ArrayList<String> pathsOuter = new ArrayList<>();
        if (row > 1) {
            pathsOuter.addAll(printingPathsArray(processed + "V", row - 1, col));
        }
        if (col > 1) {
            pathsOuter.addAll(printingPathsArray(processed + "H", row, col - 1));
        }
        return pathsOuter;
    }

    // Further explanations are in above function calls
    private static ArrayList<String> printingPathsDiagonalArray(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> pathsInternal = new ArrayList<>();
            pathsInternal.add(processed);
            return pathsInternal;
        }
        ArrayList<String> pathsOuter = new ArrayList<>();
        if (col > 1 && row > 1) {
            // This will go diagonally, if it is the last row, or last col,
            // Don't go diagonally then
            pathsOuter.addAll(printingPathsDiagonalArray(processed + "D", row - 1, col - 1));
        }
        if (row > 1) {
            pathsOuter.addAll(printingPathsDiagonalArray(processed + "V", row - 1, col));
        }
        if (col > 1) {
            pathsOuter.addAll(printingPathsDiagonalArray(processed + "H", row, col - 1));
        }
        return pathsOuter;
    }
}
