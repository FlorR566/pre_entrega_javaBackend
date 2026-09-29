package com.tup.talentolab.model;

public class Producto {

    private static Long contadorId = 0L;  // contador global que vive a nivel de clase

    // atributos
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // constructor vacío
    public  Producto() {
        this.id = ++contadorId;
        setNombre("nombre_defecto");
    }

    // sobrecarga de constructor
    public Producto(String nombre, double precio, int stock, String categoria) {
        this.id = ++contadorId;
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        setCategoria(categoria);
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        } else {
            this.nombre = "nombre_defecto";
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.isBlank()) {
            this.categoria = categoria;
        }
    }

    public static Long getContadorId() {
        return contadorId;
    }

    // toString
    @Override
    public String toString() {
        return "[ID: " + id + "] " + nombre +
                " | Precio: $" + precio +
                " | Stock: " + stock +
                " | Categoria: " + categoria;
    }
}
