package com.umerkang;

public class RecursionBasics {
    public static void main(String[] args) {
        int num = 40;
        printNum(num);

        int fib = fibonacci(num);
        System.out.println(fib);

        int[] nums = { 3, 9, 12, 15, 17, 22 };
        int searchedResult = binarySearch(nums, 17, 0, nums.length - 1);
        System.out.println(searchedResult);
    }

    private static void printNum(int num) {
        // Base condition
        if (num > 5) {
            return;
        }
        System.out.println(num);
        // This is the last function call, that's why it is called TAIL RECURSION
        printNum(num + 1);
    }

    private static int fibonacci(int num) {
        // Fibonacci Numbers 0,1,1,2,3,5,8,13
        // We are putting this base condition because we know that:
        // 1) Fibonacci number for (0) is always 0
        // 2) Fibonacci number for (1) is always 1
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            // Not found the answer, completed the whole searching area
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target < nums[mid]) {
            // Whenever you calling a recursion call, make sure to return it if there is
            // return type mentioned in the function
            return binarySearch(nums, target, start, mid - 1);
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            // Middle element is equal to the target, return the mid
            return mid;
        }
    }
}
