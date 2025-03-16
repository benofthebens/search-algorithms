package org.machines.search.algorithm;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.List;

public class DFS extends SearchAlgorithm {
    @Override
    public List<State> search(State initialState, State goalState) {

        visited.add(initialState);
        result.add(initialState);

        if(initialState.isGoalState(goalState)) {
            return result;
        }
        for(State state : initialState.expand()) {
            if(!visited.contains(state)) {
                List<State> path = this.search(state, goalState);
                if(!result.isEmpty()) return path;
            }
        }
        result.clear();
        return result;
    }
}
