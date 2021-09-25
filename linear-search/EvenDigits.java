public class EvenDigits {
  public int findEvenDigits(int[] array) {
    int count = 0;
    for (int num : array) {
      if (even(num)) {
        count++;
      }
    }

    return count;
  }

  private boolean even(int num) {
    int numberOfDigits = digits(num);
    int numberOfDigits2 = digits2(num);
    return (numberOfDigits % 2 == 0 && numberOfDigits2 % 2 == 0);
  }

  private int digits(int num) {
    int count = 0;
    while (num > 0) {
      count++;
      num /= 10;
    }

    return count;
  }

  private int digits2(int num) {
    return (int) Math.log10(num) + 1;
  }
}
