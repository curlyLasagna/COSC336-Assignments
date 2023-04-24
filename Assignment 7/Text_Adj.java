package assignment7;

import java.io.*;
import java.util.*;

// simple Driver program to test Adj_List_Graph class

public class Text_Adj {

    static readInput() {

    }

    static Adj_List_Graph squaredGraph(Adj_List_Graph g) {
        Adj_List_Graph result = new Adj_List_Graph(g.n);

        // We exploit the behaviour of BFS traversal and modify it by adding a
        // conditional that adds an edge to the existing
        // For each node in g, find all the nodes that can be reached with a path of
        // length 1 or 2
        for (int i = 0; i < g.n; i++) {
            boolean[] visited = new boolean[g.n];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                int node = q.remove();

                // Check if the current node is 1 or 2 edges away from the starting node
                if (node != i && (node - i == 1 || node - i == 2))
                    result.addEdge(i, node);

                // Add the unvisited neighbors of the current node to the queue
                for (int neighbor : g.adj.get(node)) {
                    if (!visited[neighbor]) {
                        q.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        return result;
    }

    static Adj_List_Graph generate_graph(List<Integer> seq, int vertices) {
        Adj_List_Graph a = new Adj_List_Graph(vertices);
        for (int x = 0; x < seq.size(); x++)
            if (x == 1)
                a.addEdge(x / vertices, x % vertices);
        return a;
    }

    public static void main(String[] args) {

        // int V = 5;
        int V = 3;
        Adj_List_Graph a = new Adj_List_Graph(V);
        a.addEdge(0, 1);
        a.addEdge(1, 2);
        // Creating a graph with 5 vertices
        // Adding edges one by one
        // a.addEdge(0, 1);
        // a.addEdge(0, 4);
        // a.addEdge(1, 2);
        // a.addEdge(1, 3);
        // a.addEdge(1, 4);
        // a.addEdge(2, 3);
        // a.addEdge(3, 4);

        a.printGraph();
        System.out.println("\nSquared graph");
        squaredGraph(a).printGraph();
    }
}
