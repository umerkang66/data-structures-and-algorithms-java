import java.util.Arrays;

public class FirstLastPosition {
  public static void main(String[] args) {
    int[] nums = { 5, 7, 7, 7, 7, 8, 8, 10 };
    int target = 7;

    int[] position = searchRange(nums, target);
    System.out.println(Arrays.toString(position));
  }

  private static int[] searchRange(int[] nums, int target) {
    int[] ans = { -1, -1 };

    ans[0] = firstAndLastBinarySearch(nums, target, true);
    if (ans[0] != -1) {
      ans[1] = firstAndLastBinarySearch(nums, target, false);
    }

    return ans;
  }

  private static int firstAndLastBinarySearch(int[] nums, int target, boolean moveLeft) {
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
        if (moveLeft) {
          // Look at the left side
          end = mid - 1;
        } else {
          // Look at the right side
          start = mid + 1;
        }
        // Either move to the left or the right if it matches the target return mid
        result = mid;
      }
    }

    return result;
  }
}
