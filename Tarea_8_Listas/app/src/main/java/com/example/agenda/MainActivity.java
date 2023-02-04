package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    protected static ArrayList<Contacto> contactos;
    protected static Adaptador adapter;
    protected static ListView lista;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    private boolean isFABOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton menu = findViewById(R.id.menu);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);

        // Controlamos cuando se abre y cierra el menu
        menu.setOnClickListener(v -> {
            if(!isFABOpen) {
                mostrarMenu();
            } else {
                cerrarMenu();
            }
        });

        // Checkeamos el boton de ordenar
        FloatingActionButton ordenar = findViewById(R.id.aleatorio);
       ordenar.setOnClickListener(v -> ordenarAleatorio());

       // Creamos un ArrayList para guardar los contactos
        contactos = new ArrayList<>();
        contactos.add(new Contacto("Ivanchu","Ivan", "Cernadas", "Fragueiro", "ivancernadasfragueiro@gmail.com", "Redondela", 684366814));
        contactos.add(new Contacto("Xandre", "Alexandre", "Martinez", "Correia", "alexandremartinezcorreia@gmail.com", "Redondela", 631300462));
        contactos.add(new Contacto("Tony","Antonio", "Crespo", "Gómez", "antoniocrespogomez@gmail.com", "Redondela", 634999404));
        contactos.add(new Contacto("Tana","Aitana", "Rodriguez", "Vidal", "aitanarodriguezvidal@gmail.com", "Vigo Calle Zamora 54 5ºB", 695898614));
        contactos.add(new Contacto("El en-Nano", "Sergio", "Fernández", "Rodríguez", "sergiofernandezrodriguez@gmail.com", "Redondela", 618575371));
        contactos.add(new Contacto("Matusalen","Naila", "Álvarez", "Suárez", "nailaalvarezsuarez@gmail.com", "Vigo Calle SanXurxo Badía 104 9ºA", 604021489));
        contactos.add(new Contacto("Peter","Pedro", "Armada", "Rodriguez", "pedroarmadarodriguez@gmail.com", "Vigo Calle Ronda DonBosco 1 8ºA", 655304741));
        contactos.add(new Contacto("El falton", "David", "Dominguez", "Vasconcellos", "daviddominguezvasconcellos@gmail.com", "Vigo Plaza de la Industria 1 2ºC", 693762294));
        contactos.add(new Contacto("Yessi", "Yessica", "Rodriguez", "Gonzalez", "yessicarodriguezgonzalez@gmail.com", "Ponteareas", 677128055));
        contactos.add(new Contacto("CryptoBro","Oscar", "Boado", "San Martin", "oscarboadosanmartin@gmail.com", "Vigo Calle García Barbon 123 6ºE", 684297257));
        contactos.add(new Contacto("Migui", "Miguel", "Losada", "Teixeira", "miguellosadateixeira@gmail.com", "Tui", 646318169));
        contactos.add(new Contacto("Adan", "Adan", "Alonso", "Medin", "adanalonsomedin@gmail.com", "Vigo Avenida Garcia Barbon 189 5ºD", 647632286));
        contactos.add(new Contacto("Jabi","Javier", "Loureiro", "Pérez", "javier.loureiro52@gmail.com", "Vigo Calle Zaragoza 8 1ºA", 634616442));
        contactos.add(new Contacto("El hierbas","Daniel", "Rivas", "Minguez", "danielrivasminguez@gmail.com", "Vigo Calle Alfonso XIII 74 3ºB", 684523417));
        contactos.add(new Contacto("Lara Profe","Lara", "Ferreira", "Martinez", "laraferreiramartinez@gmail.com", "Vigo Calle Príncipe 36 4ºA", 698256384));

        lista = findViewById(R.id.lista);
        adapter = new Adaptador(this, contactos);
        lista.setAdapter(adapter);

        final boolean[] longClick = {false};

        // Eliminamos un contacto
        lista.setOnItemLongClickListener((adapterView, view, i, l) -> {
            longClick[0] = true;
            final int posicion=i;
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿ Elimina este teléfono ?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Confirmar", (dialogo11, id) -> {
                contactos.remove(posicion);
                adapter.notifyDataSetChanged();
                longClick[0] = false;
            });
            dialogo1.setNegativeButton("Cancelar", (dialogo112, id) -> longClick[0] = false);
            dialogo1.show();
            return false;
        });

        // Mostramos contacto seleccionado
        lista.setOnItemClickListener((adapterView, view, i, l) -> {
            if(longClick[0]) return;
            Contacto aux = (Contacto) lista.getItemAtPosition(i);
            String apodo = aux.getApodo();
            String nombre = aux.getNombre();
            String apellido1 = aux.getApellido_1();
            String apellido2 = aux.getApellido_2();
            String telefono = String.valueOf(aux.getTelefono());
            String email = aux.getEmail();
            String direccion = aux.getDireccion();

            Intent intent = new Intent(MainActivity.this, MostrarContacto.class);
            intent.putExtra("apodo", apodo);
            intent.putExtra("nombre", nombre);
            intent.putExtra("apellido1", apellido1);
            intent.putExtra("apellido2", apellido2);
            intent.putExtra("telefono", telefono);
            intent.putExtra("email", email);
            intent.putExtra("direccion", direccion);

            startActivity(intent);
        });


    }

    public void ordenarAleatorio(){
        Collections.shuffle(contactos);
        lista.setAdapter(adapter);
    }

    public void mostrarMenu() {
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
        fab1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AnhadirContacto.class)));
        fab2.setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_SETTINGS)));
        fab3.setOnClickListener(v -> finish());
        lista.setEnabled(false);
    }

    public void cerrarMenu() {
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
        lista.setEnabled(true);
    }
}