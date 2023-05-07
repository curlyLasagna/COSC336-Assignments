package assignment8;

import java.util.*;

public class Solution {

    /**
     * getShortestPath
     *
     * This function is a modified BFS traversal that calculates
     * and populates two lists: dist[] and npath[]
     *
     * Prints the length of a shortest path from s to v: dist
     * Prints the number of shortest paths from s to v: npath
     *
     * @param g Graph to traverse
     * @param s Starting node. For this assignment, s = 1
     */

    static void getShortestPath(Adj_List_Graph g, int s) {
        int[] dist = new int[g.n];
        int[] npath = new int[g.n];

        // Set distance to infinity for undiscovered nodes
        for (int i = 0; i < g.n; i++) {
            dist[i] = Integer.MAX_VALUE;
            npath[i] = 0;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        dist[s] = 0;
        npath[s] = 1;
        queue.add(s);
        while (!queue.isEmpty()) {
            // Dequeue node
            int p = queue.poll();
            // Neighbors of node 'p'
            List<Integer> neighbors = g.adj.get(p);
            for (int v : neighbors) {
                if (dist[v] == Integer.MAX_VALUE) {

                    dist[v] = dist[p] + 1;
                    // Set the number of shortest path equal to the 
                    npath[v] = npath[p];
                    queue.add(v);
                }

                //
                else if (dist[v] == dist[p] + 1)
                    npath[v] += npath[p];

            }
        }

        // Print out the arrays
        for (int index = 1; index < g.n; index++)
            System.out.printf("dist[%d] = %d \t npath[%d] = %d%n",
                    index, dist[index], index, npath[index]);

    }

    public static void main(String[] args) {
        Adj_List_Graph g1 = new Adj_List_Graph(7);
        Adj_List_Graph g2 = new Adj_List_Graph(9);

        // Connect the edges
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(2, 5);
        g1.addEdge(3, 5);
        g1.addEdge(4, 6);
        g1.addEdge(5, 6);
        g1.addEdge(5, 7);
        g1.addEdge(6, 7);

        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 5);
        g2.addEdge(1, 6);
        g2.addEdge(7, 2);
        g2.addEdge(7, 3);
        g2.addEdge(7, 4);
        g2.addEdge(7, 5);
        g2.addEdge(7, 6);
        g2.addEdge(7, 8);
        g2.addEdge(7, 9);

        System.out.println("G1 results:\n");
        getShortestPath(g1, 1);
        System.out.println("\nG2 results:\n");
        getShortestPath(g2, 1);
    }
}
