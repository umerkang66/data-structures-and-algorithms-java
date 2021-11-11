public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" + "b");

        System.out.println((char)('a' + 3));
        System.out.println("a" + 1);
        // Integer will be converted into Integer instance and it will call toString
    }
}
