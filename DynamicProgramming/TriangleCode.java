package DynamicProgramming;
import java.util.ArrayList;

public class TriangleCode {
    public static ArrayList<ArrayList<Integer>> dp;

    public static int helperTab(int[][] arr, int n) {
        dp.get(0).set(0, arr[0][0]);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
                if(j != i){
                    op1 = arr[i][j] + dp.get(i-1).get(j);
                }
                if(j != 0){
                    op2 = arr[i][j] + dp.get(i-1).get(j-1);
                }
                dp.get(i).set(j, Math.min(op1,op2));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp.get(n-1).get(i));
        }
        return ans;
    }

    public static int helper(int[][] arr, int n, int row, int col) {
        // base case
        if(row == n-1){
            return arr[n-1][col];
        }

        if(dp.get(row).get(col) != -1){
            return dp.get(row).get(col);
        }

        // options
        int opt1, opt2;
        opt1 = arr[row][col] + helper(arr, n, row+1, col);
        opt2 = arr[row][col] + helper(arr, n, row+1, col+1);

        // optimal condition
        int ans = Math.min(opt1, opt2);
        dp.get(row).set(col,ans);
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };

        int n = 4;
        dp = new ArrayList<>();

//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> row = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                row.add(-1);
//            }
//            dp.add(row);
//        }
//
//        int ans = helper(arr,n,0,0);
//        System.out.println("Minimum path sum: "+ans);

        // For Tabulation
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        int ans = helperTab(arr,n);
        System.out.println("Minimum path sum: "+ans);
    }
}

