package org.machines.problems.maptransversal;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;
import org.machines.search.StateSpace;

import java.util.List;

public class MapStateSpace extends StateSpace {
    public MapStateSpace(State initalState, State goalState, SearchAlgorithm searchAlgorithm) {
        super(initalState, goalState, searchAlgorithm);
    }
    public List<MapState> getMapStates() {
        return this.getStates().stream().map(state -> (MapState) state).toList();
    }

}
