package com.example.calculadora;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView etiqueta = findViewById(R.id.etiqueta);
        Button limpiar = findViewById(R.id.limpiar);
        Button dividir = findViewById(R.id.dividir);
        Button multiplicar = findViewById(R.id.multiplicar);
        Button suma = findViewById(R.id.suma);
        Button resta = findViewById(R.id.resta);
        Button igual = findViewById(R.id.igual);
        Button borrar = findViewById(R.id.borrar);
        Button cero = findViewById(R.id.cero);
        Button uno = findViewById(R.id.uno);
        Button dos = findViewById(R.id.dos);
        Button tres = findViewById(R.id.tres);
        Button cuatro = findViewById(R.id.cuatro);
        Button cinco = findViewById(R.id.cinco);
        Button seis = findViewById(R.id.seis);
        Button siete = findViewById(R.id.siete);
        Button ocho = findViewById(R.id.ocho);
        Button nueve = findViewById(R.id.nueve);
        Button decimal = findViewById(R.id.decimal);

        uno.setOnClickListener(view -> {
            etiqueta.setText(etiqueta.getText() += 1);
        });
    }
}