package Graphs;

import java.io.*;
import java.util.*;

public class HasPath {

//    from chat-GPT
//    public static boolean isPathExists(int[][] graph, int v1, int v2) {
//        int n = graph.length;
//        boolean[] visited = new boolean[n];
//        Queue<Integer> queue = new LinkedList<>();
//        visited[v1] = true;
//        queue.offer(v1);
//
//        while (!queue.isEmpty()) {
//            int currentVertex = queue.poll();
//            if (currentVertex == v2) {
//                return true;
//            }
//            for (int i = 0; i < n; i++) {
//                if (graph[currentVertex][i] == 1 && !visited[i]) {
//                    visited[i] = true;
//                    queue.offer(i);
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] line = reader.readLine().trim().split(" ");
//        int n = Integer.parseInt(line[0]); // Number of vertices
//        int e = Integer.parseInt(line[1]); // Number of edges
//
//        int[][] graph = new int[n][n];
//        for (int i = 0; i < e; i++) {
//            line = reader.readLine().trim().split(" ");
//            int v1 = Integer.parseInt(line[0]);
//            int v2 = Integer.parseInt(line[1]);
//            graph[v1][v2] = 1;
//            graph[v2][v1] = 1; // Assuming undirected graph
//        }
//
//        line = reader.readLine().trim().split(" ");
//        int v1 = Integer.parseInt(line[0]); // Vertex 1
//        int v2 = Integer.parseInt(line[1]); // Vertex 2
//
//        boolean pathExists = isPathExists(graph, v1, v2);
//        System.out.println(pathExists);
//    }
//

//    from lecture

    public static void dftraversal(int adjMatrix[][], int currentVertex, boolean visited[]){
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        for(int i = 0; i < adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
// i is neighbor of currentVertex
                dftraversal(adjMatrix, i, visited);
            }
        }
    }


    public static void dftraversal(int adjMatrix[][]){
        boolean visited[]= new boolean[adjMatrix. length];
        for(int i=0;i<adjMatrix.length;i++) {
            if( !visited[i]) {
                dftraversal(adjMatrix,i,visited);
                System.out.println();
            }
        }
    }




    public static void bfTraversal(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix. length];
        visited[0] = true;
        pendingVertices.add(0);

        while(! pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex +" ");
            for(int i = 0; i < adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
// i is unvisited neighbor of currentVertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMatrix[][] = new int[n][n];
        for(int i = 0; i <e; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
//dftraversal(adjMatrix);
        bfTraversal(adjMatrix);
// for(int i = 0; i<n; i++){
// for(int j = 0; j<n; j++){
// System.out.print(adjMatrix[i][j] +" ");
// }
// System.out.println();
// }
    }
}
