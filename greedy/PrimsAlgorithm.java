import java.util.*;
 
/**
 * Prim's Minimum Spanning Tree using an adjacency list and a min-heap.
 * Time: O(E log V)   Space: O(V + E)
 */
public class PrimsAlgorithm {
 
    // Edge as stored in the adjacency list: (destination, weight)
    static class Edge {
        final int to;
        final int weight;
 
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
 
    // Entry in the priority queue: reach 'vertex' via 'from' at cost 'weight'
    static class Node implements Comparable<Node> {
        final int vertex;
        final int from;
        final int weight;
 
        Node(int vertex, int from, int weight) {
            this.vertex = vertex;
            this.from = from;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
 
    // Result of the algorithm
    static class MSTResult {
        final int totalWeight;
        final List<int[]> edges; // each: {u, v, weight}
        final boolean connected;
 
        MSTResult(int totalWeight, List<int[]> edges, boolean connected) {
            this.totalWeight = totalWeight;
            this.edges = edges;
            this.connected = connected;
        }
    }
 
    // Undirected weighted graph
    static class Graph {
        final int V;
        final List<List<Edge>> adj;
 
        Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
 
        void addEdge(int u, int v, int w) {
            if (u < 0 || u >= V || v < 0 || v >= V) {
                throw new IllegalArgumentException("Vertex out of range: " + u + ", " + v);
            }
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w)); // undirected
        }
 
        /** Runs Prim's algorithm starting from vertex 'start'. */
        MSTResult prim(int start) {
            boolean[] inMST = new boolean[V];
            List<int[]> mstEdges = new ArrayList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int total = 0;
            int visited = 0;
 
            pq.offer(new Node(start, -1, 0));
 
            while (!pq.isEmpty() && visited < V) {
                Node cur = pq.poll();
 
                // Skip stale entries (vertex already added via a cheaper edge)
                if (inMST[cur.vertex]) continue;
 
                inMST[cur.vertex] = true;
                visited++;
                total += cur.weight;
 
                if (cur.from != -1) {
                    mstEdges.add(new int[]{cur.from, cur.vertex, cur.weight});
                }
 
                for (Edge e : adj.get(cur.vertex)) {
                    if (!inMST[e.to]) {
                        pq.offer(new Node(e.to, cur.vertex, e.weight));
                    }
                }
            }
 
            return new MSTResult(total, mstEdges, visited == V);
        }
    }
 
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);
 
        MSTResult result = g.prim(0);
 
        if (!result.connected) {
            System.out.println("Graph is not connected; no spanning tree exists.");
            return;
        }
 
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int[] e : result.edges) {
            System.out.println(e[0] + " - " + e[1] + "  (weight " + e[2] + ")");
        }
        System.out.println("Total weight: " + result.totalWeight);
    }
}
