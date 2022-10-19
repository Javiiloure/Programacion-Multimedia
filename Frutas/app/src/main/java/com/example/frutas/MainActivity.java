package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mostrar = findViewById(R.id.mostrar);
        ImageView imagen = findViewById(R.id.imagen);
        EditText opcion = findViewById(R.id.opcion);

       mostrar.setOnClickListener(view -> {
           input = opcion.getText().toString();
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
