package com.example.tarea_bd_0;

public class Persona {

    public int codigo;
    public String nombre;
    public String apellidos;
    public String direccion;
    public String telefono;

    public Persona() {
        this.codigo = 0;
        this.nombre = "";
        this.apellidos = "";
        this.direccion = "";
        this.telefono = "";
    }

    public Persona(int codigo, String nombre, String apellidos, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return codigo + " " + nombre + " " + apellidos + " " + direccion + " " + telefono;
    }
}