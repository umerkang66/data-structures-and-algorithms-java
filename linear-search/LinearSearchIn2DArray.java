public class LinearSearchIn2DArray {
  public int[] linearSearchIn2DArray(int[][] array, int target) {
    if (array.length <= 0) {
      return new int[] {};
    }

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] == target) {
          return new int[] { i, j };
        }
      }
    }

    return new int[] {};
  }

  public int maxIn2DArray(int[][] array) {
    int maxValue = Integer.MIN_VALUE;

    for (int[] ints: array) {
      for (int element: ints) {
        if (element > maxValue) {
          maxValue = element;
        }
      }
    }

    return maxValue;
  }

  public boolean linearSearchIn2DArray2(int[][] array, int target) {
    if (array.length <= 0) {
      return false;
    }

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] == target) {
          return true;
        }
      }
    }

    return false;
  }
}
