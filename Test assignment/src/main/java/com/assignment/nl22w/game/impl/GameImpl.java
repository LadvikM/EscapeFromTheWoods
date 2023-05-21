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

    @Override
    public int escapeFromTheWoods(Resource resource) {
        //TODO start your journey here
        int output;
        try {
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
            reader.close();
            inputStream.close();
            inputStream = resource.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);

            // Make 2D array
            char[][] forestMap = new char[numRows][numCols];
            int row = 0;

            Stringbuilder stringbuilder = new Stringbuilder();
            while ((line = reader.readLine()) != null) {
                String lineToArray = stringbuilder.padRightWhitespaces(line, numCols);
                forestMap[row] = lineToArray.toCharArray();
                row++;
            }
            StartAndExits startAndExits = new StartAndExits();
            int[] myLocation = startAndExits.findMyLocation(forestMap);
            List<int[]> exits = startAndExits.findExits(forestMap, numRows, numCols);
            WayFinder wayFinder = new WayFinder();
            if (exits.isEmpty()) {
                output = 0;
            } else {
                output = wayFinder.findWayOut(forestMap, myLocation, exits);
            }


            reader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            output = 0;
        }

        System.out.println("I returned: " + output);
        return output;
    }


}
