package com.tup.talentolab.util;

/**
 * Clase con métodos de validación reutilizables.
 * Todos los métodos son estáticos.
 *
 **/
public class Validador {
    // validar nombre
    public static void validarNombre(String nombre){
        // Un nombre vacío no representa un producto válido
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }
}
