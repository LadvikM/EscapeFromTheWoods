package com.assignment.nl22w.game.impl;

import java.util.ArrayList;
import java.util.List;

public class StartAndExits {
    public int[] findMyLocation(char[][] forestMap) {
        int row;
        char myLocation = 'X';

        int[] start = new int[0];
        for (row = 0; row < forestMap.length; row++) {
            for (int col = 0; col < forestMap[row].length; col++) {
                if (forestMap[row][col] == myLocation) {
                    start = new int[]{row, col};
                }
            }
        }
        return start;

    }

    public List<int[]> findExits(char[][] forestMap, int numRows, int numCols) {
        List<int[]> listOfExits = new ArrayList<>();

        // Check top and bottom borders
        for (int col = 0; col < numCols; col++) {
            if (forestMap[0][col] == ' ') {
                int[] exit = {0, col};
                listOfExits.add(exit);
//                System.out.println("Exit top coordinates: (0, " + col + ")");

            }
        }

        // Check bottom border
        for (int col = 0; col < numCols; col++) {
            if (forestMap[numRows - 1][col] == ' ') {
                int[] exit = {numRows - 1, col};
                listOfExits.add(exit);
//                System.out.println("Exit bottom coordinates: (" + (numRows - 1) + ", " + col + ")");
            }
        }

        // Check left border
        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][0] == ' ') {
                int[] exit = {row, 0};
                listOfExits.add(exit);
//                System.out.println("Exit left coordinates: (" + row + ", 0)");
            }
        }

        // Check right border
        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][numCols - 1] == ' ') {
                int[] exit = {row, numCols - 1};
                listOfExits.add(exit);
//                System.out.println("Exit right coordinates: (" + row + ", " + (numCols - 1) + ")");
            }
        }
        return listOfExits;
    }
}
