package com.example.citas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InsertarCita extends AppCompatActivity {

    private final AdminBD admin = new AdminBD(InsertarCita.this, MainActivity.nombreBD, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_cita);

        FloatingActionButton atras = findViewById(R.id.atras);
        FloatingActionButton guardar = findViewById(R.id.guardar);
        EditText input_titulo = findViewById(R.id.titulo);
        EditText input_fecha = findViewById(R.id.fecha);
        EditText input_hora = findViewById(R.id.hora);
        EditText input_asunto = findViewById(R.id.asunto);

        // Volvemos al activity principal
        atras.setOnClickListener(v -> {
            Intent intent = new Intent(InsertarCita.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Guardamos la nueva cita
        guardar.setOnClickListener(v -> {

            int id = MainActivity.citas.get(MainActivity.citas.size() - 1).getId() + 1;
            String titulo = input_titulo.getText().toString();
            String fecha = input_fecha.getText().toString();
            String hora = input_hora.getText().toString();
            String asunto = input_asunto.getText().toString();

            // Creamos un nuevo objeto de la clase Cita y lo guardamos el el arraylist
            Cita aux = new Cita(id, titulo, fecha, hora, asunto);
            MainActivity.citas.add(aux);

            // Añadimos la nueva cita a la base de datos
            MainActivity.bd = admin.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            values.put("fecha", fecha);
            values.put("hora", hora);
            values.put("asunto", asunto);
            MainActivity.bd.insert("citas", null, values);

            Intent intent = new Intent(InsertarCita.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}