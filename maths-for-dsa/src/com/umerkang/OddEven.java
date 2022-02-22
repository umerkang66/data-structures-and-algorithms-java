package com.umerkang;

public class OddEven {
    public static void main(String[] args) {
        int n = 68;
        System.out.println(oddEven(n));
    }

    private static boolean oddEven (int n) {
        // EVERY NUMBER (0, 1) AND WITH 1 WILL RETURN THAT NUMBER (0, 1)
        // HOW THIS WORKS: when a number is BITWISE AND with 1, it will be converted
        // into binary, then it will AND every binary number with 1, All the binary
        // numbers from right side, when we convert the number from binary to decimal,
        // that number is multiplied by 2 with power of index (start 0 from the right
        // side) hence 2 ^ 0 == 1, then 1 * 1 == 1, and 1 * 0 == 0, then we have to AND
        // the result of this with the 1, IF the result is 1, hence it is odd number,
        // otherwise it is even number
        // THIS IS DONE IN O(N) TIME COMPLEXITY
        return (n & 1) == 1;
    }
}
