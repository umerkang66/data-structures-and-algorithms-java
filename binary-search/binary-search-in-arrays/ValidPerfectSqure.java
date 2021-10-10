public class ValidPerfectSqure {
  public static void main(String[] args) {
    int num = 16;
    boolean perfectSquare = isPerfectSquare(num);

    System.out.println(perfectSquare);
  }

  private static boolean isPerfectSquare(int num) {
    if (num < 2) {
      return true;
    }

    long start = 2;
    long end = num;

    while (start <= end) {
      long mid = start + (end - start) / 2;

      if ((mid * mid) == num) {
        return true;
      } else if ((mid * mid) < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }
}
