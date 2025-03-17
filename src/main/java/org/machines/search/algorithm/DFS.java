package org.machines.search.algorithm;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.ArrayList;
import java.util.List;

public class DFS extends SearchAlgorithm {
    /**
     * @param initialState
     * @param goalState
     * @return path to the goalState
     */
    @Override
    public List<State> search(State initialState, State goalState) {

        visited.add(initialState);
        result.add(initialState);

        if(initialState.isGoalState(goalState))
            return new ArrayList<>(result);

        for(State state : initialState.expand()) {
            if(!visited.contains(state)) {
                List<State> path = this.search(state, goalState);
                if(!path.isEmpty()) return path;
            }
        }

        result.remove(result.size()-1);
        return new ArrayList<>();
    }
}
