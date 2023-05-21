package com.assignment.nl22w.game.impl;

public class Stringbuilder {
    public String padRightWhitespaces(String line, int numCols) {
        if (line.length() == numCols) {
            return line;
        }
        StringBuilder sb = new StringBuilder(line);
        while (sb.length() != numCols) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
