package org.machines.search;

import org.machines.graph.Graph;

import java.util.List;

public abstract class StateSpace extends Graph {

    protected State initalState;
    protected State goalState;
    protected SearchAlgorithm searchAlgorithm;

    public StateSpace(State initalState, State goalState, SearchAlgorithm searchAlgorithm) {
        super();
        this.initalState = initalState;
        this.goalState = goalState;
        this.searchAlgorithm = searchAlgorithm;
    }

    public List<State> search() {
        return searchAlgorithm.search(initalState, goalState);
    };
}
