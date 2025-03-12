package org.machines.problems.maptransversal;

import org.machines.graph.Node;
import org.machines.search.State;

import java.util.List;

public class MapState extends State {
    private String name;

    public MapState(String name) {
        this(name,0, 0);
    }
    public MapState(String name, int x, int y) {
        super(x, y);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    @Override
    public State copy() {
        return null;
    }

    @Override
    public List<State> expand() {
        return this.edges.stream().map(node -> (State) node).toList();
    }

    @Override
    public boolean isGoalState(State goalState) {
        return goalState.equals(this);
    }
}
