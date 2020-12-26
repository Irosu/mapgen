package com.irosudev.mapgen;

import java.awt.*;

/**
 * List of every possible tile that can be placed on the board.
 */
public enum Tile {

    FIELD(new Color(64, 166, 41)), //Color.decode("#40A629")
    FOREST(new Color(35, 125, 38)), //#237D26
    PATH(new Color(190, 172, 131)), //#BEAC83
    CITY_LAND(new Color(127, 102, 86)), //#7F6656
    CITY_PATH(new Color(155, 144, 118)), //#9B9076
    WALL(new Color(36, 32, 28)), //#24201C
    MOUNTAIN_1(new Color(128, 128, 128)), //#808080
    MOUNTAIN_2(new Color(153, 153, 153)); //#999999

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
}
