package DSA;

import java.util.*;

public class breadthFirst {
    static class Graph {
        private final int vertices;
        private final LinkedList<Integer>[] adjacent;


        Graph(int v) {
            vertices = v;
            adjacent = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adjacent[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adjacent[v].add(w);
        }

        void BFS(int s) {

            boolean[] visited = new boolean[vertices];
            LinkedList<Integer> queue
                    = new LinkedList<Integer>();


            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + " ");

                for (int n : adjacent[s]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 5);
        g.addEdge(5, 0);

        g.BFS(0);
    }
}
