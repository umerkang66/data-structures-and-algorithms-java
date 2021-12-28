package com.umerkang.binarySearchInArrays;

public class ArrRotationCount {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 10, 0, 1, 2, 3};
        int rotationCount = rotationCount(nums);
        System.out.println(rotationCount);
    }

    private static int rotationCount(int[] nums) {
        // Pivot is the largest element in array
        int pivot = findPivot(nums);
        // Array is rotated the pivot times + 1
        return pivot + 1;
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Here we are saying that mid should LESS than end, we are not using the
            // LESS THAN EQUAL TO because we are using (mid + 1) that is also equal to
            // mid + 1 <= end
            if (mid < end && nums[mid] > nums[mid + 1]) {
                // It is pivot because it is the largest number in the array
                // In an ascending rotated sorted array every element will be smaller
                // than the next element except the largest element in array
                return mid;
            }
            // CRITICAL: If by using ==> start = mid + 1, in the below else block, we
            // have been moved next to the pivot element but that will be catched in
            // this if block
            if (mid > start && nums[mid] < nums[mid - 1]) {
                // If the mid is smaller than the previous element then the previous
                // element is the largest element i.e. that is the pivot
                // Because in normal ascending sorted array element will be always
                // larger than the previous element
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                // We are not using ==> start = mid;
                // But we are using ==> start = mid + 1, that will be caught in
                // CRITICAL section
                start = mid + 1;
            }
        }
        return -1;
    }
}
