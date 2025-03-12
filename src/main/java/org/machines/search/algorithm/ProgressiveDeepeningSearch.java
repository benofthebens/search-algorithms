package org.machines.search.algorithm;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.Collections;
import java.util.List;

public class ProgressiveDeepeningSearch extends SearchAlgorithm {
    private int maxDepth;

    @Override
    public List<State> search(State initialState, State goalState) {

        for(int i = 0; i < maxDepth; i++) {
            visited.clear();
            if(DLS(initialState, goalState, i)) {
                Collections.reverse(result);
                return result;
            }
        }
        result.clear();
        return result;
    }
    private boolean DLS(State src, State goalState, int depth) {
        if(src.isGoalState(goalState)) {
            result.add(src);
            return true;
        }
        visited.add(src);

        if(depth <= 0 )
            return false;

        for(State state : src.expand()) {
            if(visited.contains(state.toString())) {
                continue;
            }
            if(DLS(state, goalState, depth - 1)) {
                result.add(src);
                return true;
            }
        }
        return false;
    }
    public void setMaxDepth(int depth) {
        this.maxDepth = depth;
    }
}
