import java.util.Arrays;

public class FirstLastPosition {
  public static void main(String[] args) {
    int[] nums = { 5, 7, 7, 7, 7, 8, 8, 10 };
    int target = 7;

    int[] position = searchRange(nums, target);
    System.out.println(Arrays.toString(position));

    System.out.println(findFirstOccurence(nums, target));
  }

  private static int[] searchRange(int[] nums, int target) {
    int[] ans = { -1, -1 };

    ans[0] = binarySearch(nums, target, true);
    if (ans[0] != -1) {
      ans[1] = binarySearch(nums, target, false);
    }

    return ans;
  }

  private static int binarySearch(int[] nums, int target, boolean findStartIndex) {
    int start = 0;
    int end = nums.length - 1;
    int foundPosition = -1;

    while (start <= end) {
      // Find the middle element
      int mid = start + (end - start) / 2;

      // Moving to left side or right side of array
      if (target < nums[mid]) {
        end = mid - 1;
      } else if (target > nums[mid]) {
        start = mid + 1;
      } else {
        if (findStartIndex) {
          end = mid - 1;
        }
        else {
          start = mid + 1;
        }
        foundPosition = mid;
      }
    }

    return foundPosition;
  }

  private static int findFirstOccurence(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int result = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (target < nums[mid]) {
        end = mid - 1;
      } else if (target > nums[mid]) {
        start = mid + 1;
      } else {
        result = mid;
        end = mid - 1;
      }
    }

    return result;
  }
}
