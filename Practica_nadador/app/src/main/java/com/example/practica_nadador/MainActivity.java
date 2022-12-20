package com.example.practica_nadador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

        // Declaramos un arraylist de entrenamientos y añadimos varios entrenamientos

        Entrenamiento entrenamiento_1 = new Entrenamiento("1:01:52", 60, 6, 60);
        Entrenamiento entrenamiento_2 = new Entrenamiento("1:03:52", 62, 6, 59);
        Entrenamiento entrenamiento_3 = new Entrenamiento("0:55:52", 50, 5, 60);
        entrenamientos.add(entrenamiento_1);
        entrenamientos.add(entrenamiento_2);
        entrenamientos.add(entrenamiento_3);

        // Vinculamos la ListView del layout y le asignamos un adaptador de ArrayList
        ListView lista = findViewById(R.id.lista);
        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,entrenamientos);
        lista.setAdapter(adaptador);

        // Boton vinculado Activity para añadir otro entrenamiento
        Button agregar = findViewById(R.id.agregar);
        agregar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AgregarEntrenamiento.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = getIntent();
        if(intent.hasExtra("tiempo") && intent.hasExtra("distancia") && intent.hasExtra("minkm") && intent.hasExtra("velocidad")) {
            String tiempo = intent.getStringExtra("tiempo");
            float distancia = Float.parseFloat(intent.getStringExtra("distancia"));
            float minkm = Float.parseFloat(intent.getStringExtra("minkm"));
            int velocidad = Integer.parseInt(intent.getStringExtra("velocidad"));
            Entrenamiento entrenamiento = new Entrenamiento(tiempo, distancia, minkm, velocidad);
            entrenamientos.add(entrenamiento);
        }
    }
}