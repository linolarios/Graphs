package com.lino.graphs.bfs2;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int edges;   // No. of vertices
    private List<Integer> neighbours[]; //Adjacency Lists

    // Constructor
    Graph(int edge) {
        edges = edge;
        neighbours = new LinkedList[edges];
        for (int i = 0; i < edges; ++i)
            neighbours[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int edge, int with) {
        neighbours[edge].add(with);
    }

    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[edges];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int n : neighbours[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);

        g.addEdge(1, 2);

        g.addEdge(2, 0);

        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
        System.out.println();
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 0)");

        g.BFS(0);
    }
}
