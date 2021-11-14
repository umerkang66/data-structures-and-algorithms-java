import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String firstname = "umerkang";
        System.out.println(Arrays.toString(firstname.toCharArray()));
        System.out.println(Arrays.toString(firstname.split("e")));
    }
}
