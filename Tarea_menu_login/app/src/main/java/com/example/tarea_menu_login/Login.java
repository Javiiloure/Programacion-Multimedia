package com.example.tarea_menu_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", "modificado@email.com");
        editor.putString("nombre", "Prueba");
        editor.commit();

        String user;
        String password;
        Intent intent = new Intent(Login.this, MainActivity.class);
        EditText inputUser = findViewById(R.id.inputUser);
        EditText inputPassword = findViewById(R.id.inputPassword);
        Button login = findViewById(R.id.login);
        user = inputUser.getText().toString();
        password = inputPassword.getText().toString();

        login.setOnClickListener(view -> startActivity(intent));
    }
}