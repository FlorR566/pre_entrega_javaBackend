package com.tup.talentolab.model;

public class Cliente {

    private static Long contadorId = 0L;

    // atributos
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    // constructor
    public Cliente() {
        this.id = ++contadorId;
    }

    // sobrecarga constructor
    public Cliente(String nombre, String apellido, String email) {
        this();
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
    }

    // getters y setters
    public static Long getContadorId() {
        return contadorId;
    }

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
            this.nombre = "nombre_cliente" + getId();
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.isBlank()) {
            this.apellido = apellido;
        } else {
            this.apellido = "apellido_cliente" + getId();
        }
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank() && email.contains("@")) {
            this.email = email;
        }
    }


    // toString
    @Override
    public String toString() {
        return "Cliente[" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                "]";
    }
}
