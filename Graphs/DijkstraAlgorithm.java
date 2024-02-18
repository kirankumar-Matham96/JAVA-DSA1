package Graphs;

import java.util.Scanner;

public class DijkstraAlgorithm {

    public static int finMinVertex(boolean[] visited, int[] distance) {
        int minVertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static void dijkstraAlgorithm(int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        distance[0] = 0;
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n-1; i++) {
            int minVertex = finMinVertex(visited, distance);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++) {
                if(adjMatrix[minVertex][j] > 0 && !visited[j] && adjMatrix[minVertex][j] < Integer.MAX_VALUE){
//                    j is unvisited neighbour of minVertex
                    int newDistance = distance[minVertex] + adjMatrix[minVertex][j];
                    if(newDistance < distance[j]){
                        distance[j] = newDistance;
                    }
                }
            }
        }
//        printing
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + distance[i]);
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

        dijkstraAlgorithm(adjMatrix);
    }
}
