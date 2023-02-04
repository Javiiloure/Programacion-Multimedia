package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MostrarContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contanto);

        Intent intent = getIntent();
        String aux = intent.getStringExtra("apodo");
        TextView apodo = findViewById(R.id.apodo);
        apodo.setText(aux);

        aux = intent.getStringExtra("nombre");
        TextView nombre = findViewById(R.id.nombre);
        nombre.setText(aux);

        aux = intent.getStringExtra("apellido1");
        TextView apellido1 = findViewById(R.id.apellido1);
        apellido1.setText(aux);

        aux = intent.getStringExtra("apellido2");
        TextView apellido2 = findViewById(R.id.apellido2);
        apellido2.setText(aux);

        aux = intent.getStringExtra("telefono");
        TextView telefono = findViewById(R.id.telefono);
        telefono.setText(aux);

        aux = intent.getStringExtra("email");
        TextView email = findViewById(R.id.email);
        email.setText(aux);

        aux = intent.getStringExtra("direccion");
        TextView direccion = findViewById(R.id.direccion);
        direccion.setText(aux);

        FloatingActionButton retroceder = findViewById(R.id.retroceder);

        retroceder.setOnClickListener(v -> {
            startActivity(new Intent(MostrarContacto.this, MainActivity.class));
            finish();
        });
    }
}