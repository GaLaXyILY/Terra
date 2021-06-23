package com.dfsek.terra.api.util;

import com.dfsek.terra.api.world.Chunk;

import java.util.Random;

public final class PopulationUtil {
    public static FastRandom getRandom(Chunk c) {
        return getRandom(c, 0);
    }

    public static FastRandom getRandom(Chunk c, long salt) {
        return new FastRandom(getCarverChunkSeed(c.getX(), c.getZ(), c.getWorld().getSeed() + salt));
    }

    /**
     * Gets the carver seed for a chunk.
     *
     * @param chunkX Chunk's X coordinate
     * @param chunkZ Chunk's Z coordinate
     * @param seed   World seed
     * @return long - The carver seed.
     */
    public static long getCarverChunkSeed(int chunkX, int chunkZ, long seed) {
        Random r = new FastRandom(seed);
        return chunkX * r.nextLong() ^ chunkZ * r.nextLong() ^ seed;
    }
}
