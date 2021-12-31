package com.umerkang.binarySearchInArrays;

public class NextLetter {
    public static void main(String[] args) {
        char[] characters = {'a', 'c', 'd', 'f', 'h' };
        char target = 'f';
        int result = nextLetter(characters, target);
        System.out.println(result);
    }

    private static int nextLetter(char[] characters, char target) {
        int start = 0;
        int end = characters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < characters[mid]) {
                end = mid - 1;
            } else if (target > characters[mid]) {
                start = mid + 1;
            } else {
                // If the element is present then next go to the next element
                start = mid + 1;
            }
        }
        // If the element is not present then return the ceil
        if (start < characters.length) {
            return start;
        }
        // If the target is greater than the last element, return the first element
        return characters[0];
    }
}
