package com.umerkang.binarySearchInArrays;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int[] boards = {5, 5, 5, 5};
        int painters = 2;

        int minimumNumberOfBoards = minimumNumberOfBoardsToPaint(boards, painters);
        // Number of n boards takes n time, so number of boards are also equal to
        // number of time, hence we can return number of boards
        System.out.println(minimumNumberOfBoards);
    }

    private static int minimumNumberOfBoardsToPaint(int[] boards, int painters) {
        // Explanation ofo this algorithm in BookAllocationProblem
        int start = 0;
        int end = 0;
        for (int board : boards) {
            start = Math.max(start, board);
            end += board;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int numOfPaintersPerLoop = 1;
            for (int board : boards) {
                if (sum + board <= mid) {
                    sum += board;
                } else {
                    // Reset the sum, and increase the painters
                    sum = board;
                    numOfPaintersPerLoop++;
                }
            }
            if (numOfPaintersPerLoop > painters) {
                // We have to prevent painters in loop to increase the total no. of
                // painters, so increase the mid by increasing the start
                start = mid + 1;
            } else {
                // We can decrease the mid further till both start and end will point
                // to the same element
                end = mid;
            }
        }
        return start;
    }
}
