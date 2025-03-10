package org.machines.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class SearchAlgorithm {

    protected HashSet<String> visited;
    protected List<State> result;

    public SearchAlgorithm() {
        this.visited = new HashSet<>();
        this.result = new ArrayList<>();
    }

    public abstract List<State> search(State initialState, State goalState);
}
