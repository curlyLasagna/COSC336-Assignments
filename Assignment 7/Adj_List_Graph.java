package assignment7;

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
    // this line should be un-commented, if graph is undirected
    // adj.get(v).add(u);
  }

  // @param s starting node
  ArrayList BFS(int s) {
    boolean visited[] = new boolean[this.n];

    // Stores traversed nodes
    ArrayList<Integer> path = new ArrayList<Integer>();
    LinkedList<Integer> queue = new LinkedList<Integer>();

    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {

      // Dequeue a vertex from queue and add it to path
      s = queue.poll();
      path.add(s);

      for (int n : this.adj.get(s)) {
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }

    return path;
  }

  // A utility function to print the adjacency list
  // representation of graph
  public void printGraph() {
    for (int i = 0; i < n; i++) {
      System.out.println("\nAdjacency list of vertex " + i);
      System.out.print("head");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(" -> " + adj.get(i).get(j));
      }
      System.out.println();
    }
  }
}
