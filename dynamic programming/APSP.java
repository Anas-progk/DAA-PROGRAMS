/*Mr. Abdul planned to visit all the tourist paths in a city.
There are P number of tourist places connected using some routes 
in a city, the routes are one-directional.

Your task is to help Mr. Abdul, 
to find the shortest routes between every pair of tourist-places in the city.

Input Format:
------------------
Line-1: An integer P, number of places.
Next P lines: P space separated integers, the routes[][].

Output Format:
--------------------
Print the shortest distance routes[][].


Sample Input-1:
--------------------
4
0 5 99 10
99 0 3 99
99 99 0 1
99 99 99 0

Sample Output-1:
----------------------
0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0


Sample Input-2:
--------------------
5
0 4 5 6 99
99 0 5 99 10
1 99 0 3 99
2 99 99 0 1
1 99 99 99 0

Sample Output-2:
----------------------
0 4 5 6 7
6 0 5 8 9
1 5 0 3 4
2 6 7 0 1
1 5 6 7 0

*/

import java.util.*;
class APSP {
    static int V;
    static final int INF = 1_000_000_000;
    void apsp(int graph[][]) {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (graph[i][k] != INF &&
                        graph[k][j] != INF) {
                        graph[i][j] = Math.min(
                            graph[i][j],
                            graph[i][k] + graph[k][j]
                        );
                    }
                }
            }
        }
        printSolution(graph);
    }
    void printSolution(int dist[][]) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF");
                } else {
                    System.out.print(dist[i][j]);
                }
                if (j < V - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int value = sc.nextInt();
                if (value == 99) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = value;
                }
            }
        }
        new APSP().apsp(graph);
        sc.close();
    }
}