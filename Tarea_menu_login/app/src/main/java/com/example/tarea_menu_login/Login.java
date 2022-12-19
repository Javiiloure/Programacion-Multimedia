package com.example.tarea_menu_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Guardamos en sharedpreferences los valores de usuario y contraseña que vamos a usar.
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Usuario", "Javiloure");
        editor.putString("Contraseña", "Vacalouras");
        editor.commit();

        // Enlazamos el boton y las cajas de texto
        Button login = findViewById(R.id.login);
        EditText inputUser = findViewById(R.id.inputuser);
        EditText inputPassword = findViewById(R.id.inputPassword);

        // Declaramos un intent y un bundle para iniciar al siguiente activity pasandole el usuario y la contaseña
        Intent intent = new Intent(Login.this, MainActivity.class);
        Bundle bundle = new Bundle();

        // Declaramos un clicklistener
        login.setOnClickListener(view -> {

            // Guardamos los valores que el usuario ha puesto en las cajas de texto
            String user = inputUser.getText().toString();
            String password = inputPassword.getText().toString();

            // Si esos valores coinciden con los guardados en sharedpreferences iniciamos el segundo activity pasandole esos valores
            if ((user.equals(prefs.getString("Usuario", inputUser.getText().toString()))) && (password.equals(prefs.getString("Contraseña", inputPassword.getText().toString()))) ) {
                bundle.putString("Usuario" , user);
                bundle.putString("Contraseña", password);
                intent.putExtras(bundle);
                startActivity(intent);

            // Si no coinciden lanzamos una pequeña notificacion informativa.
            } else {
                Toast.makeText(this, "Los credenciales no son correctos", Toast.LENGTH_LONG).show();
            }
        });
    }
}