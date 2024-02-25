package DynamicProgramming;

import java.util.ArrayList;

public class MatrixChainMultiplication {

    public static ArrayList<ArrayList<Integer>> dp;

    private static int helper(int[] arr, int i, int j) {
        // base case
        if(i == j){
            return 0;
        }

        if(dp.get(i).get(j) != -1){
            return dp.get(i).get(j);
        }
        // choices
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = helper(arr, i, k) + helper(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            mini = Math.min(mini, temp);
        }
        
        // optimal condition
        dp.get(i).set(j,mini);
        return mini;
    }

    public static void main(String[] args) {
        int[] arr = {10,15,20,25};
        int N = arr.length;

        dp = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            ArrayList<Integer> row = new ArrayList<>(N+1);
            for (int j = 0; j <= N; j++) {
                row.add(-1);
            }
            dp.add(row);
        }
        int ans = helper(arr, 1, N-1);
        System.out.println(ans);
    }

}
