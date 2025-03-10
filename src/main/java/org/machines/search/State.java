package org.machines.search;

import org.machines.graph.Node;

import java.util.List;

public abstract class State extends Node {
    public State() {
        super();
    }
    public abstract State copy();
    public abstract List<State> expand();
    public abstract boolean isGoalState(State goalState, State currentState);
}
