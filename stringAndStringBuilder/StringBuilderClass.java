public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char character = (char)('a' + i);
            // Appending is much faster in stringBuilder
            builder.append(character);
        }
        System.out.println(builder.toString());
    }
}
