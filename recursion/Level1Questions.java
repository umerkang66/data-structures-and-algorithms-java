public class Level1Questions {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
        printNto1(n);
        print1toN(n);
    }

    private static void printNto1(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printNto1(n - 1);
    }

    private static void print1toN(int n) {
        if (n <= 0) {
            return;
        }
        print1toN(n - 1);
        System.out.println(n);
    }

    private static int factorial(int n) {
        // We donot have to go till 1 because 1 x "some-number" is always the "some-number" 
        if (n == 2) {
            return n;
        }
        return factorial(n - 1) * n;
    }
}
