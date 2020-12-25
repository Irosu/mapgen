package com.irosudev.mapgen;

/**
 * List every possible piece that can be placed on the board.
 */
public enum Pieces {
    BUILDING(
            "______" +
                  "| [] |" +
                  "| [] |"
    ),

    PATH(
            "*-+-=-" +
                  "-=-=-*" +
                  "-*=--+"
    ),

    PLAIN(
            "------" +
                  "------" +
                  "------"
    ),

    SEA(
            "~~~~~~" +
                  "~~~~~~" +
                  "~~~~~~"
    ),

    TREE(
            " ++++ " +
                  "/ [] \\" +
                  "  []  "
    ),

    WALL(
            "++++++" +
                  "++++++" +
                  "++++++"
    );

    private final String shape;

    Pieces(final String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
