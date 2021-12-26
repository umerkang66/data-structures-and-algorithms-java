public class FindNegativeInGrid {
  public static void main(String[] args) {
    int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };

    int negatives = countNegatives(grid);
    System.out.println(negatives);
  }

  private static int countNegatives(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      ans += binarySearch(grid[i]);
    }
    return ans;
  }

  private static int binarySearch(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    int count = 0;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      // It is in decending order
      if (arr[mid] >= 0) {
        start = mid + 1;
      } else {
        count += end - mid + 1;
        end = mid - 1;
      }
    }
    return count;
  }
}
