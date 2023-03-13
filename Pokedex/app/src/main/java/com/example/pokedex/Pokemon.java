package com.example.pokedex;

public class Pokemon {

    int id;
    String nombre;
    int evolucion;

    String ataque;
    String ataque2;

    String tipo;
    String tipo2;

    public Pokemon(int id, String nombre, int evolucion, String ataque, String ataque2, String tipo, String tipo2){
        this.id = id;
        this.nombre = nombre;
        this.evolucion =  evolucion;
        this.ataque = ataque;
        this.ataque2 = ataque2;
        this.tipo = tipo;
        this.tipo2 = tipo2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(int evolucion) {
        this.evolucion = evolucion;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getAtaque2() {
        return ataque2;
    }

    public void setAtaque2(String ataque2) {
        this.ataque2 = ataque2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }
}
