package org.machines.problems.jug;

import org.machines.search.SearchAlgorithm;
import org.machines.search.StateSpace;

public class JugStateSpace extends StateSpace {
    public JugStateSpace(JugState initialState, JugState goalState, SearchAlgorithm searchAlgorithm) {
        super(initialState, goalState, searchAlgorithm);
    }
}
