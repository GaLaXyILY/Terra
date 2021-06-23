package com.dfsek.terra.api.event.events.world.generation;

import com.dfsek.terra.api.config.ConfigPack;
import com.dfsek.terra.api.event.events.AbstractCancellable;
import com.dfsek.terra.api.event.events.Cancellable;
import com.dfsek.terra.api.event.events.PackEvent;
import com.dfsek.terra.api.block.Block;
import com.dfsek.terra.api.block.state.Container;
import com.dfsek.terra.api.structure.LootTable;
import com.dfsek.terra.api.structure.Structure;
import org.jetbrains.annotations.NotNull;

/**
 * Called when loot is populated.
 */
public class LootPopulateEvent extends AbstractCancellable implements PackEvent, Cancellable {
    private final Block block;
    private final Container container;
    private LootTable table;
    private final ConfigPack pack;
    private final Structure structure;

    public LootPopulateEvent(Block block, Container container, LootTable table, ConfigPack pack, Structure structure) {
        this.block = block;
        this.container = container;
        this.table = table;
        this.pack = pack;
        this.structure = structure;
    }

    @Override
    public ConfigPack getPack() {
        return pack;
    }

    /**
     * Get the block containing the tile entity loot is applied to.
     *
     * @return Block at which loot is applied.
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Get the {@link Container} representing the inventory.
     *
     * @return Inventory recieving loot.
     */
    public Container getContainer() {
        return container;
    }

    /**
     * Get the loot table to be populated.
     * @return Loot table.
     */
    public LootTable getTable() {
        return table;
    }

    /**
     * Set the loot table to be populated.
     *
     * @param table New loot table.
     */
    public void setTable(@NotNull LootTable table) {
        this.table = table;
    }

    /**
     * Get the script used to generate the structure.
     *
     * @return Structure script.
     */
    public Structure getStructure() {
        return structure;
    }
}
