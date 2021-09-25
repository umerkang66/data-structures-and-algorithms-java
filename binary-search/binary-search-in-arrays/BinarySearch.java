// O(log N)
public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 5, 6, 23, 26, 32, 43, 76, 99 };
    int[] arr2 = { 23, 12, 8, 5, 2, 1 };

    int target = 3;
    int target2 = 12;

    int searchedItem = binarySearch(arr, target);
    System.out.println(searchedItem);

    int searchedItemOrderAgnostic = orderAgnosticBinarySearch(arr2, target2);
    System.out.println(searchedItemOrderAgnostic);
  }

  // Return the index
  // return -1 if doesn't exist
  private static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      // Find the middle element
      int mid = start + (end - start) / 2;

      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  private static int orderAgnosticBinarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    // Find the whether the array is sorted in ascending or descending order
    boolean isAscending;
    isAscending = (arr[start] < arr[end]);

    while (start <= end) {
      // Find the middle element
      int mid = start + (end - start) / 2;

      if (target == arr[mid]) {
        return mid;
      }

      if (isAscending) {
        if (target < arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }

    return -1;
  }
}
