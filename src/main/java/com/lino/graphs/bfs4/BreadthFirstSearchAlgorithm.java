package com.lino.graphs.bfs4;

import java.util.*;

public class BreadthFirstSearchAlgorithm {

    static private Tree<Integer> root;
    static private Tree<Integer> rootFirstChild;
    static private Tree<Integer> depthMostChild;
    static private Tree<Integer> rootSecondChild;

    static private Node<Integer> start;
    static private Node<Integer> firstNeighbor;
    static private Node<Integer> firstNeighborNeighbor;
    static private Node<Integer> secondNeighbor;

    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Tree<T> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.printf("Visited node with value: {%s}%n", currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }

    public static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.printf("Visited node with value: {%s}%n", currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }

    public static void main(String args[]){
        root = Tree.of(10);
        rootFirstChild = root.addChild(2);
        depthMostChild = rootFirstChild.addChild(3);
        rootSecondChild = root.addChild(4);
        System.out.println("Result: " + BreadthFirstSearchAlgorithm.search(4, root).get().getValue());
        System.out.println("Result: " + BreadthFirstSearchAlgorithm.search(5, root).isPresent());

        start = new Node<>(10);
        firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        System.out.println("Result: " + BreadthFirstSearchAlgorithm.search(4, firstNeighborNeighbor).get().getValue());
        System.out.println("Result: " + BreadthFirstSearchAlgorithm.search(5, firstNeighborNeighbor).isPresent());

    }

}
