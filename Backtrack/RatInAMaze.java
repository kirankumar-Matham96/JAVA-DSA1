package Backtrack;

import java.util.*;

public class RatInAMaze {


    /**
     * From scratch: https://takeuforward.org/data-structure/rat-in-a-maze/
     */

    private static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move,
                              int vis[][], int di[], int dj[]) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                    vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

                vis[i][j] = 1;
                solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;

            }
        }
    }
    public static ArrayList < String > findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        int di[] = {
                +1,
                0,
                0,
                -1
        };
        int dj[] = {
                0,
                -1,
                1,
                0
        };
        ArrayList < String > ans = new ArrayList < > ();
        if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis, di, dj);
        return ans;
    }

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * From scratch: https://www.geeksforgeeks.org/java-program-for-rat-in-a-maze-backtracking-2/
     */
    public static final int N = 4;

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    /* A utility function to check if x, y is valid
        index for N*N maze */
    public static boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    /* This function solves the Maze problem using
       Backtracking. It mainly uses solveMazeUtil()
       to solve the problem. It returns false if no
       path is possible, otherwise return true and
       prints the path in the form of 1s. Please note
       that there may be more than one solutions, this
       function prints one of the feasible solutions.*/
    public static boolean solveMaze(int maze[][]) {
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze
       problem */
    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            // mark x, y as part of solution path
            sol[x][y] = 1;

            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            /* If moving in x direction doesn't give
               solution then  Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            /* If none of the above movements works then
               BACKTRACK: unmark x, y as part of solution
               path */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }


    // ++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * From Class ->
     *
     * @param maze
     * @return
     */

    public static boolean ratInAMaze(int maze[][]) {
        int n = maze.length;
        int[][] path = new int[n][n];

        return solveMaze(maze, 0, 0, path);
    }

    public static void printRatInAMaze(int maze[][]) {
        int n = maze.length;
        int[][] path = new int[n][n];

        printAllPaths(maze, 0, 0, path);
    }

    public static void printAllPaths(int[][] maze, int i, int j, int[][] path) {
        // if i, j is valid?
        if (i < 0 || i >= maze.length || j < 0 || j >= maze.length || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }

        // include the current cell in the path
        path[i][j] = 1;

        // check if the current cell is the destination cell
        if (i == maze.length - 1 && j == maze.length - 1) {
            // destination cell
            for (int r = 0; r < maze.length; r++) {
                for (int c = 0; c < maze.length; c++) {
                    System.out.print(path[r][c] + " ");
                }
            }
            System.out.println();

            path[i][j] = 0;
            return;
        }

        /* explore further in all directions */
        // top
        printAllPaths(maze, i - 1, j, path);

        // right
        printAllPaths(maze, i, j + 1, path);

        // down
        printAllPaths(maze, i + 1, j, path);

        // left
        printAllPaths(maze, i, j - 1, path);
        path[i][j] = 0;
    }

    public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
        // if i, j is valid?
        if (i < 0 || i >= maze.length || j < 0 || j >= maze.length || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }

        // include the current cell in the path
        path[i][j] = 1;

        // check if the current cell is the destination cell
        if (i == maze.length - 1 && j == maze.length - 1) {
            // destination cell
            for (int r = 0; r < maze.length; r++) {
                for (int c = 0; c < maze.length; c++) {
                    System.out.print(path[r][c] + " ");
                }
                System.out.print(" ");
            }
            return true;
        }

        /* explore further in all directions */
        // top
        if (solveMaze(maze, i - 1, j, path)) {
            return true;
        }

        // right
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }

        // down
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }

        // left
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze1 = {{1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] maze2 = {{1, 1, 0}, {1, 0, 1}, {0, 1, 1}};
        int[][] maze3 = {{1, 1}, {1, 1}};
        int[][] maze4 = {{1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1},
                {0, 0, 0, 1, 1, 1}};
//        boolean pathPossible = ratInAMaze(maze1);
//        System.out.println(pathPossible);
//        System.out.println("\nAll paths: \n");
//
//        printRatInAMaze(maze3);

        int[][] maze5 = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

//        solveMaze(maze5);

        ArrayList < String > res = findPath(maze1, maze5.length);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}
