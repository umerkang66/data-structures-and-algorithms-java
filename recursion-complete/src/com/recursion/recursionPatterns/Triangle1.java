package com.recursion.recursionPatterns;

public class Triangle1 {
    public static void main(String[] args) {
        triangle1(5, 0);
        System.out.println("---");
        triangle2(5, 0);
    }

    private static void triangle1(int row, int col) {
        if (row == 0) {
            return;
        }
        // this is like inner loop
        if (col < row) {
            System.out.print("*");
            triangle1(row, col + 1);
            return;
        }
        // this is like outer loop
        System.out.println();
        triangle1(row - 1, 0);
    }

    private static void triangle2(int row, int col) {
        if (row == 0) {
            return;
        }
        // after every call of col increment, col will be equal
        // to row, thus loop breaks without any printing
        if (col < row) {
            triangle2(row, col + 1);
            System.out.print("*");
            return;
        }
        // after every col increment call runs of current row
        // will be increased (literally decreased), then in
        // the second row, again col increment will be called,
        // and again row increment will be called, on the
        // process of backtracking first linePrint will be called
        // then columns should start printing
        triangle2(row - 1, 0);
        if (row != 1) {
            // if row == 1, don't add a new line
            System.out.println();
        }
    }
}
