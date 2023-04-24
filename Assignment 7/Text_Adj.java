package assignment7;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Text_Adj {
    static class Inputs {
        private int vertex_count;
        private List<Integer> adjacency_matrix;

        Inputs(int size, List<Integer> inputVal) {
            this.vertex_count = size;
            this.adjacency_matrix = inputVal;
        }

        Inputs(Inputs o) {
            this(o.getVertex_count(), o.getAdjacency_matrix());
        }

        public int getVertex_count() {
            return vertex_count;
        }

        public void setVertex_count(int size) {
            this.vertex_count = size;
        }

        public List<Integer> getAdjacency_matrix() {
            return adjacency_matrix;
        }

        public void setAdjacency_matrix(List<Integer> inputVal) {
            this.adjacency_matrix = inputVal;
        }
    }

    static Inputs readInput(String file) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(file));
        int vertex_count = Integer.parseInt(inputFile.readLine().trim());
        List<Integer> adjacency_matrix = Stream.of(inputFile.readLine().split("\\s+")).map(Integer::parseInt).toList();
        inputFile.close();
        return new Inputs(vertex_count, adjacency_matrix);
    }

    // Segment related to the solution //

    /**
     * By exploiting the behaviour of BFS traversal, we modify it by adding a
     * conditional that satisfies the definition of a squared graph
     *
     * @param g Adj_List_Graph
     * @return A modified Adj_List_Graph where
     */
    static Adj_List_Graph squaredGraph(Adj_List_Graph g) {
        Adj_List_Graph result = new Adj_List_Graph(g.n);

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

    /**
     * Generates a directed graph by reading an adjacency list
     *
     * @param seq      An arrayList that represents the adjacency list
     * @param vertices The number of vertices a graph has
     */
    static Adj_List_Graph generate_graph(List<Integer> seq, int vertices) {
        Adj_List_Graph a = new Adj_List_Graph(vertices);
        for (int x = 0; x < seq.size(); x++)
            if (seq.get(x) == 1)
                a.addEdge(x / vertices, x % vertices);
        return a;
    }

    public static void main(String[] args) throws IOException {
        Inputs a = readInput("./input-7-1.txt");
        Inputs b = readInput("./input-7-2.txt");
        Adj_List_Graph input_71 = generate_graph(a.adjacency_matrix, a.vertex_count);
        Adj_List_Graph input_72 = generate_graph(b.adjacency_matrix, b.vertex_count);
        input_72.printGraph();
        System.out.println("\nSquared graph");
        // squaredGraph(input_71).printGraph();
        squaredGraph(input_72).printGraph();
    }
}
