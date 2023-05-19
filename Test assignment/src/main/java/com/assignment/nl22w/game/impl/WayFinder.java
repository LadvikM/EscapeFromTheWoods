package com.assignment.nl22w.game.impl;

import java.util.*;

public class WayFinder {

    static boolean isValidMove(int row, int col, int rows, int cols) {
        if ((row >= 0) && (row < rows) &&
                (col >= 0) && (col < cols)) {
            return true;
        }
        return false;

    }

    public int findWayOut(char[][] forestMap, int[] myLocation, List<int[]> exits) {
        int minSteps = 0;
        ArrayList<Integer> steps = new ArrayList<>();
        for (int[] exit : exits) {
            int stepCount = findShortestPath(forestMap, myLocation, exit);
            steps.add(stepCount);
            minSteps = Collections.min(steps);
            if (stepCount == -1) {
                System.out.println("No way out!");
            } else System.out.println("Shortest way is: " + stepCount);
        }

        System.out.println("Kõige vähem samme:" + minSteps);
        return minSteps;
    }

    private int findShortestPath(char[][] forestMap, int[] myLocation, int[] exit) {
        //Map size
        int rows = forestMap.length;
        int cols = forestMap[0].length;
        //Exit coordinates
        int exitX = exit[0];
        int exitY = exit[1];

        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};
        boolean[][] visited = new boolean[rows][cols];
        //Mark starting point as visited
        visited[myLocation[0]][myLocation[1]] = true;
        // Create a queue for BFS
        Queue<queueNode> coordinatesAndDistances = new LinkedList<>();
        //Add start coordinates and distance to queue
        queueNode start = new queueNode(myLocation[0], myLocation[1], 0);
        coordinatesAndDistances.add(start);
        while (!coordinatesAndDistances.isEmpty()) {
            queueNode current = coordinatesAndDistances.peek();
            int x = current.x;
            int y = current.y;
            int stepCount = current.dist;
            //Check whether current coordinates are at exit
            if (x == exitX && y == exitY) {
                return stepCount;
            }
            coordinatesAndDistances.remove();
            for (int i = 0; i < 4; i++) {
                int row = x + rowNum[i];
                int col = y + colNum[i];

                // if adjacent cell is not out of bounds, is not a tree
                // and not visited yet, enqueue it.
                if (isValidMove(row, col, rows, cols) &&
                        forestMap[row][col] == ' ' &&
                        !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode adjecentCell = new queueNode(row, col,current.dist + 1);
                    coordinatesAndDistances.add(adjecentCell);
                }
            }
        }
        return -1;

    }


    // A Data Structure for queue used in BFS
    static class queueNode {
        // The coordinates of a cell and distance to it from start
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

