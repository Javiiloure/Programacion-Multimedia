package com.example.citas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected static final String nombreBD = "Citas";
    private final AdminBD admin = new AdminBD(MainActivity.this, nombreBD, null, 1);
    protected static SQLiteDatabase bd;
    protected static ArrayList<Cita> citas ;
    protected Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citas = new ArrayList<>();
        adaptador = new Adaptador(this, citas);

         bd = admin.getWritableDatabase();
        // bd.execSQL("insert into citas (titulo, fecha, hora, asunto) values ('Medico', '17/02/2023', '12:30', 'Revision de sinusitis cronica');");
        //bd.execSQL("insert into citas (titulo, fecha, hora, asunto) values ('Mecanico', '25/02/2023', '17:45', 'Cambio de aceite y de pastillas de freno');");
        //bd.execSQL("insert into citas (titulo, fecha, hora, asunto) values ('Peluqueria', '31/02/2023', '11:00', 'Corte de pelo y afeitado');");
        //bd.execSQL("insert into citas (titulo, fecha, hora, asunto) values ('Fisioterapeuta', '03/03/2023', '18:15', 'Revision escoliosis');");

        getCitas();
        ListView lista = findViewById(R.id.citas);
        lista.setAdapter(adaptador);

        final boolean[] longclick = {false};
        //Eliminamos una cita
        lista.setOnItemLongClickListener((adapterView, view, i, l) -> {
            longclick[0] = true;

            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setTitle("Importante");
            alerta.setMessage("¿ Eliminar esta cita ?");
            alerta.setCancelable(false);
            alerta.setPositiveButton("Confirmar", (alerta1, id) -> {
                Cita aux = citas.get(i);
                citas.remove(i);
                bd = admin.getWritableDatabase();
                bd.execSQL("delete from citas where id = " + aux.getId() + ";");
                adaptador.notifyDataSetChanged();
            });
            alerta.setNegativeButton("Denegar", (alerta2, id) -> longclick[0] = false);
            alerta.show();
            return false;
        });

        // Mostramos una cita
        lista.setOnItemClickListener(((adapterView, view, i, l) -> {
            if(longclick[0]) return;

            Cita aux = (Cita)  lista.getItemAtPosition(i);

            int id = aux.getId();
            String titulo = aux.getTitulo();
            String fecha = aux.getFecha();
            String hora = aux.getHora();
            String asunto = aux.getAsunto();

            Intent intent = new Intent(MainActivity.this, MostrarCita.class);
            intent.putExtra("id", id);
            intent.putExtra("titulo", titulo);
            intent.putExtra("fecha", fecha);
            intent.putExtra("hora", hora);
            intent.putExtra("asunto", asunto);

            startActivity(intent);
            finish();
        }));
    }

    public void getCitas() {
        bd = admin.getReadableDatabase();
        Cursor c = bd.rawQuery("Select * from citas", null);
        Cita cita;
        while(c.moveToNext()) {
            cita = new Cita(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            citas.add(cita);
        }
        c.close();
    }

    // Cargamos el menu
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Controlamos que se seleccione un item del menu
    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        switch (item.getItemId()) {
            case R.id.insertar:
                Intent intent = new Intent(MainActivity.this, InsertarCita.class);
                startActivity(intent);
                finish();
                break;
            case R.id.salir:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}