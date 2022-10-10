package com.example.tarea4_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cajatexto1 = (TextView) findViewById(R.id.cajatexto1);
        TextInputLayout cajatexto2 = (TextInputLayout) findViewById(R.id.cajatexto2);
        EditText etiqueta =  (EditText) findViewById(R.id.etiqueta);
        Button boton = (Button) findViewById(R.id.boton);
        ImageView imagen = (ImageView) findViewById(R.id.imagen);


        //Cambiamos el texto por otro texto al hacer click sobre el
        cajatexto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cajatexto1.setText("Texto alternativo");
            }
        });
        //Cambiamos el texto del boton al pulsar sobre el
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton.setText("Registro completo");
            }
        });
    }
}