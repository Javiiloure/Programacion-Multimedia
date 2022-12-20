package com.example.practica_nadador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Entrenamiento {
    String fecha;
    String tiempo;
    float distancia;
    float min_km;
    int vel_media;

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public Entrenamiento() {
        this.fecha = sdf.format(calendar.getTime());
        this.tiempo = "";
        this.distancia = 0;
        this.min_km = 0;
        this.vel_media = 0;
    }

    public Entrenamiento (String tiempo, float distancia, float min_km, int vel_media) {
        this.fecha = sdf.format(calendar.getTime());
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

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getMin_km() {
        return min_km;
    }

    public void setMin_km(float min_km) {
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
