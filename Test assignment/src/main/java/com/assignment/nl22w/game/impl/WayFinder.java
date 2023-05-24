package com.assignment.nl22w.game.impl;

import java.util.*;

public class WayFinder {

    static boolean isValidMove(int row, int col, char[][] forestMap, boolean[][] visited) {
        return (row >= 0) && (row < forestMap.length) && (col >= 0) && (col < forestMap[0].length)
                && forestMap[row][col] == ' ' && !visited[row][col];
    }

    public int findWayOut(char[][] forestMap, int[] myLocation, List<int[]> exits) {
        int minSteps = 0;
        ArrayList<Integer> steps = new ArrayList<>();
        for (int[] exit : exits) {
            int stepCount = findShortestPathToExit(forestMap, myLocation, exit);
            steps.add(stepCount);
            minSteps = Collections.min(steps);
        }
        return minSteps;
    }

    private int findShortestPathToExit(char[][] forestMap, int[] myLocation, int[] exit) {


        boolean[][] visited = new boolean[forestMap.length][forestMap[0].length];
        visited[myLocation[0]][myLocation[1]] = true;
        Queue<queueNode> coordinatesAndDistances = new LinkedList<>();
        queueNode start = new queueNode(myLocation[0], myLocation[1], 0);
        coordinatesAndDistances.add(start);
        while (!coordinatesAndDistances.isEmpty()) {
            queueNode current = coordinatesAndDistances.peek();
            int[] currentCoordinates = {current.x, current.y};
            int stepCount = current.dist;
            if (currentCoordinates[0] == exit[0] && currentCoordinates[1] == exit[1]) {
                return stepCount;
            }
            coordinatesAndDistances.remove();
            moveToValidAdjacentCell(forestMap, visited, coordinatesAndDistances, current);
        }
        return 0;
    }

    private static void moveToValidAdjacentCell(char[][] forestMap, boolean[][] visited, Queue<queueNode> coordinatesAndDistances, queueNode current) {
        int[] rowNum = {-1, 0, 0, 1};
        int[] colNum = {0, -1, 1, 0};
        for (int i = 0; i < 4; i++) {
            int newX = current.x + rowNum[i];
            int newY = current.y + colNum[i];
            if (isValidMove(newX, newY, forestMap, visited)) {
                visited[newX][newY] = true;
                queueNode adjacentCell = new queueNode(newX, newY, current.dist + 1);
                coordinatesAndDistances.add(adjacentCell);
            }
        }
    }

    static class queueNode {
        int x;
        int y;
        int dist;

        public queueNode(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

