package org.machines.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<Node>();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public int[][] adjacencyMatrix() {
        int[][] matrix = new int[this.nodes.size()][this.nodes.size()];
        for(int i = 0; i < this.nodes.size(); i++) {
            Node currentNode = this.nodes.get(i);
            for(Node node : currentNode.getEdges()) {
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
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

