public class Main {
    public static void main(String[] args) {
        int rows = 5;

        pattern1(rows);
        pattern2(rows);
        pattern3(rows);
        pattern4(rows);
        pattern5(rows);
    }

    private static void pattern1(int rows) {
        for (int row = 1; row <= rows; row++) {
            // Here the col is equal to rows (not row)
            for (int col = 1; col <= rows; col++) {
                // For every row run the col
                System.out.print("*");
            }
            // When one row is printed we need to add new line
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern2(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                // For every row run the col
                System.out.print("*");
            }
            // When one row is printed we need to add new line
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern3(int rows) {
        for (int row = 1; row <= rows; row++) {
            // For every row columns should be rows - row + 1
            for (int col = 1; col <= rows - row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern4(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern5(int rows) {
        for (int row = 1; row < 2 * rows; row++) {
            int totalColsInRow = row <= rows ? row : rows * 2 - row;
            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }
}
