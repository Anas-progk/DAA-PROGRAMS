import java.util.*;
class MCSTKruskal 
{
    static class Edge implements Comparable<Edge> 
	{
        int src, dest, weight;

        Edge(int src, int dest, int weight) 
		{
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @override
		public int compareTo(Edge e) 
		{
            return this.weight - e.weight;
        }
    }

    static int[] parent;
    static int[] rank;

    static int find(int x) 
	{
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }




    static void union(int x, int y)
	{
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] < rank[rootY])
		{
            parent[rootX] = rootY;
			rank[rootX]++;
		}

        else if (rank[rootX] > rank[rootY])
		{
            parent[rootY] = rootX;
			rank[rootY]++;
		}

        else 
		{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    static int kruskal(Edge[] edges, int V) 
	{
        Arrays.sort(edges);

        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int cost = 0;
        int count = 0;

        for (Edge e : edges) 
		{	
            int x = find(e.src);
            int y = find(e.dest);

            // Different sets -> adding edge won't create cycle
            if (x != y) 
			{
                cost += e.weight;
                count++;

                union(x, y);

                // MST contains V-1 edges
                if (count == V - 1)
				{
                    return cost;
				}
            }
        }

        // MST not possible
        return -1;
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) 
		{
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            edges[i] = new Edge(src, dest, weight);
        }
        System.out.println(kruskal(edges, V));
    }
}

/*
input =6 15
0 1 8
0 2 9
0 3 10
0 4 13
0 5 9
1 2 7
1 4 8
1 3 8
5 1 8
2 3 7
2 4 7
5 2 3
3 4 5
3 5 3
4 5 3
output =24
*/

