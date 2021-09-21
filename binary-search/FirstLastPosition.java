import java.util.Arrays;

public class FirstLastPosition {
  public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
    int target = 8;

    int[] position = searchRange(nums, target);
    System.out.println(Arrays.toString(position));
  }

  public static int[] searchRange(int[] nums, int target) {
    int[] ans = { -1, -1 };
    ans[0] = binarySearch(nums, target, true);
    ans[1] = binarySearch(nums, target, false);

    return ans;
  }

  public static int binarySearch(int[] nums, int target, boolean findStartIndex) {
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
        if (findStartIndex) end = mid - 1;
        else start = mid + 1;
        
        foundPosition = mid;
      }
    }

    return foundPosition;
  }
}
