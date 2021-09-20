public class Ceiling {
  public static void main(String[] args) {
    int[] nums = { 1, 3, 6, 8, 12, 16, 19, 21, 26, 32, 43, 54 };
    int target = 43;

    int searchedItem = ceiling(nums, target);
    System.out.println(searchedItem);
  }

  public static int ceiling(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int minGreater = Integer.MAX_VALUE;
    int minGreaterIndex = 0;

    while (start < end) {
      int mid = start + (end - start) / 2;

      if (target == nums[mid]) {
        return mid;
      }

      if (target < nums[mid]) {
        end = mid - 1;
        if (nums[mid] > target) {
          if (nums[mid] < minGreater) {
            minGreater = nums[mid];
            minGreaterIndex = mid;
          }
        }
      }

      if (target > nums[mid]) {
        start = mid + 1;
        if (nums[mid] > target) {
          if (nums[mid] < minGreater) {
            minGreater = nums[mid];
            minGreaterIndex = mid;
          }
        }
      }
    }

    // Process will get here only if the exact match does not found
    return minGreaterIndex;
  }
}
