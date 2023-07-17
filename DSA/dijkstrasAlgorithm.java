package DSA;

import java.util.Iterator;
import java.util.PriorityQueue;

public class dijkstrasAlgorithm {

    public static void main(String[] args) {
        Graph g = new Graph(6);

        System.out.println("Graph:");

        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 4, 2);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 5, 2);


        g.printGraph();


        System.out.println("Dijkstra Shortest Path:");
        Dijkstra(g, 0);
    }

    public static void Dijkstra(Graph g, int startVertex) {

        float[] distances = new float[g.getvCount()];

        int[] parents = new int[g.getvCount()];
        for (int i = 0; i < g.getvCount(); i++) {
            parents[i] = -1;
        }


        PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
        for (int i = 0; i < g.getvCount(); i++) {
            if (i != startVertex) {
                Q.add(new Vertex(i));
            }
        }


        Vertex node = new Vertex(startVertex);
        node.setDistance(0);
        Q.add(node);


        while (!Q.isEmpty()) {

            Vertex u = Q.remove();
            distances[u.getId()] = u.getDistance();


            Iterator<Edge> it = g.neighbours(u.getId()).iterator();
            while (it.hasNext()) {
                Edge e = it.next();
                Iterator<Vertex> it2 = Q.iterator();
                while (it2.hasNext()) {
                    Vertex v = it2.next();

                    if (e.getEndPoint() != v.getId()) {
                        continue;
                    }

                    if (v.getDistance() > u.getDistance() + e.getWeight()) {
                        v.setDistance(u.getDistance() + e.getWeight());
                        v.setParent(u);
                        parents[v.getId()] = v.getParent().getId();
                    }
                }
            }

        }


        System.out.println("Vertex\tDistance\tParent Vertex");
//        for (int i = 0; i < g.getvCount(); i++) {
//            System.out.println(i + "\t" + distances[i] + "\t\t" + parents[i]);
//        }
        System.out.println(5 + "\t" + distances[5] + "\t\t" + parents[5]);

    }


    public static class  Vertex implements Comparable{
        private int id;
        private float distance;
        private Vertex parent;

        public Vertex(){
            distance = Float.MAX_VALUE; // "infinity"
            parent = null;
        }

        public Vertex(int id){
            this.id = id;
            distance = Float.MAX_VALUE; // "infinity"
            parent = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getDistance() {
            return distance;
        }

        public void setDistance(float distance) {
            this.distance = distance;
        }

        public Vertex getParent() {
            return parent;
        }

        public void setParent(Vertex parent){
            this.parent = parent;
        }

        public int compareTo(Object o) {
            Vertex other = (Vertex) o;
            return Double.compare(this.distance, other.distance);
        }
    }

    public static  class Graph {
        private int vCount;
        private PriorityQueue[] adj;

        public int getvCount() {
            return vCount;
        }

        public Graph(int vCount) {
            this.vCount = vCount;

            adj = new PriorityQueue[vCount];
            for (int i = 0; i < vCount; i++) {
                adj[i] = new PriorityQueue<Edge>();
            }
        }

        public  void addEdge(int i, int j, float weight) {
            adj[i].add(new Edge(i, j, weight));
        }

        public void addEdge(Edge e) {
            adj[e.getStartPoint()].add(e);
        }

        public void removeEdge(int i, int j) {
            Iterator<Edge> it = adj[i].iterator();
            Edge other = new Edge(i, j, 0);
            while (it.hasNext()) {
                if (it.next().equals(other)) {
                    it.remove();
                    return;
                }
            }
        }

        public boolean hasEdge(Edge e) {
            return adj[e.getStartPoint()].contains(e);
        }

        public PriorityQueue<Edge> neighbours(int vertex) {
            return adj[vertex];
        }

        public void printGraph() {
            for (int i = 0; i < vCount; i++) {
                PriorityQueue<Edge> edges = neighbours(i);
                Iterator<Edge> it = edges.iterator();
                System.out.print(i + ": ");
                for (int j = 0; j < edges.size(); j++) {
                    System.out.print(it.next() + " ");
                }
                System.out.println();
            }
        }
    }

    public static class Edge implements Comparable {
        private int startPoint;
        private int endPoint;
        private float weight;

        public Edge(int startPoint, int endPoint, float weight) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.weight = weight;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public int getEndPoint() {
            return endPoint;
        }

        public float getWeight() {
            return weight;
        }

        public boolean equals(Edge other) {
            if (this.startPoint == other.startPoint) {
                if (this.endPoint == other.endPoint) {
                    return true;
                }
            }
            return false;
        }

        public int compareTo(Object o) {
            Edge other = (Edge) o;
            return Double.compare(this.weight, other.weight);
        }

        public String toString() {
            return startPoint + "-" + endPoint + " (" + weight + ")";
        }
    }
}
