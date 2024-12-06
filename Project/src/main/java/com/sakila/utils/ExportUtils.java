package com.sakila.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakila.models.Inventory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportUtils {

    // Export CSV
    public static void exportInventoryToCSV(List<Inventory> inventoryList, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Inventory ID, Film ID, Store ID, Last Update\n"); 
            for (Inventory inventory : inventoryList) {
                writer.append(String.format("%d,%d,%d,%s\n", 
                    inventory.getId(), 
                    inventory.getFilm().getId(), 
                    inventory.getStore().getId(), 
                    inventory.getLastUpdate()));
            }

            System.out.println("Exportación a CSV completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Export JSON
    public static void exportInventoryToJSON(List<Inventory> inventoryList, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            objectMapper.writeValue(new File(fileName), inventoryList);
            System.out.println("Exportación a JSON completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
