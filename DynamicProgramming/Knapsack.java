package DynamicProgramming;

import java.util.ArrayList;

public class Knapsack {
    public static ArrayList<ArrayList<Integer>> dp;

    // memorization code
    private static int knapsack(int w, int[] val, int[] wt, int idx) {
        // base
        if(idx < 0){
            return 0;
        }

        // memorization
        if(dp.get(idx).get(w) != -1){
            dp.get(idx).get(w);
        }

        // choice
        int take = Integer.MAX_VALUE, not_take;
        not_take = knapsack(w, val, wt, idx-1);

        if(wt[idx] <= w){
            take = val[idx] + knapsack(w-wt[idx], val, wt, idx-1);
        }

        // optimal condition
        int temp = Math.max(take, not_take);
        dp.get(idx).set(w, temp);
        return temp;
    }

    // tabulation code
    public static int knapsackTab(int w, int[] val, int[] wt, int n) {
        for (int i = 0; i <= w; i++) {
            dp.get(0).set(i, 0);
        }
        for (int i = 0; i <= n; i++) {
            dp.get(i).set(0,0);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                int take = Integer.MAX_VALUE, not_take;
                not_take = dp.get(i-1).get(j);

                if(wt[i-1] <= j){
                    take = val[i-1] + dp.get(i-1).get(j-wt[i-1]);
                }

                int temp = Math.max(take, not_take);
                dp.get(i).set(j, temp);
            }
        }
        return dp.get(n).get(w);
    }

    public static void main(String[] args) {
        int w = 5;
        int[] val = {5,4,8,6};
        int[] wt = {1,2,4,5};
        int n = 4;

        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>(w+1);
            for (int j = 0; j <= w; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        // int ans = knapsack(w, val, wt, n-1);
        int ans = knapsackTab(w, val, wt, n);
        System.out.println("Max. Profit: "+ans);
    }
}
