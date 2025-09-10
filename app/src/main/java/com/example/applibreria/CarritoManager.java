package com.example.applibreria;

import java.util.ArrayList;
import java.util.List;

public class CarritoManager {

    // 1. Instancia única (Singleton)
    private static final CarritoManager instance = new CarritoManager();

    // 2. Lista para almacenar los libros del carrito
    private final List<Libro> itemsCarrito = new ArrayList<>();

    // 3. Constructor privado para evitar instanciación externa
    private CarritoManager() {
    }

    // 4. Método estático para obtener la única instancia
    public static CarritoManager getInstance() {
        return instance;
    }

    // 5. Métodos para gestionar el carrito
    public void agregarLibro(Libro libro) {
        // Lógica para agregar un libro
        if (libro != null) {
            itemsCarrito.add(libro);
        }
    }

    public List<Libro> getItemsCarrito() {
        return itemsCarrito;
    }

    public void limpiarCarrito() {
        itemsCarrito.clear();
    }
}