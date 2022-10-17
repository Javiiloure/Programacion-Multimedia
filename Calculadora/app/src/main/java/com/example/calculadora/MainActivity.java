package com.example.calculadora;

import android.annotation.SuppressLint;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
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


        final String[] op = {""};
        String[] reserva = new String[2];
        reserva[0] = "";
        reserva[1] = "";
        final int[] aux = {0};


        cero.setOnClickListener(view -> {
            reserva[aux[0]] += 0;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        uno.setOnClickListener(view -> {
            reserva[aux[0]] += 1;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        dos.setOnClickListener(view -> {
            reserva[aux[0]] += 2;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        tres.setOnClickListener(view -> {
            reserva[aux[0]] += 3;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        cuatro.setOnClickListener(view -> {
            reserva[aux[0]] += 4;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        cinco.setOnClickListener(view -> {
            reserva[aux[0]] += 5;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        seis.setOnClickListener(view -> {
            reserva[aux[0]] += 6;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        siete.setOnClickListener(view -> {
            reserva[aux[0]] += 7;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        ocho.setOnClickListener(view -> {
            reserva[aux[0]] += 8;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        nueve.setOnClickListener(view -> {
            reserva[aux[0]] += 9;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        decimal.setOnClickListener(view -> {
            reserva[aux[0]] += ".";
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        suma.setOnClickListener(view -> {
            op[0] = "+";
            aux[0]++;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        resta.setOnClickListener(view -> {
            op[0] = "-";
            aux[0]++;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        multiplicar.setOnClickListener(view -> {
            op[0] = "*";
            aux[0]++;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        dividir.setOnClickListener(view -> {
            op[0] = "/";
            aux[0]++;
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });

        igual.setOnClickListener(view -> {
            if(op[0] == "+") {
              etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) + Double.parseDouble(reserva[1])));
            }
            if(op[0] == "-") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) - Double.parseDouble(reserva[1])));
            }
            if(op[0] == "*") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) * Double.parseDouble(reserva[1])));
            }
            if(op[0] == "/") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) / Double.parseDouble(reserva[1])));
            }
            op[0] = "";
            aux[0] = 0;
            reserva[0] = "";
            reserva[1] = "";
        });

        limpiar.setOnClickListener(view -> {
            aux[0] = 0;
            reserva[0] = "";
            reserva[1] = "";
            op[0] = "";
            etiqueta.setText("");
        });

        //borrar.setOnClickListener(view -> {
        //    if(aux[0] == 0) {
        //        reserva[]
        //    }
        //    if(aux[0] == 1) {

        //    }
      //  });
    }
}