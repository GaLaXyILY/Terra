package com.dfsek.terra.config.dummy;

import com.dfsek.terra.api.vector.Location;
import com.dfsek.terra.api.block.Block;
import com.dfsek.terra.api.entity.Entity;
import com.dfsek.terra.api.entity.EntityType;
import com.dfsek.terra.api.world.Chunk;
import com.dfsek.terra.api.world.World;
import com.dfsek.terra.api.world.generator.ChunkGenerator;
import com.dfsek.terra.api.world.generator.GeneratorWrapper;

public class DummyWorld implements World {
    @Override
    public Object getHandle() {
        throw new UnsupportedOperationException("Cannot get handle of DummyWorld");
    }

    @Override
    public long getSeed() {
        return 2403L;
    }

    @Override
    public int getMaxHeight() {
        return 255;
    }

    @Override
    public ChunkGenerator getGenerator() {
        return () -> (GeneratorWrapper) () -> null;
    }

    @Override
    public Chunk getChunkAt(int x, int z) {
        throw new UnsupportedOperationException("Cannot get chunk in DummyWorld");
    }

    @Override
    public Block getBlockAt(int x, int y, int z) {
        throw new UnsupportedOperationException("Cannot get block in DummyWorld");
    }

    @Override
    public Entity spawnEntity(Location location, EntityType entityType) {
        throw new UnsupportedOperationException("Cannot spawn entity in DummyWorld");
    }

    @Override
    public int getMinHeight() {
        return 0;
    }
}
