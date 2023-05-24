package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@Slf4j
public class GameImpl implements Game {

    private static List<int[]> findAllExits(int numRows, int numCols, char[][] forestMap, StartAndExits startAndExits) {
        return startAndExits.findExits(forestMap, numRows, numCols);
    }

    private static int[] findStartLocation(char[][] forestMap, StartAndExits startAndExits) {
        return startAndExits.findMyLocation(forestMap);
    }

    private static char[][] create2DForestMap(BufferedReader reader, int numRows, int numCols) throws IOException {
        String line;
        char[][] forestMap = new char[numRows][numCols];
        int row = 0;
        Stringbuilder stringbuilder = new Stringbuilder();
        while ((line = reader.readLine()) != null) {
            String lineToArray = stringbuilder.padRightWhitespaces(line, numCols);
            forestMap[row] = lineToArray.toCharArray();
            row++;
        }
        return forestMap;
    }

    @Override
    public int escapeFromTheWoods(Resource resource) throws IOException {
        if (!resource.isReadable()) {
            return 0;
        }
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        int numRows = 0;
        int numCols = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if (numCols == 0) {
                numCols = line.length();
            }
            numRows++;
        }
        boolean inLimits = checkForestSize(numRows, numCols);
        if (!inLimits) {
            return 0;
        }

        inputStream = resource.getInputStream();
        inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        reader = new BufferedReader(inputStreamReader);

        char[][] forestMap = create2DForestMap(reader, numRows, numCols);
        reader.close();
        inputStreamReader.close();
        inputStream.close();

        StartAndExits startAndExits = new StartAndExits();
        int[] myLocation = findStartLocation(forestMap, startAndExits);
        if (myLocation.length == 0) {
            return 0;
        }
        List<int[]> exits = findAllExits(numRows, numCols, forestMap, startAndExits);

        int output;
        if (exits.isEmpty()) {
            return 0;
        } else {
            WayFinder wayFinder = new WayFinder();
            output = wayFinder.findWayOut(forestMap, myLocation, exits);
        }

        return output;
    }

    public static boolean checkForestSize(int numRows, int numCols) {
        return numRows >= 5 && numRows <= 11000 && numCols >= 5 && numCols <= 11000;

    }


}
