package org.machines.search.algorithm;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.List;

public class DFS extends SearchAlgorithm {
    @Override
    public List<State> search(State initialState, State goalState) {

        result.add(initialState);
        visited.add(String.valueOf(initialState));

        if(initialState.isGoalState(goalState, initialState)) {
            return result;
        }
        for(State state : initialState.expand()) {
            if(!visited.contains(String.valueOf(state))) {
                this.search(state, goalState);
            }
        }
        return result;
    }
}
