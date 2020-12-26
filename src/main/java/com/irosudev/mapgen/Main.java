package com.irosudev.mapgen;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(5,5);

        board.tileBoard[0][0] = Tile.FIELD;
        board.tileBoard[1][0] = Tile.FIELD;
        board.tileBoard[2][0] = Tile.FIELD;
        board.tileBoard[3][0] = Tile.FIELD;
        board.tileBoard[4][0] = Tile.MOUNTAIN_1;

        board.tileBoard[0][1] = Tile.FOREST;
        board.tileBoard[1][1] = Tile.PATH;
        board.tileBoard[2][1] = Tile.FOREST;
        board.tileBoard[3][1] = Tile.FOREST;
        board.tileBoard[4][1] = Tile.FOREST;

        board.tileBoard[0][2] = Tile.FOREST;
        board.tileBoard[1][2] = Tile.PATH;
        board.tileBoard[2][2] = Tile.PATH;
        board.tileBoard[3][2] = Tile.FOREST;
        board.tileBoard[4][2] = Tile.FOREST;

        board.tileBoard[0][3] = Tile.FOREST;
        board.tileBoard[1][3] = Tile.FOREST;
        board.tileBoard[2][3] = Tile.PATH;
        board.tileBoard[3][3] = Tile.FOREST;
        board.tileBoard[4][3] = Tile.FOREST;

        board.tileBoard[0][4] = Tile.FOREST;
        board.tileBoard[1][4] = Tile.FOREST;
        board.tileBoard[2][4] = Tile.PATH;
        board.tileBoard[3][4] = Tile.WALL;
        board.tileBoard[4][4] = Tile.FOREST;

        System.out.print(board);
    }
}
