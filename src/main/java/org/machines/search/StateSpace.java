package org.machines.search;

import org.machines.graph.Graph;

import java.util.List;
import java.util.stream.Collectors;

public abstract class StateSpace extends Graph<Integer> {

    protected State initalState;
    protected State goalState;
    protected SearchAlgorithm searchAlgorithm;

    public StateSpace(State initalState, State goalState, SearchAlgorithm searchAlgorithm) {
        super();
        this.initalState = initalState;
        this.goalState = goalState;
        this.searchAlgorithm = searchAlgorithm;
    }
    public List<State> getStates() {
        return this.getNodes().stream().map(n -> (State) n).toList();
    }

    public List<State> search() {
        return searchAlgorithm.search(initalState, goalState);
    };
}
