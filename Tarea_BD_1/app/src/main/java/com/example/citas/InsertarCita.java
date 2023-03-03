package com.example.citas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InsertarCita extends AppCompatActivity {

    private final AdminBD admin = new AdminBD(InsertarCita.this, MainActivity.nombreBD, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_cita);

        FloatingActionButton atras = findViewById(R.id.atras);
        FloatingActionButton guardar = findViewById(R.id.guardar);
        ImageView imagen = findViewById(R.id.imagen);
        EditText input_titulo = findViewById(R.id.titulo);
        TextView input_fecha = findViewById(R.id.fecha);
        TextView input_hora = findViewById(R.id.hora);
        EditText input_asunto = findViewById(R.id.asunto);
        CalendarView calendario = findViewById(R.id.calendarView2);
        Button aceptar_fecha = findViewById(R.id.aceptar_fecha);
        calendario.setVisibility(View.INVISIBLE);
        aceptar_fecha.setVisibility(View.INVISIBLE);

        // Mostramos el calendario al clickar en la fecha
        input_fecha.setOnClickListener(v -> {
            input_fecha.setVisibility(View.INVISIBLE);
            input_hora.setVisibility(View.INVISIBLE);
            input_asunto.setVisibility(View.INVISIBLE);
            calendario.setVisibility(View.VISIBLE);
            aceptar_fecha.setVisibility(View.VISIBLE);
            calendario.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
                month++;
                input_fecha.setText(dayOfMonth + "/" + month + "/" + year);
            });
        });
        aceptar_fecha.setOnClickListener(v -> {
            calendario.setVisibility(View.INVISIBLE);
            aceptar_fecha.setVisibility(View.INVISIBLE);
            input_fecha.setVisibility(View.VISIBLE);
            input_hora.setVisibility(View.VISIBLE);
            input_asunto.setVisibility(View.VISIBLE);
        });

        // Mostramos el selector de hora
        input_hora.setOnClickListener(v -> {
            TimePickerDialog d = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    input_hora.setText(hourOfDay + ":" + minute);
                }
            },10, 30, true);
            d.show();
        });


        // Volvemos al activity principal
        atras.setOnClickListener(v -> finish());

        // Guardamos la nueva cita
        guardar.setOnClickListener(v -> {

            int id = MainActivity.citas.get(MainActivity.citas.size() - 1).getId() + 1;
            String titulo = input_titulo.getText().toString();
            String fecha = input_fecha.getText().toString();
            String hora = input_hora.getText().toString();
            String asunto = input_asunto.getText().toString();

            // Creamos un nuevo objeto de la clase Cita y lo guardamos el el arraylist
            Cita aux = new Cita(id, titulo, fecha, hora, asunto);
            MainActivity.citas.add(aux);

            // Añadimos la nueva cita a la base de datos
            MainActivity.bd = admin.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            values.put("fecha", fecha);
            values.put("hora", hora);
            values.put("asunto", asunto);
            values.put("usuario", getIntent().getExtras().getInt("usuario"));
            MainActivity.bd.insert("citas", null, values);
            MainActivity.adaptador.notifyDataSetChanged();
            finish();
        });
    }
}