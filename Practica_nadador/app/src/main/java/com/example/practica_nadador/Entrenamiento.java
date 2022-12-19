package com.example.practica_nadador;

import java.util.Calendar;

public class Entrenamiento {
    String fecha;
    String tiempo;
    int distancia;
    int min_km;
    int vel_media;
    Calendar calendar = Calendar.getInstance();
    public Entrenamiento() {
        this.fecha = "";
        this.tiempo = "";
        this.distancia = 0;
        this.min_km = 0;
        this.vel_media = 0;
    }

    public Entrenamiento(String fecha, String tiempo, int distancia, int min_km, int vel_media) {
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.distancia = distancia;
        this. min_km = min_km;
        this.vel_media = vel_media;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getMin_km() {
        return min_km;
    }

    public void setMin_km(int min_km) {
        this.min_km = min_km;
    }

    public int getVel_media() {
        return vel_media;
    }

    public void setVel_media(int vel_media) {
        this.vel_media = vel_media;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "fecha='" + fecha + '\'' +
                ", tiempo='" + tiempo + '\'' +
                ", distancia=" + distancia +
                ", min_km=" + min_km +
                ", vel_media=" + vel_media +
                '}';
    }
}
