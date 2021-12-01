public class Main {
    public static void main(String[] args) {
        int rows = 4;

        pattern1(rows);
        pattern2(rows);
        pattern3(rows);
        pattern4(rows);
        pattern5(rows);
        pattern28(rows);
        pattern30(rows);
        pattern17(rows);
        pattern31(rows);
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
            int totalColsInRow = row <= rows ? row : 2 * rows - row;
            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern28(int rows) {
        for (int row = 1; row < 2 * rows; row++) {
            int totalColsInRow = row <= rows ? row : 2 * rows - row;
            int totalSpaces = rows - totalColsInRow;
            for (int space = 1; space <= totalSpaces; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern30(int rows) {
        for (int row = 1; row <= rows; row++) {
            int totalSpaces = rows - row;
            for (int space = 1; space <= totalSpaces; space++) {
                // Extra space is added to make it prettier
                System.out.print("  ");
            }
            for (int firstCol = row; firstCol >= 1; firstCol--) {
                // Extra space is added to make it prettier
                System.out.print(firstCol + " ");
            }
            for (int secondCol = 2; secondCol <= row; secondCol++) {
                // Extra space is added to make it prettier
                System.out.print(secondCol + " ");
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern17(int rows) {
        for (int row = 1; row < 2 * rows; row++) {
            int maxNumberInRow = row <= rows ? row : 2 * rows - row;
            int totalSpaces = rows - maxNumberInRow;
            for (int space = 1; space <= totalSpaces; space++) {
                System.out.print(" ");
            }
            for (int colStart = maxNumberInRow; colStart >= 1; colStart--) {
                System.out.print(colStart);
            }
            for (int colEnd = 2; colEnd <= maxNumberInRow; colEnd++) {
                System.out.print(colEnd);
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }

    private static void pattern31(int rows) {
        int originalRows = rows;
        rows = 2 * rows;
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < rows; col++) {
                // 1) Top: row
                // 2) Left: col
                // 3) Bottom: rows - row
                // 4) Right: rows - col
                // Then we will subtract it from originalRows
                int atEveryIndex =  originalRows - Math.min(Math.min(row, col), Math.min(rows - row, rows - col)) + 1;
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
        // Not related to the algorithm
        System.out.println("\n");
    }
}
