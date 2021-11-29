public class Main {
    public static void main(String[] args) {
        int rows = 5;
        pattern1(rows);
    }

    private static void pattern1(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                // For every row run the col
                System.out.print("*");
            }
            // When one row is printed we need to add new line
            System.out.println();
        }
    }
}
