package com.irosudev.mapgen;

public class Tile {

    public Biome biome;
    public final TilePosition pos;

    public Tile(Biome biome, TilePosition pos) {
        this.biome = biome;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return biome.toString();
    }
}
