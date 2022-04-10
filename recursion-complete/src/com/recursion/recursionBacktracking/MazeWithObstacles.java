package com.recursion.recursionBacktracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println(mazeWithObstacles(0, 0, maze));
        mazeWithObstaclesDirections("", 0, 0, maze);
        System.out.println(mazeWithObstaclesDirectionsArray("", 0, 0, maze));
    }

    private static int mazeWithObstacles(int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            // Go till the end of maze (bottom right corner)
            // If it is reached the end, return the ans, don't call the next recursion
            return 1;
        }
        if (!maze[row][col]) {
            // Here it is the obstacle [1, 1]
            return 0;
        }
        int left = 0;
        int right = 0;
        if (row < maze.length - 1) {
            // If row < maze.length - 1, this is not last row, so keep going the recursion
            left = mazeWithObstacles(row + 1, col, maze);
        }
        if (col < maze[0].length - 1) {
            // If col < maze[0].length - 1, this is not last col, so keep going the recursion
            right = mazeWithObstacles(row, col + 1, maze);
        }
        return left + right;
    }

    private static void mazeWithObstaclesDirections(String p, int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[row][col]) {
            // Here it is the obstacle [1, 1]
            return;
        }
        if (row < maze.length - 1) {
            // If row < maze.length - 1, this is not last row, so keep going the recursion
            mazeWithObstaclesDirections(p + "V", row + 1, col, maze);
        }
        if (col < maze[0].length - 1) {
            // If col < maze[0].length - 1, this is not last col, so keep going the recursion
            mazeWithObstaclesDirections(p + "H", row, col + 1, maze);
        }
    }

    private static ArrayList<String> mazeWithObstaclesDirectionsArray(String p, int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> pathsInternal = new ArrayList<>();
            pathsInternal.add(p);
            return pathsInternal;
        }
        ArrayList<String> pathsOuter = new ArrayList<>();
        if (!maze[row][col]) {
            // Here it is the obstacle [1, 1]
            return pathsOuter;
        }
        if (row < maze.length - 1) {
            // If row < maze.length - 1, this is not last row, so keep going the recursion
            pathsOuter.addAll(mazeWithObstaclesDirectionsArray(p + "V", row + 1, col, maze));
        }
        if (col < maze[0].length - 1) {
            // If col < maze[0].length - 1, this is not last col, so keep going the recursion
            pathsOuter.addAll(mazeWithObstaclesDirectionsArray(p + "H", row, col + 1, maze));
        }
        return pathsOuter;
    }
}
