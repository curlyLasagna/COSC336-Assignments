import java.io.*;
import java.util.*;

public class Adj_List_Graph {
  int n; // no of nodes
  ArrayList<ArrayList<Integer>> adj;

  // constructor taking as the single parameter the number of nodes
  Adj_List_Graph(int no_nodes) {
    n = no_nodes;
    adj = new ArrayList<ArrayList<Integer>>(n);
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<Integer>());
  }

  // A utility function to add an edge in an
  // undirected graph; for directed graph remove the second line
  public void addEdge(int u, int v) {
    adj.get(u).add(v);
    // adj.get(v).add(u);  //this line should be un-commented, if graph is
    // undirected
  }

  // A utility function to print the adjacency list
  // representation of graph

  public void printGraph() {
    for (int i = 0; i < n; i++) {
      System.out.println("\nAdjacency list of vertex" + i);
      System.out.print("head");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(" -> " + adj.get(i).get(j));
      }
      System.out.println();
    }
  }
}
