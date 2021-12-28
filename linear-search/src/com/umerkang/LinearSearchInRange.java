package com.umerkang;

public class LinearSearchInRange {
    public int linearSearch(int[] intArr, int target, int start, int end) {
        if (intArr.length <= 0) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (intArr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
