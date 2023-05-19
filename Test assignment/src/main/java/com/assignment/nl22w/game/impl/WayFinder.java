package com.assignment.nl22w.game.impl;

import java.util.List;

public class WayFinder {


    public void findWayOut(char[][] forestMap, int[] myLocation, List<int[]> exits) {
        int[] exit = exits.get(1);
        int distance = findShortestPath(forestMap, myLocation, exit);
    }

    private int findShortestPath(char[][] forestMap, int[] myLocation, int[] exit) {
        return 0;
    }
}
