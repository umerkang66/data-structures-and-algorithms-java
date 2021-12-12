public class MainTimeComplexity {
    public static void main(String[] args) {
        int fib = fibonacci(7);
        System.out.println(fib);
    }

    private static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
