package org.machines.problems.sudoku;

import org.machines.search.SearchAlgorithm;
import org.machines.search.State;
import org.machines.search.StateSpace;

public class SudokuStateSpace extends StateSpace {
    public SudokuStateSpace(State initalState, State goalState, SearchAlgorithm searchAlgorithm) {
        super(initalState, goalState, searchAlgorithm);
    }
}
