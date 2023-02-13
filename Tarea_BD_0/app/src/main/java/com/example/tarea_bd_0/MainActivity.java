package com.example.tarea_bd_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.database.Cursor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nombreText, apellidoText, direccionText, telefonoText;
    private ListView lista;
    private final String nombreBD = "Personas";
    protected AdminBD admin = new AdminBD(MainActivity.this, nombreBD, null, 1);
    protected SQLiteDatabase bd;
    protected ArrayList<Persona> personas = new ArrayList<>();
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = admin.getReadableDatabase();
        getPersonas();

        nombreText = findViewById(R.id.nombre);
        apellidoText = findViewById(R.id.apellido);
        telefonoText = findViewById(R.id.telefono);
        direccionText = findViewById(R.id.direccion);
        Button guardar = findViewById(R.id.guardar);
        lista = findViewById(R.id.Lista);
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, personas);
        lista.setAdapter(adaptador);
        guardar.setOnClickListener(this::alta);
    }

    public void getPersonas() {
        Cursor c = bd.rawQuery("Select * from personas", null);
            while(c.moveToNext()) {
                Persona persona = new Persona(c.getString(1), c.getString(2), c.getString(3), c.getString(4));
                personas.add(persona);
            }
    }

    public void alta(View v) {
        try {
            bd = admin.getWritableDatabase();
            if (bd != null) {
                String nombre = nombreText.getText().toString();
                String apellido = apellidoText.getText().toString();
                String direccion = direccionText.getText().toString();
                String telefono = telefonoText.getText().toString();
                ContentValues registro = new ContentValues();

                registro.put("nombre", nombre);
                registro.put("apellido", apellido);
                registro.put("direccion", direccion);
                registro.put("telefono", telefono);

                bd.insert("personas", null, registro);
                bd.close();

                Persona persona = new Persona(nombre, apellido, direccion, telefono);
                personas.add(persona);
                lista.setAdapter(adaptador);

                nombreText.setText("");
                apellidoText.setText("");
                direccionText.setText("");
                telefonoText.setText("");
                Toast.makeText(MainActivity.this, "Se grabaron los datos del cliente", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Base de datos no creada", Toast.LENGTH_SHORT).show();
        } catch (SQLiteException ex) {
            bd = admin.getReadableDatabase();
            Toast.makeText(this, "No se puede escribir la Base de Datos", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }
}