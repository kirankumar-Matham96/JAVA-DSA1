package DynamicProgramming;

import java.util.ArrayList;

public class SubsetsSumToK {
    public static ArrayList<ArrayList<Integer>> dp;

    public static boolean helper(int[] arr, int n, int k, int idx) {
        // base cases
        if (k == 0) {
            return true;
        }
        if (idx < 0) {
            return false;
        }

        // memorization:
        if (dp.get(idx).get(k) != -1) {
            return dp.get(idx).get(k) == 1;
        }

        // choices
        boolean take = false, not_take;
        not_take = helper(arr, n, k, idx - 1);

        if (arr[idx] <= k) {
            take = helper(arr, n, k - arr[idx], idx - 1);
        }

        // optimal condition
        boolean temp = take || not_take;
        dp.get(idx).set(k, temp ? 1 : 0);
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {};
        int n = 4, k = 4;

        dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>(k + 1); // Corrected size of row
            for (int j = 0; j <= k; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        boolean ans = helper(arr, n, k, n - 1);

        if (ans) {
            System.out.println("Subset sum of K is possible");
        } else {
            System.out.println("Subset sum of K is not possible");
        }
    }
}
