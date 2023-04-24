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
     * Adds a
     *
     * @param g Adj_List_Graph
     * @return A modified Adj_List_Graph where
     */
    static Adj_List_Graph squaredGraph(Adj_List_Graph a) {
        Adj_List_Graph res = new Adj_List_Graph(a.n);

        for (int i = 0; i < a.n; i++) {
            for (int neighbor : a.adj.get(i)) {
                res.addEdge(i, neighbor);
                for (int neighborsNeighbor : a.adj.get(neighbor))
                    res.addEdge(i, neighborsNeighbor);
            }
        }

        return res;
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
        input_71.printGraph();
        input_72.printGraph();
        System.out.println("\nSquared graph");
        squaredGraph(input_71).printGraph();
        squaredGraph(input_72).printGraph();
    }
}
