package Graphs;

public class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int w){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = w;
    }


    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
