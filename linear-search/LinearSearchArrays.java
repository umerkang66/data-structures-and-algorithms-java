public class LinearSearchArrays {
  // Returns the index if item is found, return -1 if it doesn't found
  public int linearSearch(int[] intArr, int target) {
    if (intArr.length <= 0) {
      return -1;
    }

    for (int i = 0; i < intArr.length; i++) {
      if (intArr[i] == target) {
        return i;
      }
    }

    return -1;
  }

  public int linearSearch2(int[] intArr, int target) {
    if (intArr.length <= 0) {
      return -1;
    }

    for (int i = 0; i < intArr.length; i++) {
      int element = intArr[i];

      if (element == target) {
        return element;
      }
    }

    return Integer.MAX_VALUE;
  }
}
