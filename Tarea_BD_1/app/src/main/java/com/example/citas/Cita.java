package com.example.citas;

import android.widget.ImageView;

public class Cita {

    protected int id;
    protected String titulo;
    protected String fecha;
    protected String hora;
    protected String asunto;
    protected int imagen;

    public Cita(int id, String titulo, String fecha, String hora, String asunto) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.asunto = asunto;
       // this.imagen = R.drawable.cita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
