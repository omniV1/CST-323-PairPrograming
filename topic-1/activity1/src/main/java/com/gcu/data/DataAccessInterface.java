package com.gcu.data;

public interface DataAccessInterface<T> {

    // Get a single item by id
    public T getById(int id);

    // Get all items
    public Iterable<T> getAll();

    // Create a new item
    public T create(T item);

    // Update an existing item
    public T update(T item);

    // Delete an item by id
    public boolean deleteById(int id);
}
