public class SmallestLetter {
  public static void main(String[] args) {
    char[] letters = { 'a', 'b', 'f',  'g', 'k', 'm', 'o' };
    char target = 'g';

    char smallestGreaterLetter = smallestLetter(letters, target);
    System.out.println(smallestGreaterLetter);
  }

  public static char smallestLetter(char[] letters, char target) {
    int arrayLength = letters.length;
    int start = 0;
    int end = arrayLength - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (target < letters[mid]) {
        end = mid - 1;
      }

      if (target >= letters[mid]) {
        start = mid + 1;
      }
    }

    return letters[start % arrayLength];
  }
}
