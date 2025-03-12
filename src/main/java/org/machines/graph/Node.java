package org.machines.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node<T> {
    protected final List<Node<T>> edges;
    protected T data;

    public Node(T data) {
        this.edges = new ArrayList<Node<T>>();
        this.data = data;
    }

    protected Node(Node<T> node) {
        this.edges = node.edges.stream()
                .map(Node::copy)
                .collect(Collectors.toList());
        this.data = node.data;
    }

    public Node<T> copy() {
        return new Node<>(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(Objects.isNull(obj)) return false;
        if(obj.getClass() != this.getClass()) return false;
        Node<?> node = (Node<?>) obj;
        return this.edges.equals(node.edges);
    }

    public List<Node<T>> getEdges() {
        return this.edges;
    }
    public T getData() {
        return this.data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public void addEdge(Node<T> connection) {
        this.edges.add(connection);
    }
}
