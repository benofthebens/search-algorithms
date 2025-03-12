package org.machines.search.algorithm;

import org.machines.problems.maptransversal.MapState;
import org.machines.search.SearchAlgorithm;
import org.machines.search.State;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Astar extends SearchAlgorithm {
    private List<State> allStates;

    public Astar(List<State> allStates) {
        this.allStates = allStates;
    }

    private void initaliseCosts(State initialState) {
        for(State state : allStates) {
            state.setData(state.equals(initialState) ? 0 : Integer.MAX_VALUE);
            this.addToUnvisited(state);
        }
    }

    @Override
    public List<State> search(State initialState, State goalState) {
        initaliseCosts(initialState);
        while(!unvisited.isEmpty()) {
            State current = unvisited.stream()
                    .min(Comparator.comparing(State::getData))
                    .orElse(initialState);
            for(State state : current.expand()) {
                if(visited.contains(state)) continue;

                int cost = state.getData() + 1 + heuristic(current, goalState);

                if(cost < state.getData()) {
                    state.setData(cost);
                    path.put(state, current);
                }
            }
            visited.add(current);
            unvisited.remove(current);
        }
        backtrack(goalState);
        return result;
    }

    private void backtrack(State goalState) {
        State current = goalState;
        while(current.getData() != 0) {
            result.add(current);
            current = path.get(current);
        }
        result.add(current);
        Collections.reverse(result);
    }

    private int heuristic(State state, State goalState) {
        return Math.abs(((state.getX() - goalState.getX()) + (state.getY() - goalState.getY())));
    }
}
