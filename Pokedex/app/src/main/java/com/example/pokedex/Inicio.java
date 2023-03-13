package com.example.pokedex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity {

    //Declaración de elementos
    protected static final String nombreBD = "Pokemon";
    public AdminBD admin = null;
    protected SQLiteDatabase bd;

    ImageView pokedex, pokemon, evolucion, selector1, selector2, pokimon, pokedex2;
    ImageButton up, down, der, izq, rojo, azul, negro;
    TextView nombre, atak1, atak2, tipo1, tipo2, testo;

    public ArrayList<Pokemon> pokemons;
    private int count = 0;
    int luz = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Asociación de los elementos con el layout
        getSupportActionBar().hide();

        pokemons = new ArrayList<>();
        admin = new AdminBD(Inicio.this, nombreBD, null, 1);
        bd = admin.getWritableDatabase();
        pokedex = findViewById(R.id.pokedex);
        pokedex2 = findViewById(R.id.pokedex2);

        pokemon = findViewById(R.id.pokemon);
        evolucion = findViewById(R.id.evolucion);

        pokimon = findViewById(R.id.pokimon);
        testo = findViewById(R.id.testo);

        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        der = findViewById(R.id.der);
        izq = findViewById(R.id.izq);
        rojo = findViewById(R.id.btnrojo);
        azul = findViewById(R.id.btnazul);
        negro = findViewById(R.id.btnnegro);
        selector1 = findViewById(R.id.selector1);
        selector2 = findViewById(R.id.selector2);

        nombre = findViewById(R.id.nombre);
        atak1 = findViewById(R.id.ataque1);
        atak2 = findViewById(R.id.ataque2);
        tipo1 = findViewById(R.id.tipo1);
        tipo2 = findViewById(R.id.tipo2);

        pokemon.setImageResource(R.drawable.bulbasaur);
        nombre.setText("Bulbasur");
        atak1.setText("Látigo Cepa");
        atak2.setText("Bomba Lodo");
        tipo1.setText("Planta");
        tipo2.setText("Veneno");

        //Sonido de click
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.sonidomp3corto);

        //Click que abre la pokedex
        pokedex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokedex2.setVisibility(View.GONE);
                pokedex.setImageResource(R.drawable.pokedexpantallaluzroja);
                pokemon.setImageResource(R.drawable.bulbasaur);
                count = 0;
                luz = 1;
                evolucion.setImageResource(fotos[count + 1]);
                pokimon.setImageResource(fotos[count]);
                nombre.setText("Bulbasur");
                atak1.setText("Látigo Cepa");
                atak2.setText("Bomba Lodo");
                tipo1.setText("Planta");
                tipo2.setText("Veneno");
                pokemon.setVisibility(View.VISIBLE);
                nombre.setVisibility(View.VISIBLE);
                tipo1.setVisibility(View.VISIBLE);
                tipo2.setVisibility(View.VISIBLE);
                selector1.setVisibility(View.VISIBLE);
                selector2.setVisibility(View.INVISIBLE);
                atak1.setTextColor(Color.WHITE);
                atak2.setTextColor(Color.BLACK);
                pokimon.setVisibility(View.INVISIBLE);
                testo.setVisibility(View.INVISIBLE);
            }
        });

        //Botón flecha arriba
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selector1.setVisibility(View.VISIBLE);
                selector2.setVisibility(View.INVISIBLE);

                //Selecctor del ataque
                atak1.setTextColor(Color.WHITE);
                atak2.setTextColor(Color.BLACK);
                sonido.start();
            }
        });

        //Botón flecha abajo
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selector1.setVisibility(View.INVISIBLE);
                selector2.setVisibility(View.VISIBLE);

                //Selecctor del ataque
                atak1.setTextColor(Color.BLACK);
                atak2.setTextColor(Color.WHITE);
                sonido.start();
            }
        });

        //Pasar Pokemon a la derecha
        der.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cambiar la luz superior cuando cambias de pokemon
                luz++;

                if(luz == 4){
                    luz = 1;
                }
                if(luz == 1){
                    pokedex.setImageResource(R.drawable.pokedexpantallaluzroja);
                }else if(luz == 2){
                    pokedex.setImageResource(R.drawable.pokedexpantallaluzamarilla);
                }else if(luz == 3){
                    pokedex.setImageResource(R.drawable.pokedexpantallaluzverde);
                }

                if(count == 60);
                else {
                    count++;
                }
                sonido.start();
                String nombre_pokemon = pokemons.get(count).getNombre();
                nombre.setText(nombre_pokemon);
                pokemon.setImageResource(fotos[count]);
                pokimon.setImageResource(fotos[count]);

                // Si el pokemon no tiene evolucion se vacia la imagen de evolucion
                if(pokemons.get(count).getEvolucion() == 0) {
                    evolucion.setImageResource(0);
                } else {
                    evolucion.setImageResource(fotos[count + 1]);
                }
                setAtaque();
                tipoPokemon();
            }
        });

        //Pasar Pokemon a la izquierda
        izq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cambiar la luz superior cuando cambias de pokemon
                luz--;

                if(luz == 0){
                    luz = 3;
                }

                if(luz == 1){
                    pokedex.setImageResource(R.drawable.pokedexpantallaluzroja);
                }else if(luz == 2){
                    pokedex.setImageResource(R.drawable.pokedexpantallaluzamarilla);
                }else if(luz == 3){
                    pokedex.setImageResource(R.drawable.pokedexpantallaluzverde);
                }

                sonido.start();
                if(count == 0);
                else {
                    count--;
                }
                String nombre_pokemon = pokemons.get(count).getNombre();
                nombre.setText(nombre_pokemon);
                pokemon.setImageResource(fotos[count]);
                pokimon.setImageResource(fotos[count]);

                // Si el pokemon no tiene evolucion se vacia la imagen de evolucion
                if(pokemons.get(count).getEvolucion() == 0) {
                    evolucion.setImageResource(0);
                } else {
                    evolucion.setImageResource(fotos[count + 1]);
                }
                setAtaque();
                tipoPokemon();
            }
        });

        //Botón que cambia la vista del pokemon en la pantalla
        azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokimon.setVisibility(View.VISIBLE);
                testo.setVisibility(View.VISIBLE);
                pokemon.setVisibility(View.GONE);
                nombre.setVisibility(View.GONE);
                tipo1.setVisibility(View.GONE);
                tipo2.setVisibility(View.GONE);


                sonido.start();
            }
        });

        //Botón de cerrar la pokedex
        rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokedex2.setVisibility(View.VISIBLE);
                sonido.start();
            }
        });

        //Botón negro
        negro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokimon.setVisibility(View.INVISIBLE);
                testo.setVisibility(View.INVISIBLE);
                pokemon.setVisibility(View.VISIBLE);
                nombre.setVisibility(View.VISIBLE);
                tipo1.setVisibility(View.VISIBLE);
                tipo2.setVisibility(View.VISIBLE);
                sonido.start();
            }
        });

        getPokemons();
    }

    //Método para recoger los pokemons
    public void getPokemons() {
        bd = admin.getReadableDatabase();
        Cursor c = bd.rawQuery("Select * from Pokemon", null);
        Pokemon pokemon;
        while (c.moveToNext()) {
            pokemon = new Pokemon(c.getInt(6), c.getString(0), c.getInt(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
            pokemons.add(pokemon);
        }
        c.close();
    }

    //Setear los ataques en el TextView desde la bd
    public void setAtaque(){
        bd = admin.getReadableDatabase();
        Cursor c = bd.rawQuery("select nombre from Ataque a where a.Id = (select Ataque from Pokemon where Pokemon.Id = " + pokemons.get(count).getId() + ")", null);
        Cursor c2 = bd.rawQuery("select nombre from Ataque a where a.Id = (select Ataque_2 from Pokemon where Pokemon.Id = " + pokemons.get(count).getId() + ")", null);

        if(c.moveToFirst()){

            atak1.setText(c.getString(0));

        }
        if(c2.moveToFirst()){
                atak2.setText(c2.getString(0));
        }
    }

    //Setear el tipo de pokemon desde la bd
    public void tipoPokemon(){
        bd = admin.getReadableDatabase();
        Cursor c = bd.rawQuery("select nombre from Tipo t where t.Id = (select tipo from Pokemon p where p.id = " + pokemons.get(count).getId() + ")", null);
        Cursor c2 = bd.rawQuery("select nombre from Tipo t where t.Id = (select tipo_2 from Pokemon p where p.id = " + pokemons.get(count).getId() + ")", null);

        c.moveToFirst();
        tipo1.setText(c.getString(0));

        c2.moveToFirst();

        //Si el pokemon no tiene 2do tipo se pone en blanco
        try {
            c2.isNull(0);
            tipo2.setText(c2.getString(0));
        }catch(CursorIndexOutOfBoundsException e) {
                tipo2.setText("---");
        }


    }

    //Array de fotos que guarda todas las fotos de los pokemons
    private int[] fotos = {R.drawable.bulbasaur, R.drawable.ivysaur, R.drawable.venusaur,
            R.drawable.charmander, R.drawable.charmeleon, R.drawable.charizard,
            R.drawable.squirtle, R.drawable.wartortle, R.drawable.blastoise,
            R.drawable.chikorita, R.drawable.bayleef, R.drawable.meganium,
            R.drawable.cyndaquil, R.drawable.quilava, R.drawable.typhlosion,
            R.drawable.totodile, R.drawable.croconaw, R.drawable.feraligart,
            R.drawable.treecko, R.drawable.grovyle, R.drawable.sceptile,
            R.drawable.torchic, R.drawable.combusken, R.drawable.blaziken,
            R.drawable.mudkip, R.drawable.marshtomp, R.drawable.swampert,
            R.drawable.turtwig, R.drawable.grotle, R.drawable.torterra,
            R.drawable.chimchar, R.drawable.monferno, R.drawable.infernape,
            R.drawable.piplup, R.drawable.prinplup, R.drawable.empoleon,
            R.drawable.caterpie, R.drawable.metapod, R.drawable.butterfree,
            R.drawable.weedle, R.drawable.kakuna, R.drawable.beedrill,
            R.drawable.pidgey, R.drawable.pidgeotto, R.drawable.pidgeot,
            R.drawable.beldum, R.drawable.metang, R.drawable.metagross,
            R.drawable.onix, R.drawable.steelix,
            R.drawable.pichu, R.drawable.pikachu, R.drawable.raichu,
            R.drawable.gastly, R.drawable.haunter, R.drawable.gengar,
            R.drawable.glaceon,
            R.drawable.absol,
            R.drawable.dratini, R.drawable.dragonair, R.drawable.dragonite};
}