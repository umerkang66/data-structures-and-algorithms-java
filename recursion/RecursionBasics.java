public class RecursionBasics {
    public static void main(String[] args) {
        int num = 7;
        printNum(num);

        int fib = fibonacci(num);
        System.out.println(fib);
    }

    private static void printNum(int num) {
        // Base condition
        if (num > 5) {
            return;
        }
        System.out.println(num);
        printNum(num + 1);
    }

    private static int fibonacci(int num) {
        // Fibonacci Numbers 0,1,1,2,3,5,8,13
        // We are putting this base condition because we know that:
        // 1) Fibonacci number for (0) is always 0
        // 2) Fibonacci number for (1) is always 1
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
