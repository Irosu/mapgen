package com.irosudev.mapgen;

import java.awt.*;

/**
 * List of every possible tile that can be placed on the board.
 */
public enum Tile {

    CITY_LAND(new Color(127, 102, 86)),
    CITY_PATH(new Color(155, 144, 118)),
    FIELD(new Color(99, 151, 66)),
    FOREST(new Color(35, 125, 38)),
    MOUNTAIN_1(new Color(128, 128, 128)),
    MOUNTAIN_2(new Color(114, 106, 101)),
    PATH(new Color(190, 172, 131)),
    SEA(new Color(31, 60, 137)),
    WALL(new Color(36, 32, 28));

    private final Color color;

    private final static char ESC = 27;
    private final static String PREFIX = ESC + "[48;2;";
    private final static String POSTFIX = "m   " + ESC + "[0m";

    Tile(final Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getDisplay(this.color);
    }

    private String getDisplay(Color color) {
        return PREFIX +
                color.getRed() + ";" +
                color.getGreen() + ";" +
                color.getBlue() +
                POSTFIX;
    }

    public static String displayWhite() {
        return PREFIX + 255 + ";" + 255 + ";" + 255 + POSTFIX;
    }
}
