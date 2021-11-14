import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" + "b");

        System.out.println((char)('a' + 3));
        System.out.println("a" + 1);
        // Integer will be converted into Integer instance and it will call toString

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(231);
        intList.add(122);
        System.out.println("Umer" + intList);
    }
}
