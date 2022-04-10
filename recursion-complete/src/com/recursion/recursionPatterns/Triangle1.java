package com.recursion.recursionPatterns;

public class Triangle1 {
    public static void main(String[] args) {
        triangle1(5, 0);
        triangle2(5, 0);
    }

    private static void triangle1(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            System.out.print("*");
            triangle1(row, col + 1);
        } else {
            System.out.println();
            // when row starts, col starts with zero
            triangle1(--row, 0);
        }
    }

    private static void triangle2(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            triangle2(row, col + 1);
            System.out.print("*");
        } else {
            // when row starts, col starts with zero
            triangle2(row - 1, 0);
            System.out.println();
        }
    }
}
