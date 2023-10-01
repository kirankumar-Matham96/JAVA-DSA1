public class Fibonacci {
    public static int fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        int fib1 = fibonacci(n-1);
        int fib2 = fibonacci(n-2);

        return fib1 + fib2;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
