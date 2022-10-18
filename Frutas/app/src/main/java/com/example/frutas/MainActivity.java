package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button mostrar = findViewById(R.id.mostrar);
    ImageView imagen = findViewById(R.id.imagen);
    EditText opcion = findViewById(R.id.opcion);
    String input = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        input = opcion.getText().toString();

        mostrar.setOnClickListener(view -> {
            if(input.equals("a")) {
                imagen.setImageResource(R.drawable.aguacate);
            }
            if(input.equals("c")) {
                imagen.setImageResource(R.drawable.cerezas);
            }
            if(input.equals("m")) {
                imagen.setImageResource(R.drawable.golden);
            }
        });

    }
}
