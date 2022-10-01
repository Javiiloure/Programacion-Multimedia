package com.example.cambiopantalla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button ok = (Button) findViewById(R.id.ok);
        Button volver = (Button) findViewById(R.id.volver);
        EditText inputNombre = (EditText) findViewById(R.id.InputNombre);
        EditText inputApellidos = (EditText) findViewById(R.id.InputApellido);

        String nombre = inputNombre.getText().toString();
        String apellidos = inputApellidos.getText().toString();

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}