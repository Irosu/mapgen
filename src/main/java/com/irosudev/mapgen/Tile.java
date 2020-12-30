package com.irosudev.mapgen;

public class Tile {

    private final Biome biome;
    private final TilePosition position;

    public Tile(Biome biome, TilePosition position) {
        this.biome = biome;
        this.position = position;
    }

    @Override
    public String toString() {
        return biome.toString();
    }
}
