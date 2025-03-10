package org.machines.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node {
    protected final List<Node> edges;

    public Node() {
        this.edges = new ArrayList<Node>();
    }

    protected Node(Node node) {
        this.edges = node.edges.stream()
                .map(Node::copy)
                .collect(Collectors.toList());
    }

    public Node copy() {
        return new Node(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(Objects.isNull(obj)) return false;
        if(obj.getClass() != this.getClass()) return false;
        Node node = (Node) obj;
        return this.edges.equals(node.edges);
    }

    public List<Node> getEdges() {
        return this.edges;
    }

    public void addEdge(Node connection) {
        this.edges.add(connection);
    }
}
