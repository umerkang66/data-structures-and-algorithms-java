public class RotatedBinarySearch {
  public static void main(String[] args) {
    int[] nums = { 12, 13, 7, 8, 9, 10, 11 };
    int target = 13;

    int searchedIndex = rotatedBinarySearch(nums, target);
    System.out.println(searchedIndex);
  }

  private static int rotatedBinarySearch(int[] nums, int target) {
    int pivot = findPivot(nums);
    int pivotDuplicate = findPivotDuplicate(nums);
    System.out.println(pivotDuplicate);

    if (pivot == -1) {
      // Pivot is not found, it is not rotated array
      // Just do normal binary search
      return binarySearch(nums, target, 0, nums.length - 1);
    }

    // If pivot is found, you have found 2 ascending 2 sorted arrays
    if (nums[pivot] == target) {
      return pivot;
    }

    if (target >= nums[0]) {
      return binarySearch(nums, target, 0, pivot - 1);
    }

    return binarySearch(nums, target, pivot + 1, nums.length - 1);
  }

  // This will not work for the duplicate values
  private static int findPivot(int[] nums) {
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

      // Case 3:
      if (nums[mid] <= nums[start]) {
        end = mid - 1;
      } // Case 4:
      else if (nums[mid] > nums[start]) {
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

      // If elements from middle, start, and end are equal, then just skip the duplicates
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

  private static int binarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
      // Find the middle element
      int mid = start + (end - start) / 2;

      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}
