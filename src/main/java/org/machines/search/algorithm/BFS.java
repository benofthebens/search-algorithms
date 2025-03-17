package org.machines.search.algorithm;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.*;

public class BFS extends SearchAlgorithm {
    /**
     * @param initialState
     * @param goalState
     * @return path
     */
    @Override
    public List<State> search(State initialState, State goalState) {
        Queue<State> queue = new LinkedList<>();
        Map<State, State> stateMap = new HashMap<>();

        queue.add(initialState);
        visited.add(initialState);

        stateMap.put(initialState, null);

        while(!queue.isEmpty()) {
            State current = queue.poll();

            if(current.isGoalState(goalState)) {
                return backtrack(stateMap, current);
            }

            for(State state : current.expand()){
                if(!visited.contains(state)){
                    visited.add(state);
                    queue.add(state);
                    stateMap.put(state, current);
                }
            }
        }
        result.clear();
        return result;
    }
    private List<State> backtrack(Map<State, State> stateMap, State goalState) {
        State current = goalState;

        while (Objects.nonNull(current)) {
            result.add(current);
            current = stateMap.get(current);  // Traverse back through parents
        }

        Collections.reverse(result);  // Reverse to get correct order (start → goal)
        return result;

    }
}
