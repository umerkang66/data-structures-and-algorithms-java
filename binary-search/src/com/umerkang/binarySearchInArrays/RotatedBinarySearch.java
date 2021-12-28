package com.umerkang.binarySearchInArrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {11, 12, 13, 7, 8, 9, 10};
        int target = 13;

        int searchedIndex = rotatedBinarySearch(nums, target);
        System.out.println(searchedIndex);
    }

    private static int rotatedBinarySearch(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            // There is no rotation use the regular binary search and return answer
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        // Check if pivot element is target, if it is return it
        if (target == nums[pivot]) {
            return pivot;
        }
        // Now we have two ascending sorted arrays one on the left side of pivot and
        // the other on the right side of pivot
        if (target >= nums[0]) {
            // Target is greater than or equal than the start element, it means the
            // target is in the sorted array that is on the LEFT side of pivot
            return binarySearch(nums, target, 0, pivot - 1);
        }
        // If the target is less than start, it means the target is in the sorted
        // array that is on the RIGHT side of pivot, as all the element on the
        // right side are less than the start
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
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
            // have been moved next to the pivot element but that will be caught in
            // this if block because this checks the previous block
            if (mid > start && nums[mid] < nums[mid - 1]) {
                // If the mid is smaller than the previous element then the previous
                // element is the largest element i.e. that is the pivot
                // Because in normal ascending sorted array element will be always
                // larger than the previous element
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                // IF: start is greater than mid,
                // THEN: elements are mid should be greater than mid (array is sorted)
                // AND: elements that are greater than mid are smaller than start (array
                // is rotated)
                // HENCE: all the mid and all the elements after mid should be smaller
                // than the start, but we need the largest element as the pivot
                // SO: the mid and all the elements after mid can be ignored
                end = mid - 1;
            } else {
                // We are not using ==> start = mid;
                // But we are using ==> start = mid + 1, if the middle element was the
                // pivot element it will be returned from the case 1 and 2
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int findPivotDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1:
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Case 2:
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // If elements from middle, start, and end are equal, then just skip the
            // duplicates
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // Skip the duplicates
                // NOTE: what if these start and elements were the pivots
                // Check if start is pivot
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // Check whether end is pivot
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // Left side is sorted so the pivot should be in the right side
            else if ((nums[start] < nums[mid]) || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
