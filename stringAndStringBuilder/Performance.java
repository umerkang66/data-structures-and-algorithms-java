public class Performance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char character = (char)('a' + i);
            series += character;
        }
        System.out.println(series);
    }
}
