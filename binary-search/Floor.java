public class Floor {
  public static void main(String[] args) {
    int[] nums = { 1, 3, 6 };
    int target = 2;

    int floorIndex = floor(nums, target);
    System.out.println(floorIndex);
  }

  public static int floor(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    if (target < nums[0]) {
      return -1;
    }

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (target == nums[mid]) {
        return mid;
      }

      if (target < nums[mid]) {
        end = mid - 1;
      }

      if (target > nums[mid]) {
        start = mid + 1;
      }
    }

    return end;
  }
}
