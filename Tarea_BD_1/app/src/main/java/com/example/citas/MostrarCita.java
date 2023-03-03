package com.example.citas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MostrarCita extends AppCompatActivity {

    private final AdminBD admin = new AdminBD(MostrarCita.this, MainActivity.nombreBD, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cita);


        FloatingActionButton guardar = findViewById(R.id.guardar);
        FloatingActionButton atras = findViewById(R.id.atras);

        EditText input_titulo = findViewById(R.id.titulo);
        TextView input_fecha = findViewById(R.id.fecha);
        TextView input_hora = findViewById(R.id.hora);
        EditText input_asunto = findViewById(R.id.asunto);
        CalendarView calendario = findViewById(R.id.calendarView);
        Button aceptar_fecha = findViewById(R.id.aceptar_fecha);
        calendario.setVisibility(View.INVISIBLE);
        aceptar_fecha.setVisibility(View.INVISIBLE);

        Bundle extras = getIntent().getExtras();

        int id = extras.getInt("id");
        String titulo = extras.getString("titulo");
        String fecha = extras.getString("fecha");
        String hora = extras.getString("hora");
        String asunto = extras.getString("asunto");

        input_titulo.setText(titulo);
        input_fecha.setText(fecha);
        input_hora.setText(hora);
        input_asunto.setText(asunto);

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

        // Mostramos un TimePickerDialog al clickar en hora
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
        atras.setOnClickListener(view -> {
            finish();
        });

        // Actualizamos la cita con los nuevos datos al presionar guardar
        guardar.setOnClickListener(view -> {
            MainActivity.bd = admin.getWritableDatabase();
            ContentValues cv = new ContentValues();

            // Guardamos en content values los nuevos atributos y actualizamos la base de datos
            cv.put("titulo", input_titulo.getText().toString());
            cv.put("fecha", input_fecha.getText().toString());
            cv.put("hora", input_hora.getText().toString());
            cv.put("asunto", input_asunto.getText().toString());
            MainActivity.bd.update("citas", cv, "id =?", new String[]{String.valueOf(id)});

            // Buscamos en el arraylist de citas la cita y actualizamos sus atributos
            for(int i = 0; i < MainActivity.citas.size(); i++) {
                if(MainActivity.citas.get(i).getId() == id) {
                    MainActivity.citas.get(i).setTitulo(input_titulo.getText().toString());
                    MainActivity.citas.get(i).setFecha(input_fecha.getText().toString());
                    MainActivity.citas.get(i).setHora(input_hora.getText().toString());
                    MainActivity.citas.get(i).setAsunto(input_asunto.getText().toString());
                    break;
                }
            }
            finish();
        });
    }
}