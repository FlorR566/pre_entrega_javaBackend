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

    // validar precio
    public static void validarPrecio(double precio){
        // no sean negativos
        // acepta 0
        if (precio < 0){
            throw new  IllegalArgumentException("El precio no puede ser negativo.");
        }
    }
}
