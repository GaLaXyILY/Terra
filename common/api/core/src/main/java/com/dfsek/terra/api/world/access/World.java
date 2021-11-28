/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra API is licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in the common/api directory.
 */

package com.dfsek.terra.api.world.access;

import com.dfsek.terra.api.util.vector.Vector3;
import com.dfsek.terra.api.world.chunk.Chunk;


public interface World extends WritableWorld {
    Chunk getChunkAt(int x, int z);
    
    default Chunk getChunkAt(Vector3 location) {
        return getChunkAt(location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }
}
