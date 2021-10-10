public class PeakIndexMountainArr {
  public static void main(String[] args) {
    int[] nums = { 2, 5, 3, 2 };
    int peakItemIndex = peakIndexMountainArr(nums);

    System.out.println(peakItemIndex);
  }

  private static int peakIndexMountainArr(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] > nums[mid + 1]) {
        // You are in decreasing part of array
        // This may be the answer but look at left
        // This is why end != mid - 1
        end = mid;
      } else {
        // You are in ascending part of array
        // Because mid + 1 is greater than mid, hence we ignore mid element
        start = mid + 1;
      }
    }

    // In the end nums[start] == nums[end], pointing to the largest number
    // Start and end always trying to find the max element in the above 2 checks
    // Hence when they are pointing to just one element, that will be the maximum
    // one
    // So we can return either start or end, they are pointing to same element
    // More Elaboration: At every point of time for start and end, they have the
    // best possible answer till that time, and if we are saying that only one item
    // is remaining, hence cause of the above line that is best possible answer
    return start;
  }
}
