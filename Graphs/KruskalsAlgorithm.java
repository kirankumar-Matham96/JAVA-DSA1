package Graphs;

import java.util.*;

// based on the input sequence, out put is changing***
public class KruskalsAlgorithm {

    public static int findParent(int v, int[] parent) {
        if(v == parent[v]){
            return v;
        }

        return findParent(parent[v], parent);
    }
    public static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
        Arrays.sort(edges);

        Edge[] mst = new Edge[n-1];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0, i = 0;

        while(count != n-1){
            Edge currentEdge = edges[i++];
            int v1Parent = findParent(currentEdge.v1, parent);
            int v2Parent = findParent(currentEdge.v2, parent);

            if(v1Parent != v2Parent){
//                including current edge
                mst[count] = currentEdge;
                count++;

//                Update the v1Parent to v2Parent or vise versa
                parent[v1Parent] = v2Parent;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        /**
         * 1) take input and store graph
         *      i. It is better to use Edge List rather than using Adjacency Matrix
         *     ii. Create a class for edge and for each input store them in edge array which is of size n
         *    iii. We also need an output array to store the final array
         *     iv. The edges in the final graph will be n-1
         *      v. We also need to maintain a parent array(integer array of size n)
         * 2) Sort edges in ascending order of weights
         *      i. can use Arrays.sort() in-build method for arrays
         * 7) keep a count for every edge and uppermost limit should be n-1
         *
          */

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(v1,v2, w);
        }
        // mst - minimal spanning tree
        Edge[] mst = kruskalAlgorithm(edges, V);

        for (int i = 0; i < mst.length; i++) {
            if(mst[i].v1 < mst[i].v2){
                System.out.println(mst[i].v1+" "+mst[i].v2+" "+mst[i].weight);
            }else{
                System.out.println(mst[i].v2+" "+mst[i].v1+" "+mst[i].weight);
            }
        }

    }
}
