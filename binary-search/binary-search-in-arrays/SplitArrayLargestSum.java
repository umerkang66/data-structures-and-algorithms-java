public class SplitArrayLargestSum {
  public static void main(String[] args) {
    int[] nums = { 7, 2, 5, 10, 8 };
    int m = 2;

    int smallestLargestSum = splitArray(nums, m);
    System.out.println(smallestLargestSum);
  }

  private static int splitArray(int[] nums, int m) {
    int start = 0;
    int end = 0;

    for (int i = 0; i < nums.length; i++) {
      // In the end of the loop it will contain the max element from the array
      start = Math.max(start, nums[i]);
      // End is sum of all the values
      end += nums[i];
    }

    // Binary search
    while (start < end) {
      // Try for the middle as the potential answer
      int mid = start + (end - start) / 2;

      // Calculate how many pieces you can divide this in with this max sum
      int sum = 0;
      int pieces = 1;

      for (int num : nums) {
        if (sum + num > mid) {
          // You cannot add this in current subarray, make new one
          // Say you add this num in new subarray, then sum = num
          sum = num;
          pieces++;
        } else {
          sum += num;
        }
      }

      if (pieces > m) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    // Here start == end
    return start;
  }
}
