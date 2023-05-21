package com.assignment.nl22w.game.impl;

import java.util.ArrayList;
import java.util.List;

public class StartAndExits {
    public int[] findMyLocation(char[][] forestMap) {
        int[] start = new int[0];
        for (int row = 0; row < forestMap.length; row++) {
            for (int col = 0; col < forestMap[row].length; col++) {
                if (forestMap[row][col] == 'X') {
                    start = new int[]{row, col};
                }
            }
        }
        return start;
    }

    public List<int[]> findExits(char[][] forestMap, int numRows, int numCols) {
        List<int[]> listOfExits = new ArrayList<>();

        for (int col = 0; col < numCols; col++) {
            if (forestMap[0][col] == ' ') {
                int[] exit = {0, col};
                listOfExits.add(exit);
            }
        }

        for (int col = 0; col < numCols; col++) {
            if (forestMap[numRows - 1][col] == ' ') {
                int[] exit = {numRows - 1, col};
                listOfExits.add(exit);

            }
        }

        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][0] == ' ') {
                int[] exit = {row, 0};
                listOfExits.add(exit);
            }
        }

        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][numCols - 1] == ' ') {
                int[] exit = {row, numCols - 1};
                listOfExits.add(exit);
            }
        }
        return listOfExits;
    }
}
