package org.machines.problems.sudoku;

import org.machines.search.algorithm.BFS;
import org.machines.search.algorithm.DFS;

public class SudokuMain {
    public static void main(String[] args) {
        int[][] puzzle = {
                {7, 3, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 1, 0, 0, 0, 0, 0},
                {0, 0, 8, 6, 0, 5, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 4, 9, 0, 0, 0, 5},
                {0, 9, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 6, 0, 2, 7, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 8, 0, 0, 0, 2, 3, 0, 0}
        };
        SudokuState initalState = new SudokuState(
                puzzle
        );
        SudokuState finalState = new SudokuState(new int[3][3]);
        BFS bfs = new BFS();
        DFS dfs = new DFS();
        SudokuStateSpace stateSpace = new SudokuStateSpace(
                initalState, finalState, bfs
        );
        SudokuStateSpace stateSpacedfs = new SudokuStateSpace(
                initalState, finalState,dfs
        );
        System.out.println(stateSpace.search().size());

    }
}
