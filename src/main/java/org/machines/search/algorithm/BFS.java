package org.machines.search.algorithm;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.*;

public class BFS extends SearchAlgorithm {
    @Override
    public List<State> search(State initialState, State goalState) {
        Queue<State> queue = new LinkedList<>();

        queue.add(initialState);
        visited.add(String.valueOf(initialState));

        while(!queue.isEmpty()) {
            State current = queue.poll();
            result.add(current);

            if(current.isGoalState(goalState, current)) {
                return result;
            }

            for(State state : current.expand()){
                if(!visited.contains(String.valueOf(state))){
                    visited.add(String.valueOf(state));
                    queue.add(state);
                }
            }
        }
        result.clear();
        return result;
    }
}
