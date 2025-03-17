package org.machines.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private final List<Node<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<Node<T>>();
    }

    public void addNode(Node<T> node) {
        this.nodes.add(node);
    }

    public List<Node<T>> getNodes() {
        return this.nodes;
    }
    public static void createFromAdjacencyMatrix(int[][] adjacencyMatrix) {
        if(adjacencyMatrix.length != adjacencyMatrix[0].length) return;

        for(int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println((char) (65 + i));

        }

    }

    public int[][] adjacencyMatrix() {
        int[][] matrix = new int[this.nodes.size()][this.nodes.size()];
        for(int i = 0; i < this.nodes.size(); i++) {
            Node<T> currentNode = this.nodes.get(i);
            for(Node<T> node : currentNode.getEdges()) {
                int j = this.nodes.indexOf(node);
                if (j != -1) matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        int[][] matrix = adjacencyMatrix();
        StringBuilder sb = new StringBuilder();
        int index = 65;
        for(int i = 0; i < this.nodes.size(); i++) {
            if (i == 0) sb.append("  ");
            else sb.append(" ");

            sb.append((char) (65 + i));
        }
        sb.append("\n");
        for (int[] ints : matrix) {
            sb.append((char) index);
            sb.append(" ");
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
            index++;
        }
        return sb.toString();
    }
}

