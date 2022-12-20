package com.example.practica_nadador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AgregarEntrenamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_entrenamiento);
        Button añadir = findViewById(R.id.añadir);
        Button cancelar = findViewById(R.id.cancelar);

        EditText input_tiempo = findViewById(R.id.input_tiempo);
        EditText input_distancia = findViewById(R.id.input_distancia);
        EditText input_minkm = findViewById(R.id.input_minkm);
        EditText input_velocidad = findViewById(R.id.input_velocidad);

        cancelar.setOnClickListener(view -> {
            Intent intent = new Intent(AgregarEntrenamiento.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        añadir.setOnClickListener(view -> {
            Intent intent = new Intent(AgregarEntrenamiento.this, MainActivity.class);
            intent.putExtra("tiempo", input_tiempo.getText());
            intent.putExtra("distancia", input_distancia.getText());
            intent.putExtra("minkm", input_minkm.getText());
            intent.putExtra("velocidad", input_velocidad.getText());
            startActivity(intent);
        });

    }
}