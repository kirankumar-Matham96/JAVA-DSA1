package DynamicProgramming;

import java.util.ArrayList;

public class LeastCommonSubset {
    public static ArrayList<ArrayList<Integer>> dp;

    private static int helper(String s, String t, int idx1, int idx2) {
        // base case
        if (idx1 < 0 || idx2 < 0){
            return 0;
        }

        // memorization
        if(dp.get(idx1).get(idx2) != -1){
            return dp.get(idx1).get(idx2);
        }

        // choices
        if (s.charAt(idx1) == t.charAt(idx2)){
            int temp = 1 + helper(s,t,idx1-1, idx2-1);
            dp.get(idx1).set(idx2, temp);
            return temp;
        } else {
            // optimal condition
           int temp = Math.max(helper(s,t,idx1-1,idx2), helper(s,t,idx1,idx2-1));
            dp.get(idx1).set(idx2, temp);
           return temp;
        }


    }

    private static int helperTabulation(String s, String t, int n, int m){
        for (int i = 0; i <= m; i++) {
            dp.get(0).set(i,0);
        }

        for (int i = 0; i <= n; i++) {
            dp.get(i).set(0,0);
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    int temp = 1 + dp.get(i-1).get(j-1);
                    dp.get(i).set(j, temp);
                } else {
                    // optimal condition
                    int temp = Math.max(dp.get(i-1).get(j-1), dp.get(i).get(j-1));
                    dp.get(i).set(j, temp);
                }
            }
        }

        return dp.get(n).get(m);
    }

    public static void main(String[] args) {
        String s = "adebc";
        String t = "dbadb";

        int n = s.length(), m = t.length();

        dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>(m+1);
            for (int j = 0; j <= m+1; j++) {
                row.add(-1);
            }
            dp.add(row);
        }
        int ans = helper(s,t,n-1,m-1);
        int ans2 = helperTabulation(s,t,n,m);
        System.out.println("LCS: ans1: "+ans+" ans2: "+ans2);
    }
}
