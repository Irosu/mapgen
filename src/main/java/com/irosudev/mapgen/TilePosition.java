package com.irosudev.mapgen;

import org.apache.commons.lang3.tuple.MutablePair;

public class TilePosition extends MutablePair<Integer, Integer> {

    public TilePosition(int left, int right) {
        super(left, right);
    }

    /**
     * Calculates de vector sum of the current TilePosition and the given one.
     * @return TilePosition
     */
    public TilePosition addTile(TilePosition a) {
        addC(a.left);
        addR(a.right);
        return this;
    }

    public TilePosition addC(int c) {
        this.left += c;
        return this;
    }

    public TilePosition addR(int r) {
        this.right += r;
        return this;
    }
}
