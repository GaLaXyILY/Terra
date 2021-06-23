package com.dfsek.terra.carving;

import com.dfsek.terra.api.block.BlockData;
import com.dfsek.terra.api.block.BlockType;
import com.dfsek.terra.api.util.collections.MaterialSet;
import com.dfsek.terra.api.util.collections.ProbabilityCollectionImpl;
import net.jafama.FastMath;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({"unchecked", "rawtypes", "RedundantSuppression"})
public class CarverPalette {
    private final boolean blacklist;
    private final MaterialSet replace;
    private final TreeMap<Integer, ProbabilityCollectionImpl<BlockData>> map = new TreeMap<>();
    private ProbabilityCollectionImpl<BlockData>[] layers;
    private int offset = 0;

    public CarverPalette(MaterialSet replaceable, boolean blacklist) {
        this.blacklist = blacklist;
        this.replace = replaceable;
    }

    public CarverPalette add(ProbabilityCollectionImpl<BlockData> collection, int y) {
        map.put(y, collection);
        return this;
    }

    public ProbabilityCollectionImpl<BlockData> get(int y) {
        int index = y + offset;
        return index >= 0
                ? index < layers.length
                ? layers[index]
                : layers[layers.length - 1]
                : layers[0];
    }

    public boolean canReplace(BlockType material) {
        return blacklist != replace.contains(material);
    }

    /**
     * Build the palette to an array.
     */
    public void build() {
        int min = FastMath.min(map.keySet().stream().min(Integer::compareTo).orElse(0), 0);
        int max = FastMath.max(map.keySet().stream().max(Integer::compareTo).orElse(255), 255);

        layers = new ProbabilityCollectionImpl[map.lastKey() + 1 - min];
        for(int y = min; y <= FastMath.max(map.lastKey(), max); y++) {
            ProbabilityCollectionImpl<BlockData> d = null;
            for(Map.Entry<Integer, ProbabilityCollectionImpl<BlockData>> e : map.entrySet()) {
                if(e.getKey() >= y) {
                    d = e.getValue();
                    break;
                }
            }
            if(d == null) throw new IllegalArgumentException("No palette for Y=" + y);
            layers[y - min] = d;
        }
        offset = -min;
    }
}
