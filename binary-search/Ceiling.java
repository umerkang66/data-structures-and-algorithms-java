public class Ceiling {
  public static void main(String[] args) {
    int[] nums = { 1, 3, 6 };
    int target = 2;

    int ceilIndex = ceiling(nums, target);
    System.out.println(ceilIndex);
  }

  /*
   * 1st iteration: when the target is low than mid element, the end will become
   * mid - 1 2nd iteration: when the target is high than mid element, the start
   * will become mid + 1 Hence we return the start because it will be the minimum
   * greater element from the target
   */
  public static int ceiling(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    if (target > nums[nums.length - 1]) {
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

    return start;
  }
}
