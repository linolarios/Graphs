package com.lino.graphs.bfs;

import java.util.*;

public class BreadthFirstSearchExampleNeighbourList {

    private Queue<Node> queue;

    public BreadthFirstSearchExampleNeighbourList() {
        queue = new LinkedList<>();
    }

    static class Node {
        int data;
        private boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new LinkedList<>();

        }

        public void addNeighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    public void bfs(Node neighbour) {
        queue.add(neighbour);
        neighbour.visited = true;
        StringBuilder space = new StringBuilder();
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            space.append("  ");
            System.out.println(space + "" + element.data);
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node node = neighbours.get(i);
                if (node != null && !node.visited) {
                    node.visited = true;
                    queue.add(node);
                }
            }
        }
        System.out.println();
    }

    public static void main(String arg[]) {

        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        List<Node> nodes = Arrays.asList(node10, node20, node30, node60, node50, node70 );

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);

        node10.addNeighbours(node30);

        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);

        node30.addNeighbours(node60);

        node60.addNeighbours(node70);

        node50.addNeighbours(node70);
        System.out.println("The BFS traversal of the graph is ");

        BreadthFirstSearchExampleNeighbourList bfsExample = new BreadthFirstSearchExampleNeighbourList();
        bfsExample.bfs(node20);
        setAllinFalse(nodes);
        bfsExample.bfs(node70);
        setAllinFalse(nodes);
        bfsExample.bfs(node40);

    }

    private static void setAllinFalse(List<Node> nodes) {

        nodes.forEach(
                        node -> node.setVisited(false)
                );
    }
}
