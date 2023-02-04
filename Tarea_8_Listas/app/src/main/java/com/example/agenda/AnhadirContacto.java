package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AnhadirContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anhadir_contacto);

        EditText apodo = findViewById(R.id.apodo);
        EditText nombre = findViewById(R.id.nombre);
        EditText apellido1 = findViewById(R.id.apellido1);
        EditText apellido2 = findViewById(R.id.apellido2);
        EditText email = findViewById(R.id.email);
        EditText telefono = findViewById(R.id.telefono);
        EditText direccion = findViewById(R.id.direccion);
        Button guardar = findViewById(R.id.guardar);

        guardar.setOnClickListener(v -> {
            Contacto contacto = new Contacto(apodo.getText().toString(), nombre.getText().toString(), apellido1.getText().toString(), apellido2.getText().toString(), email.getText().toString(), direccion.getText().toString(), Integer.parseInt(telefono.getText().toString()));
            Intent intent = new Intent(AnhadirContacto.this, MainActivity.class);
            MainActivity.contactos.add(contacto);
            MainActivity.lista.setAdapter(MainActivity.adapter);
            finish();
        });
    }
}