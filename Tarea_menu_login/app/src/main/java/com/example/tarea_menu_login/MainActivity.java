package com.example.tarea_menu_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enlazamos los textviews del activity
        TextView user = findViewById(R.id.user);
        TextView password = findViewById(R.id.password);

        // Tomamos los valores que llegan al activity a traves del intent
        String usuario = getIntent().getExtras().getString("Usuario");
        String contraseña = getIntent().getExtras().getString("Contraseña");

        // Declaramos un string aux que tomara tantos * como longitud tenga la contraseña
        String aux = "";
        for (int i = 0; i < contraseña.length(); i++) {
            aux += '*';
        }

        // Colocamos en el layout los valores de usuario y la contraseña con *
        user.setText(usuario);
        password.setText(aux);
    }

    // Mostramos un menu desplegable en la appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Gestiamos las distintas opciones del menu desplegable
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, Login.class);
        int id = item.getItemId();
        switch (id) {
            case R.id.ajustes:
                Toast.makeText(this, "Ha seleccionado Ajustes", Toast.LENGTH_LONG).show();
                break;
            case R.id.login:
                startActivity(intent);
        }
        return true;
    }
}