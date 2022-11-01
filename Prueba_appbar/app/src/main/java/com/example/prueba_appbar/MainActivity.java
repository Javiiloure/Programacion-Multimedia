package com.example.prueba_appbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
        int id = item.getItemId();
        switch (id){
            case R.id.ajustes:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();

                break;
            case R.id.interfaz:
                Toast.makeText(this, "Interfaz", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sonido:
                Toast.makeText(this, "Sonido", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ayuda:
                Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}