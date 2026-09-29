package com.tup.talentolab;

import com.tup.talentolab.exception.ProductoNoEncontradoException;
import com.tup.talentolab.model.Producto;
import com.tup.talentolab.service.ProductoService;
import com.tup.talentolab.util.Validador;

import java.util.Scanner;

public class Main {

    private static final String MENU = """

            ¿Qué querés hacer?
            1. Agregar producto
            2. Listar productos
            3. Buscar por ID
            4. Eliminar por ID
            0. Salir
            """;

    public static void main(String[] args) {
        ProductoService servicio = new ProductoService();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== GESTIÓN DE PRODUCTOS ===");

            int opcion;
            do {
                System.out.println(MENU);
                opcion = Validador.leerEntero(sc, "Opción: ");

                try {
                    ejecutar(opcion, sc, servicio);
                } catch (ProductoNoEncontradoException | IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (opcion != 0);
        }
    }

    private static void ejecutar(int opcion, Scanner sc, ProductoService servicio) {
        switch (opcion) {
            case 1 -> agregarProducto(sc, servicio);
            case 2 -> servicio.listar();
            case 3 -> buscarProducto(sc, servicio);
            case 4 -> eliminarProducto(sc, servicio);
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida. Elegí entre 0 y 4.");
        }
    }

    private static void agregarProducto(Scanner sc, ProductoService servicio) {
        String nombre = Validador.leerTexto(sc, "Ingrese el nombre del producto: ");
        Validador.validarNombre(nombre);

        double precio = Validador.leerDecimal(sc, "Ingrese el precio: ");
        Validador.validarPrecio(precio);

        int stock = Validador.leerEntero(sc, "Ingrese el stock: ");
        Validador.validarStock(stock);

        String categoria = Validador.leerTexto(sc, "Ingrese la categoría: ");
        Validador.validarCategoria(categoria);

        servicio.agregar(nombre, precio, stock, categoria);
    }

    private static void buscarProducto(Scanner sc, ProductoService servicio) {
        int id = Validador.leerEntero(sc, "ID a buscar: ");
        Producto p = servicio.buscarPorId(id);
        System.out.println("Encontrado: " + p);
    }

    private static void eliminarProducto(Scanner sc, ProductoService servicio) {
        int id = Validador.leerEntero(sc, "ID a eliminar: ");
        servicio.eliminar(id);
    }
}
