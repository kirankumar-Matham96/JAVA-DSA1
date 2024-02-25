package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubset {
    public static ArrayList<ArrayList<Integer>> dp;

    private static int helper(int[] arr, int n, int idx, int pre_idx) {
        // base case
        if(idx == n){
            return 0;
        }

        // Memorization
        if(dp.get(idx).get(pre_idx+1) != -1){
            return dp.get(idx).get(pre_idx+1);
        }

        // choices
        int take = Integer.MIN_VALUE, notTake;

        notTake = helper(arr, n, idx+1,pre_idx);

        if(pre_idx == -1 || arr[idx] > arr[pre_idx] ){
            take = helper(arr, n, idx+1, idx) + 1;
        }

        // optimal condition
        int temp = Math.max(take, notTake);
        dp.get(idx).set(pre_idx+1, temp);
        return temp;

    }

    private static int helperTabulation(int[] arr, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp.get(i).set(j, 0);
            }
        }

        for (int idx = n-1; idx >= 0; idx--) {
            for (int pre_idx = idx-1; pre_idx >= -1; pre_idx--) {
                int take = Integer.MIN_VALUE, notTake;
                notTake = dp.get(idx+1).get(pre_idx+1);
                if(pre_idx == -1 || arr[idx] > arr[pre_idx] ){
                    take = dp.get(idx+1).get(idx+1);
                }
                int temp = Math.max(take, notTake);
                dp.get(idx).set(pre_idx+1, temp);
            }
        }
        return dp.get(0).get(0);
    }

    public static void main(String[] args) {
        int[] arr = {5,4,11,1,16,8};
        int n = arr.length;

        dp = new ArrayList<>(n+1);

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>(n+1);
            for (int j = 0; j <= n; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

//        int ans = helper(arr, n, 0, -1);
        int ans = helperTabulation(arr, n);
        String ans2 = "Not done yet";
        System.out.println("ans1: "+ans+" ans2: "+ans2);
    }
}
