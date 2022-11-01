package com.example.tarea_menu_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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