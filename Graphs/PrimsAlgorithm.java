package Graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

    public static int findMinVertex(boolean[] visited, int[] weights) {
        int minVertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && (minVertex == -1 || weights[i] < weights[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void primsAlgorithm(int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] weights = new int[n];

//        source is vertex[0]
        parent[0] = -1;
        weights[0] = 0;
        for (int i = 1; i < n; i++) {
            weights[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int minVertex = findMinVertex(visited, weights);
            visited[minVertex] = true;
//            explore neighbours of this minVertex
            for (int j = 0; j < n; j++) {
                if(adjMatrix[minVertex][j] != 0 && !visited[j]){
                    if(weights[j] > adjMatrix[minVertex][j]){
//                         update values
                        weights[j] = adjMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }

            }
        }

        // print mst
        for (int i = 1; i < n; i++) {
            if(i < parent[i]){
                System.out.println(i + " " + parent[i] + " " + weights[i]);
            } else {
                System.out.println(parent[i] + " " + i + " " + weights[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adjMatrix = new int[V][V];
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }

        primsAlgorithm(adjMatrix);
    }
}
