public class PatternQuestion1 {
    public static void main(String[] args) {
        int rows = 4;
        patternQuestion1(rows);
    }

    private static void patternQuestion1(int rows) {
        for (int i = 0; i < rows; i++) {
            StringBuilder patternString = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                patternString.append("* ");
            }
            System.out.println(patternString.toString() + "\n");
        }
    }
}
