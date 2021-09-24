public class Sqrt {
  public static void main(String[] args) {
    int num = 4;
    int sqrt = findSquareRoot(num);

    System.out.println(sqrt);
  }

  private static int findSquareRoot(int num) {
    long start = 1;
    long end = num;

    while (start <= end) {
      long mid = start + (end - start) / 2;

      if (mid * mid > num) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    // Do not return start
    return (int) end;
  }
}
