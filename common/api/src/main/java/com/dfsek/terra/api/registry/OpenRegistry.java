package com.dfsek.terra.api.registry;

public interface OpenRegistry<T> extends Registry<T> {
    /**
     * Add a value to this registry.
     *
     * @param identifier Identifier to assign value.
     * @param value      Value to add.
     */
    boolean add(String identifier, T value);

    /**
     * Add a value to this registry, checking whether it is present first.
     *
     * @param identifier Identifier to assign value.
     * @param value      Value to add.
     * @throws DuplicateEntryException If an entry with the same identifier is already present.
     */
    void addChecked(String identifier, T value) throws DuplicateEntryException;

    /**
     * Clears all entries from the registry.
     */
    void clear();
}
