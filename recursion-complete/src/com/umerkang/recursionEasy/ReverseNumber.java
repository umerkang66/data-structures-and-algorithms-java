package com.umerkang.recursionEasy;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 3821;
        int numLength = (int) (Math.log10(n) + 1);
        System.out.println(reverseNumber2(n, numLength));
    }

    private static int reverseNumber2(int n, int numLength) {
        // The second if-block, can save us the last recursive call (which is not
        // needed by the way)
        // if (n <= 0) {
        if (n / 10 <= 0) {
        // This will check if the number is one digit number
        // if (n % 10 == n) {
            // At the very last recursive call, let's say the last number is 3, so 3 /
            // 10 is 0, and 0 is less or equal than 0, hence this if block will run,
            // and return that that number
            return n;
        }
        int remainder = n % 10;
        return remainder * (int) Math.pow(10, numLength - 1) + reverseNumber2(n / 10,
            numLength - 1);
    }
}
