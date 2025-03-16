package org.machines.problems.sudoku;

import org.machines.search.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SudokuState extends State {
    private int[][] grid;

    public SudokuState(int[][] grid) {
        super();
        this.grid = grid;
    }

    @Override
    public State copy() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        sb.append("\n");
        for (int[] ints : grid) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<State> expand() {
        int selectedIndexX = 0;
        int selectedIndexY = 0;

        List<State> states = new ArrayList<>();

        HashSet<Integer> allowedNumbers = new HashSet<>();

        boolean found = false;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    selectedIndexX = j;
                    selectedIndexY = i;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        if(!found) return states;

        for(int i = 0; i < grid.length; i++) {
            int currentRow = grid[selectedIndexY][i];
            int currentCol = grid[i][selectedIndexX];

            if(currentRow != 0 && !allowedNumbers.contains(currentRow)) {
                allowedNumbers.add(currentRow);
            }

            if(currentCol != 0 && !allowedNumbers.contains(currentCol)) {
                allowedNumbers.add(currentCol);
            }
        }
        int boxNumber = (int) Math.sqrt(grid.length);

        int boxStartX = (selectedIndexX / boxNumber) * boxNumber;
        int boxStartY = (selectedIndexY / boxNumber) * boxNumber;

        for(int i = 0; i < boxNumber; i++) {
            for(int j = 0; j < boxNumber; j++) {
                int currentCell = grid[boxStartY + i][boxStartX + j];
                if(allowedNumbers.contains(currentCell))
                    continue;
                if(currentCell != 0)
                    allowedNumbers.add(currentCell);
            }
        }

        for(int i = 0; i < grid.length; i++) {
            if(!allowedNumbers.contains(i + 1)) {
                int[][] arrBuffer = new int[grid.length][];

                for (int k = 0; k < grid.length; k++) {
                    arrBuffer[k] = grid[k].clone();
                }

                arrBuffer[selectedIndexY][selectedIndexX] = i + 1;

                states.add(new SudokuState(arrBuffer));
            }
        }

        return states;
    }

    @Override
    public boolean isGoalState(State goalState) {

        for(int i = 0; i < grid.length; i++ ) {
            HashSet<Integer> rowBuffer = new HashSet<>();
            HashSet<Integer> columnBuffer = new HashSet<>();
            for(int j = 0; j < grid[i].length; j++ ) {
                // Check row
                if (rowBuffer.contains(grid[i][j]) || grid[i][j] == 0) return false;
                rowBuffer.add(grid[i][j]);

                // Check column
                if (columnBuffer.contains(grid[j][i])|| grid[j][i] == 0) return false;
                columnBuffer.add(grid[j][i]);
            }
        }

        int subGridSize = (int) Math.sqrt(grid.length);

    // Check subgrids
        for (int rowStart = 0; rowStart < grid.length; rowStart += subGridSize) {
            for (int colStart = 0; colStart < grid.length; colStart += subGridSize) {
                HashSet<Integer> subGridSet = new HashSet<>();

                for (int i = 0; i < subGridSize; i++) {
                    for (int j = 0; j < subGridSize; j++) {
                        int num = grid[rowStart + i][colStart + j];
                        if (num == 0 || subGridSet.contains(num)) return false;
                        subGridSet.add(num);
                    }
                }
            }
        }
        return true;
    }
}
