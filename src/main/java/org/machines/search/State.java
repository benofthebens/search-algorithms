package org.machines.search;

import org.machines.graph.Node;

import java.util.List;

public abstract class State extends Node<Integer> {

    private final int x;
    private final int y;

    public State() {
        this(0,0);
    }

    public State(int x, int y) {
        super(0);
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public abstract State copy();
    public abstract List<State> expand();
    public abstract boolean isGoalState(State goalState);
}
