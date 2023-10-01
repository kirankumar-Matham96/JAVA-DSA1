public class sumOfNNumbers {
    public static int factorial(int n) {
        if (n >= 1)
            return n * factorial(n - 1);
        else
            return 1;
    }

    public static int sumOfNNaturalNumbers(int n) {
        if(n == 0){
            return 0;
        }
        return n+sumOfNNaturalNumbers(n-1);
    }

    public static void main(String[] args) {
        int fact = factorial(10);
        int sum = sumOfNNaturalNumbers(10);
        System.out.println(fact);
        System.out.println(sum);
    }
}
