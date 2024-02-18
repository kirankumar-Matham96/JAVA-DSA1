package DynamicProgramming;

import java.util.ArrayList;
// not yet completed!
public class UniquePaths {

    public static int helperTabular(int[][] grid, int n, int m) {
        for (int i = 0; i < m; i++) {
            if(grid[0][i] == -1){
                break;
            }
            dp.get(0).set(i, 1);
        }

        for (int i = 0; i < n; i++) {
            if(grid[i][0] == -1){
                break;
            }
            dp.get(i).set(0, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == -1){
                    dp.get(i).set(j, 0);
                }else{
                    dp.get(i).set(j, dp.get(i-1).get(j) + dp.get(i).get(j-1));
                }
            }
        }

        return dp.get(n-1).get(m-1);
    }
    public static int helper(int[][] grid,int i,int j) {
        if(i == 0 && j == 0){
            return 1;
        }

        if(i < 0 || j < 0){
            return 0;
        }

        if(grid[i][j] == -1){
            return 0;
        }

        if(dp.get(i).get(j) != -1){

        }

        int way1, way2;

        way1 = helper(grid, i-1, j);
        way2 = helper(grid, i, j-1);

        int ans = way1+way2;
        dp.get(i).set(j, ans);
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> dp;
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,-1,0},
                {0,0,0}
        };
        int n = 3;
        int m = 3;
//        dp = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> row = new ArrayList<>();
//            for (int j = 0; j < m; j++) {
//                row.add(-1);
//            }
//            dp.add(row);
//        }
//        int ans = helper(grid,2,2);
//        System.out.println("Total unique paths: "+ ans);

        dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            dp.add(row);
        }
        int ansTabular = helperTabular(grid,n-1,m-1);

        System.out.println("Total unique paths TABULAR: "+ ansTabular);

    }
}
