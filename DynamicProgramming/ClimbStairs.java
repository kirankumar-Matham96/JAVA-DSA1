package DynamicProgramming;

public class ClimbStairs {
    public static int climbStairs(long nStairs) {
        if (nStairs == 0 || nStairs == 1) {
            return 1;
        }

        long[] dp = new long[(int) (nStairs + 1)];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= nStairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return (int) dp[(int) nStairs];
    }

    public static void main(String[] args) {
        long n = 51L; // Example input, you can change it as needed
        System.out.println("Number of distinct ways to climb " + n + " stairs: " + climbStairs(n));
    }
}
