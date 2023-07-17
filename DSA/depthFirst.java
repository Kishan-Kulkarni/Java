package DSA;

import java.util.*;

public class depthFirst {
    static class Graph {
        private final int Vertex;
        private final LinkedList[] adjacent;


        Graph(int v) {
            Vertex = v;
            adjacent = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adjacent[i] = new LinkedList<>();
        }


        void addEdge(int v, int w) {
            adjacent[v].add(w); // Add w to v's list.
        }


        void helper(int v, boolean[] visited) {

            visited[v] = true;
            System.out.print(v + " ");


            for (Object n : adjacent[v]) {
                if (!visited[(int) n])
                    helper((Integer) n, visited);
            }
        }


        void DFS(int v) {

            boolean[] visited = new boolean[Vertex];


            helper(v, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,3);
        g.addEdge(4,1);
        g.addEdge(4,3);

        g.DFS(0);
    }
}
