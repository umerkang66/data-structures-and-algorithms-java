public class Ceiling {
  public static void main(String[] args) {
    int[] nums = { 1, 3, 6, 8, 12, 16, 19, 21, 26, 32, 43, 54 };
    int target = 44;

    int searchedItem = ceiling(nums, target);
    System.out.println(searchedItem);
  }

  public static int ceiling(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
  
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

    // when while loop breaks start will become: end + 1
    return start;
  }
}
