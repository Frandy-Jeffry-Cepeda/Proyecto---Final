package com.sakila.controllers;

import com.sakila.models.Rental;
import com.sakila.data.DataContext;

import java.util.List;

public final class RentalController extends DataContext<Rental> {

    // Método para obtener todos los alquileres de un cliente específico
    public List<Rental> getRentalsByCustomerId(int customerId) {
        return search("customer_id=" + customerId); // Filtrado básico
    }

    // Método para registrar un nuevo alquiler
    public void rentFilm(Rental rental) {
        create(rental);
        System.out.println("Película alquilada: " + rental);
    }
}
