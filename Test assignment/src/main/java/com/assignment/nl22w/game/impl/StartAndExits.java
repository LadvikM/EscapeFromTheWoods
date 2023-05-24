package com.assignment.nl22w.game.impl;

import java.util.ArrayList;
import java.util.List;


public class StartAndExits {
    public int[] findMyLocation(char[][] forestMap) {
        return findStartCoordinates(forestMap);
    }

    public List<int[]> findExits(char[][] forestMap, int numRows, int numCols) {
        List<int[]> listOfExits = new ArrayList<>();

        findExitsOnTopBorder(forestMap, numCols, listOfExits);
        findExitsOnBottomBorder(forestMap, numRows, numCols, listOfExits);
        findExitsOnLeftBorder(forestMap, numRows, listOfExits);
        findExitsOnRightBorder(forestMap, numRows, numCols, listOfExits);
        return listOfExits;
    }

    private static int[] findStartCoordinates(char[][] forestMap) {

        for (int row = 0; row < forestMap.length; row++) {
            for (int col = 0; col < forestMap[row].length; col++) {
                if (forestMap[row][col] == 'X') {
                    return new int[]{row, col};

                }
            }
        }
        return new int[0];
    }

    private static void findExitsOnTopBorder(char[][] forestMap, int numCols, List<int[]> listOfExits) {
        for (int col = 0; col < numCols; col++) {
            if (forestMap[0][col] == ' ') {
                int[] exit = {0, col};
                listOfExits.add(exit);
            }
        }
    }

    private static void findExitsOnBottomBorder(char[][] forestMap, int numRows, int numCols, List<int[]> listOfExits) {
        for (int col = 0; col < numCols; col++) {
            if (forestMap[numRows - 1][col] == ' ') {
                int[] exit = {numRows - 1, col};
                listOfExits.add(exit);

            }
        }
    }

    private static void findExitsOnLeftBorder(char[][] forestMap, int numRows, List<int[]> listOfExits) {
        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][0] == ' ') {
                int[] exit = {row, 0};
                listOfExits.add(exit);
            }
        }
    }

    private static void findExitsOnRightBorder(char[][] forestMap, int numRows, int numCols, List<int[]> listOfExits) {
        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][numCols - 1] == ' ') {
                int[] exit = {row, numCols - 1};
                listOfExits.add(exit);
            }
        }
    }
}
