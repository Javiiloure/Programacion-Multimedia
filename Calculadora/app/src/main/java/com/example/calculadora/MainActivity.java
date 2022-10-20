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

        // Declaracion y relacion de todos los elementos del layout
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

        // String op para guardar la operación a realizar
        final String[] op = {""};
        // Array de Strings para guardar los dos numeros con los que se va a operar
        String[] reserva = new String[2];
        reserva[0] = "";
        reserva[1] = "";
        // Entero auxiliar para acceder al numero uno o al numero dos
        final int[] aux = {0};

        // Si presionamos los valores, estos se guardaran el reserva, dependiendo del valor de aux
        // sera el primer operando o el segundo
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


        // Si se presiona un boton relacionado con una operación, se guardara dicha operacion en la variale op
        // y sumamos 1 a aux para comenzar a registrar el segundo numero
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

        // Si se presiona el boton igual se hace la operacion de los numeros guardados en reserva
        igual.setOnClickListener(view -> {
            if (op[0] == "+") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) + Double.parseDouble(reserva[1])));
            }
            if (op[0] == "-") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) - Double.parseDouble(reserva[1])));
            }
            if (op[0] == "*") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) * Double.parseDouble(reserva[1])));
            }
            if (op[0] == "/") {
                etiqueta.setText(String.valueOf(Double.parseDouble(reserva[0]) / Double.parseDouble(reserva[1])));
            }
            // Reseteamos las variables
            op[0] = "";
            aux[0] = 0;
            reserva[0] = "";
            reserva[1] = "";
        });

        // Si se presiona limpiar reseteamos todas las variables
        limpiar.setOnClickListener(view -> {
            aux[0] = 0;
            reserva[0] = "";
            reserva[1] = "";
            op[0] = "";
            etiqueta.setText("");
        });

        // Si se preasiona borrar primero se comprueba si se trata del
        // primer operando, del operador o del segundo operando
        borrar.setOnClickListener(view -> {
            // Si es el segundo operando se elimina la ultima cifra
           if(reserva[1].length() > 0) {
               reserva[1] = reserva[1].substring(0, reserva[1].length()-1);
               // Si se elimina la ultima cifra, aux se iguala a cero
               if(reserva[1].length() == 0) {
                   aux[0] = 0;
               }
           } else if(op[0].length() > 0) {
               op[0] = "";
               if(reserva[1].length() == 0) {
                   aux[0] = 0;
               }
           } else {
               reserva[0] = reserva[0].substring(0, reserva[0].length()-1);
           }
            etiqueta.setText(reserva[0] + op[0] + reserva[1]);
        });
    }
}