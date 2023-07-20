package Graphs;

import java.util.*;

public class basicGraphs {
    static class Edge{
        int from ,to,cost ,id;

        public Edge(int from, int to, int cost, int id) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    ", id=" + id +
                    '}';
        }
    }

    public static int dfs(int at, boolean[] visited, Map<Integer, List<Edge>> graph){
        if(visited[at]){
            return 0;
        }

        visited[at]=true;
        int count=1;
        List<Edge> next=graph.get(at);

        if(next!=null){
            for(Edge e : next){
                count+=dfs(e.to,visited,graph);
            }
        }

        return count;
    }
    public static void connectedNodes(boolean[] visited, Map< Integer, List<Edge>> graph, int id){
        int k=id;
        boolean[] temp=visited.clone();
        for(int i:graph.keySet()){
            if(!visited[i]){
                helperCN(i, visited, graph, k);
                k++;
            }
        }
    }

    private static void helperCN(int at, boolean[] visited, Map<Integer, List<Edge>> graph, int id) {
        if(visited[at]){
            return;
        }

        visited[at]=true;
        List<Edge> next=graph.get(at);

        if(next != null){
            for(Edge e:next){
                e.id = id;
                helperCN(e.to, visited, graph, id);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph, 0,1,4);
        addDirectedEdge(graph, 0,2,5);
        addDirectedEdge(graph, 1,3,2);
        addDirectedEdge(graph, 3,1,7);
        addDirectedEdge(graph, 1,2,-2);
        addDirectedEdge(graph, 0,4,0);
        addDirectedEdge(graph, 1,4,10);
        addDirectedEdge(graph, 4,4,-6);
        addDirectedEdge(graph, 3,0,0);
        addDirectedEdge(graph, 5,5,1);

        System.out.println(dfs(3, new boolean[6], graph));
        for(int i: graph.keySet()){
            System.out.println(graph.get(i));
        }
        connectedNodes(new boolean[6], graph, 0);
        for(int i: graph.keySet()){
            System.out.println(graph.get(i));
        }
        Queue<Integer> q=new LinkedList<>();
    }
    private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
        List<Edge> list = graph.get(from);
        if (list == null) {
            list = new ArrayList<Edge>();
            graph.put(from, list);
        }
        list.add(new Edge(from, to, cost, (int)(Math.random()*100)));
    }
}
