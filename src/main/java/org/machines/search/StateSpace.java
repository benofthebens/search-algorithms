package org.machines.search;

import org.machines.graph.Graph;

import java.util.List;
import java.util.stream.Collectors;

public abstract class StateSpace extends Graph<Integer> {

    protected State initalState;
    protected State goalState;
    protected SearchAlgorithm searchAlgorithm;

    /**
     * @param initalState
     * @param goalState
     * @param searchAlgorithm
     */
    public StateSpace(State initalState, State goalState, SearchAlgorithm searchAlgorithm) {
        super();
        this.initalState = initalState;
        this.goalState = goalState;
        this.searchAlgorithm = searchAlgorithm;
    }

    /**
     * @return list of states
     */
    public List<State> getStates() {
        return this.getNodes().stream().map(n -> (State) n).toList();
    }

    /**
     * @return the path of the search
     */
    public List<State> search() {
        return searchAlgorithm.search(initalState, goalState);
    };
}
