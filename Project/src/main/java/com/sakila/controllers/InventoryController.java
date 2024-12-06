package com.sakila.controllers;

import com.sakila.data.DataContext;
import com.sakila.models.Inventory;
import java.util.List;

public final class InventoryController extends DataContext<Inventory> {

    // Método para obtener inventario de una tienda específica por store_id
    public List<Inventory> getInventoryByStore(int storeId) {
        return search("store_id=" + storeId); // Filtra por store_id (lógica simplificada)
    }

    // Método para obtener inventarios asociados a una película específica por film_id
    public List<Inventory> getInventoryByFilm(int filmId) {
        return search("film_id=" + filmId); // Filtra por film_id
    }

    // Método para registrar un nuevo elemento de inventario
    public void addInventory(Inventory inventory) {
        create(inventory);
        System.out.println("Nuevo inventario añadido: " + inventory);
    }

    // Método para eliminar un elemento de inventario por ID
    public void removeInventory(int inventoryId) {
        delete(inventoryId);
        System.out.println("Inventario eliminado con ID: " + inventoryId);
    }
}
