package com.irosudev.mapgen;

public class Board {

    public final Tile[][] tileBoard;

    public Board(final int width, final int height) {
        this.tileBoard = new Tile[width][height];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (Tile[] tiles : tileBoard) {
            for (Tile tile : tiles) {
                string.append(tile);
            }
            string.append("\n");
        }

        return string.toString();
    }

    /**
     * Place a new [{@link Tile} into the next empty square.
     * It must follow the board [{@link Rules}
     */
    private void addTile(Tile up, Tile left) {

    }
}
