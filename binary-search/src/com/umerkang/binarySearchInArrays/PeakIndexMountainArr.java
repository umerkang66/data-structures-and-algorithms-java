package com.umerkang.binarySearchInArrays;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/
// Both question have same code

public class PeakIndexMountainArr {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 4, 3, 2};
        int peakItemIndex = peakIndexMountainArray(nums);
        System.out.println(peakItemIndex);
    }

    private static int peakIndexMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        // We have to use "<" instead of "<=" because we are using "end = mid" in the
        // else condition of binary search, hence at some period of time, start and
        // will point to the same element, and if were not using "<" the loop will not
        // break here
        while (start < end) {
            int mid = start + (end - start) / 2;
            // We don't need to check if mid + 1 is out of index range, because in the
            // upper loop condition, we have said that start should be always less than
            // end, so mid + 1 should be always less than or equal to end (mid + 1 will
            // never exceed the array index range)
            if (nums[mid] > nums[mid + 1]) {
                // Because mid is greater than mid + 1, we are in the decreasing part
                // of the array (all the elements after it should be less than mid,
                // because peak is the largest element, hence we can ignore the
                // descending part of the array
                // Mid-element may be the answer but also look at left, that's why mid
                // != mid - 1 and ignore elements that are after mid
                end = mid;
            } else {
                // Mid + 1 is greater than mid, hence numbers are increasing, it is in
                // the ascending order, the elements before the mid should be less than
                // mid + 1, hence we can ignore it
                start = mid + 1;
            }
        }
        // Once the loop will break, only one element will be remaining and both start
        // and end will be pointing to that element, hence we can return either start
        // or end (both start and end are trying to find the largest element)
        return start;
    }
}
