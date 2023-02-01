package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private ArrayAdapter adapter;
    private ListView lista;
    private Button ordenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<>();

        contactos.add(new Contacto("Ivan", "Cernadas", "Fragueiro", "ivancernadasfragueiro@gmail.com", "Redondela", 684366814));
        contactos.add(new Contacto("Alexandre", "Martinez", "Correia", "alexandremartinezcorreia@gmail.com", "Redondela", 631300462));
        contactos.add(new Contacto("Antonio", "Crespo", "Gómez", "antoniocrespogomez@gmail.com", "Redondela", 634999404));
        contactos.add(new Contacto("Aitana", "Rodriguez", "Vidal", "aitanarodriguezvidal@gmail.com", "Vigo Calle Zamora 54 5ºB", 695898614));
        contactos.add(new Contacto("Sergio", "Fernández", "Rodríguez", "sergiofernandezrodriguez@gmail.com", "Redondela", 618575371));
        contactos.add(new Contacto("Naila", "Álvarez", "Suárez", "nailaalvarezsuarez@gmail.com", "Vigo Calle SanXurxo Badía 104 9ºA", 604021489));
        contactos.add(new Contacto("Pedro", "Armada", "Rodriguez", "pedroarmadarodriguez@gmail.com", "Vigo Calle Ronda DonBosco 1 8ºA", 655304741));
        contactos.add(new Contacto("Oscar", "Boado", "San Martin", "oscarboadosanmartin@gmail.com", "Vigo Calle García Barbon 123 6ºE", 684297257));
        contactos.add(new Contacto("Javier", "Loureiro", "Pérez", "javier.loureiro52@gmail.com", "Vigo Calle Zaragoza 8 1ºA", 634616442));
        contactos.add(new Contacto("Daniel", "Rivas", "Minguez", "danielrivasminguez@gmail.com", "Vigo Calle Alfonso XIII 74 3ºB", 684523417));
        contactos.add(new Contacto("Lara", "Ferreira", "Martinez", "laraferreiramartinez@gmail.com", "Vigo Calle Príncipe 36 4ºA", 698256384));

        ordenar = findViewById(R.id.ordenar);
        lista = findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactos);
        lista.setAdapter(adapter);
    }
}