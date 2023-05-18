package com.assignment.nl22w.game.impl;

public class StartAndExits {
    public void findMyLocation(char[][] forestMap) {
        int row;
        char myLocation = 'X';
        for (row = 0; row < forestMap.length; row++) {
            for (int col = 0; col < forestMap[row].length; col++) {
                if (forestMap[row][col] == myLocation) {
                    System.out.println("Start coordinates: " + row + ";" + col);
                    break;
                }
            }
        }
    }

    public void findExits(char[][] forestMap, int numRows, int numCols) {
//         Check top and bottom borders

        for (int col = 0; col < numCols; col++) {
            if (forestMap[0][col] == ' ') {
                System.out.println("Exit top coordinates: (0, " + col + ")");
            }
        }

        // Check bottom border
        for (int col = 0; col < numCols; col++) {
            if (forestMap[numRows - 1][col] == ' ') {
                System.out.println("Exit bottom coordinates: (" + (numRows - 1) + ", " + col + ")");
            }
        }

        // Check left border
        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][0] == ' ') {
                System.out.println("Exit left coordinates: (" + row + ", 0)");
            }
        }

        // Check right border
        for (int row = 1; row < numRows - 1; row++) {
            if (forestMap[row][numCols - 1] == ' ') {
                System.out.println("Exit right coordinates: (" + row + ", " + (numCols - 1) + ")");
            }
        }
    }
}
