public class Level1Questions {
    private static int reverseActualSum = 0;

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
        printNto1(n);
        print1toN(n);
        System.out.println(sumOfN(n));

        System.out.println(sumOfDigits(125));
        System.out.println(prodOfDigits(505));

        reverseNum(1234);
        System.out.println(reverseActualSum);

        System.out.println(reverseNum2(5432));
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
        if (n <= 1) {
            return n;
        }
        return n * factorial(n - 1);
    }

    private static int sumOfN(int n) {
        if (n <= 0) {
            return n;
        }
        return n + sumOfN(n - 1);
    }

    private static int sumOfDigits(int num) {
        if (num / 10 <= 0)
            return num;
        return num % 10 + sumOfDigits(num / 10);
    }

    private static int prodOfDigits(int num) {
        if (num / 10 <= 0) {
            return num;
        }
        return num % 10 * prodOfDigits(num / 10);
    }

    private static void reverseNum(int num) {
        if (num == 0) {
            return;
        }
        int remainder = num % 10;
        // The "variable" below is is static class variable
        reverseActualSum = reverseActualSum * 10 + remainder;
        reverseNum(num / 10);
    }

    private static int reverseNum2(int num) {
        // Sometime you might need some additional variables in the arguments, in that
        // case make another function
        int digits = (int) (Math.log10(num)) + 1;
        return helper(num, digits);
    }

    private static int helper(int num, int digits) {
        if (num % 10 <= 0) {
            return num;
        }
        int remainder = num % 10;
        return remainder * (int) Math.pow(10, digits - 1) + helper(num / 10, digits - 1);
    }
}
