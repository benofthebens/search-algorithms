package org.machines.search.algorithm;

import org.machines.graph.Node;
import org.machines.search.SearchAlgorithm;
import org.machines.search.State;
import org.machines.search.StateSpace;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Dijkstra extends SearchAlgorithm {

    private List<State> allStates;

    public Dijkstra(List<State> allStates) {
        this.allStates = allStates;
    }

    private List<State> backtrack(State goalState) {
        State current = goalState;
        while(current.getData() != 0) {
            result.add(current);
            current = path.get(current);
        }
        result.add(current);
        return result;
    }

    private void initaliseCosts(State initialState) {
        for(State state : allStates) {
            if (state.equals(initialState)) {
                state.setData(0);
            } else {
                state.setData(Integer.MAX_VALUE);
            }
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
                int edgeCost = 1;
                int cost = current.getData() + edgeCost;

                if(cost < state.getData()) {
                    state.setData(cost);
                    path.put(state, current);
                }
            }
            visited.add(current);
            unvisited.remove(current);
        }

        return backtrack(goalState);
    }
}
