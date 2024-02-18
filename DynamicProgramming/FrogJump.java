package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {

    public static int[] dp;
    public static int frogJumpHelper(int[] heights, int n) {
        // memorization
        // base condition
        if(n==1){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        // choices
        int opt1 = 0;
        int opt2 = Integer.MAX_VALUE;

        opt1 = Math.abs(heights[n-1]-heights[n-2]) + frogJumpHelper(heights, n-1);

        if(n-2 > 0){
            opt2 = Math.abs(heights[n-1]-heights[n-3]) + frogJumpHelper(heights, n-2);
        }

        dp[n] = Math.min(opt1, opt2);
        // optimal condition
        return dp[n];
    }


    public static int frogJumpHelper2(int[] heights, int n) {
        // tabulation
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int opt1, opt2 = Integer.MAX_VALUE;
            opt1 = Math.abs(heights[i-1]-heights[i-2]) + dp[i-1];

            if(i-2 > 0){
                opt2 = Math.abs(heights[i-1]-heights[i-3]) + dp[i-2];
            }
            dp[i] = Math.min(opt1, opt2);
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int[] heights = {4,8,3,10,4,4};
        dp = new int[7];
        Arrays.fill(dp, -1);
        int ans = frogJumpHelper(heights, 6);

        System.out.println(ans);
    }
}
