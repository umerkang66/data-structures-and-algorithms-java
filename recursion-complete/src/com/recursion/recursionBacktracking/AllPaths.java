package com.recursion.recursionBacktracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        // If anywhere is false, you cannot go that route
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        allPathsPrint("", 0, 0, maze, path, 1);
    }

    private static void allPaths(String p, int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[row][col]) {
            // Here it is the obstacle [1, 1]
            return;
        }

        // when function visited the current matrix cell, set the cell to false
        maze[row][col] = false;

        // GO DOWN
        if (row < maze.length - 1) {
            // If row < maze.length - 1, this is not last row, so keep going the recursion
            allPaths(p + "D", row + 1, col, maze);
        }
        // GO RIGHT
        if (col < maze[0].length - 1) {
            // If col < maze[0].length - 1, this is not last col, so keep going the recursion
            allPaths(p + "R", row, col + 1, maze);
        }
        // GO UP
        if (row > 0) {
            // To move up, col will remain same, and row will be reduced by one
            allPaths(p + "U", row - 1, col, maze);
        }
        // GO LEFT
        if (col > 0) {
            // To move up, col will remain same, and row will be reduced by one
            allPaths(p + "U", row, col - 1, maze);
        }

        // BACKTRACKING
        // This line is where the function will be over
        // Before teh function gets removed, also the remove the changes
        // of the changes that this function has made
        // After all the recursions in the current cell are being executed
        // remove the changes that are had been done by every function in this
        // current recursive cell
        maze[row][col] = true;
    }

    private static void allPathsPrint(String p, int row, int col, boolean[][] maze, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        if (!maze[row][col]) {
            // Here it is the obstacle [1, 1]
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        // GO DOWN
        if (row < maze.length - 1) {
            // With every function step is increasing
            allPathsPrint(p + "D", row + 1, col, maze, path, step + 1);
        }
        // GO RIGHT
        if (col < maze[0].length - 1) {
            // With every function step is increasing
            allPathsPrint(p + "R", row, col + 1, maze, path, step + 1);
        }
        // GO UP
        if (row > 0) {
            // With every function step is increasing
            allPathsPrint(p + "U", row - 1, col, maze, path, step + 1);
        }
        // GO LEFT
        if (col > 0) {
            // With every function step is increasing
            allPathsPrint(p + "U", row, col - 1, maze, path, step + 1);
        }

        // BACKTRACKING
        // This line is where the function will be over
        // Before teh function gets removed, also the remove the changes
        // of the changes that this function has made
        // After all the recursions in the current cell are being executed
        // remove the changes that are had been done by every function in this
        // current recursive cell
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
