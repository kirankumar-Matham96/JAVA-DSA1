package Backtrack;

public class FindWord {

    public static boolean searchWord(char[][] board, String word, int currentPosition, int i, int j, int n, int m, int[][] visited) {
        visited[i][j] = 1;

        if(currentPosition == word.length()){
            return true;
        }

        visited[i][j] = 1;

        // right direction
        if(j+1 < m && visited[i][j+1] == 0 && board[i][j+1] == word.charAt(currentPosition)){
            return searchWord(board, word, currentPosition+1,i,j+1,n, m, visited);
        }

        // down direction
        if(i+1 < n && visited[i+1][j] == 0 && board[i+1][j] == word.charAt(currentPosition)){
            return searchWord(board, word, currentPosition+1,i+1,j,n, m, visited);
        }

        // left direction
        if(j-1 >= 0 && visited[i][j-1] == 0 && board[i][j-1] == word.charAt(currentPosition)){
            return searchWord(board, word, currentPosition+1,i,j-1,n, m, visited);
        }

        // up direction
        if(i-1 >= 0 && visited[i-1][j] == 0 && board[i-1][j] == word.charAt(currentPosition)){
            return searchWord(board, word, currentPosition+1,i-1,j,n, m, visited);
        }
        visited[i][j] = 0;
        return false;
    }

    public static boolean findWord(char[][] maze, String word, int n, int m) {

        int visited[][] = new int[n][m];

        // search every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == word.charAt(0)){
                    if(searchWord(maze, word, 1, i, j, n, m, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'e', 'h', 'm', 'e'},
                {'o', 'a', 'l', 'd'},
                {'l', 'o', 'l', 'o'},
                {'r', 's', 't', 'l'}
        };

        char[][] board2 = {
                {'c','z','k','l'},
                {'o','d','i','a'},
                {'r','g','n','m'},
                {'m','r','s','d'}
        };
        String word = "coding";
        boolean isWordPresent = findWord(board2, word, board.length, board[0].length);

        System.out.println("isWordPresent: "+isWordPresent);
    }
}

