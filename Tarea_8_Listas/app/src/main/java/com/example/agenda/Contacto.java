package com.example.agenda;

public class Contacto {

    public String nombre;
    public String apellido_1;
    public String apellido_2;
    public String email;
    public String direccion;
    public int telefono;

    public Contacto() {
        this.nombre = "";
        this.apellido_1 = "";
        this.apellido_2 = "";
        this.email = "";
        this.direccion = "";
        this.telefono = 0;
    }

    public Contacto(String nombre, String apellido_1, String apellido_2, String email, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellido_1 = apellido_1;
        this.apellido_2 = apellido_2;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido_1 + " " + " " + apellido_2;
    }
}
