package com.irosudev.mapgen;

import java.util.Random;

public class Board {

    public final Tile[][] tileBoard;

    private final int cols;
    private final int rows;

    private final TilePosition initTile;

    private final int totalSeaTiles;
    private static final int MAX_SEA_PROP = 50;
    private static final int MIN_SEA_PROP = 10;

    public Board(final int rows, final int cols) throws Exception {
        if(cols < rows) {
            throw new Exception("The height of the board must be equals or smaller than its width.");
        }
        this.rows = rows;
        this.cols = cols;
        this.tileBoard = new Tile[rows][cols];
        this.totalSeaTiles = generateSeaProp();
        this.initTile = calcInitTale();
        this.fillBoard();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Tile[] tiles : tileBoard) {
            for (Tile tile : tiles) {
                builder.append(tile);
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    private void fillBoard() {
        int r = initTile.left;          //Fila actual
        int c = initTile.right;         //Columna actual
        final int sa = cols - rows + 1; //Suma a la columna para calcular dónde acaba el bucle
        int s = 0;                      //Suma a la columna y la fila para calcular dónde acaba el bucle
        int rf = r + s + 1;             //Fila final de bucle
        int cf = c + sa + s;            //Columna final de bucle
        int n = 1;                      //Movimientos actuales
        final int t = cols * rows;      //Movimientos totales
        boolean add;                    //Nos dice si hay que añadir o quitar en cada bucle

        colorTile(r, c, t * 1.0 / n);

        do {
            s++;
            add = s % 2 == 0;

            //Bucle que recorre las columnas
            for(boolean jump = true; (add ? c >= cf : c <= cf) && n < t; c += add ? -1 : 1, n++) {
                if(!jump){
                    colorTile(r, c, t * 1.0 / n);
                }
                else {
                    n--;
                    jump = false;
                }
            }
            //Restablecemos la posición a la última válida
            c = cf;
            //Sumamos en el sentido contrario tras cada bucle
            cf = add ? c+sa+s : c-sa-s;

            //Bucle que recorre las filas
            for(boolean jump = true; (add ? r >= rf : r <= rf) && n < t; r += add ? -1 : 1, n++) {
                if(!jump) {
                    colorTile(r, c, t * 1.0 / n);
                }
                else {
                    n--;
                    jump = false;
                }
            }
            //Restablecemos la posición a la última válida
            r = rf;
            //Sumamos en el sentido contrario tras cada bucle
            rf = add ? r+(s+1) : r-(s+1);

        } while (n < t);

    }

    /**
     * Place a new {@link Tile} into the given position.
     */
    private void colorTile(int r, int c, double n) {
        tileBoard[r][c] = new Tile(fieldOrSea(r, c, n), new TilePosition(r, c));
    }

    /**
     * Decide whether the next {@link Biome} is FIELD or SEA
     * @param
     * @return the chosen {@link Biome}
     */
    private Biome fieldOrSea(int r, int c, double n) {
        return Math.random()*n >= 0.5 ? Biome.FIELD : Biome.SEA;
    }

    /**
     * Calculates a random number of sea tiles for the current tileBoard, MAX_SEA_PROP and MIN_SEA_PROP.
     * @return number of {@link Tile} to be initially filled as SEA
     */
    private int generateSeaProp() {
        int totalTiles = cols * rows;
        Random rng = new Random();

        return rng.ints(totalTiles * MIN_SEA_PROP, totalTiles * MAX_SEA_PROP)
                .findFirst().getAsInt();
    }

    /**
     * Calculates the position of the board to start filling it.
     * @return {@link TilePosition} to start
     */
    private TilePosition calcInitTale() {
        int pos = (int)Math.ceil(rows/2.0) - 1;
        return new TilePosition(pos, pos);
    }


    private void killLonelyTiles() {
        for (Tile[] tiles : tileBoard) {
            for (Tile tile : tiles) {
                int count = 0;

            }
        }
    }

    private int surroundingTiles(TilePosition pos) {
return 0;
    }

    /**
     * Runs a new thread that will display the next tile of the board every 20 ms.
     */
    synchronized public void display() {
        Thread displayThread = new Thread(() -> {
            for (Tile[] tiles : tileBoard) {
                for (Tile tile : tiles) {
                    System.out.print(tile);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        });

        displayThread.start();
    }
}
