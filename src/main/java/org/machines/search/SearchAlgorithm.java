package org.machines.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class SearchAlgorithm {

    protected HashSet<State> visited;
    protected HashSet<State> unvisited;
    protected HashMap<State, State> path = new HashMap<State, State>();
    protected List<State> result;

    public SearchAlgorithm() {
        this.visited = new HashSet<>();
        this.unvisited = new HashSet<>();
        this.result = new ArrayList<>();
    }

    public abstract List<State> search(State initialState, State goalState);
    public void addToUnvisited(State state) {
        this.unvisited.add(state);
    }
}
