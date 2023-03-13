package com.example.pokedex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {
    public AdminBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Pokemon (Nombre TEXT NOT NULL UNIQUE, Evolucion INTEGER UNIQUE, Ataque TEXT NOT NULL, Ataque_2 TEXT NOT NULL, Tipo TEXT NOT NULL, Tipo_2 TEXT, " +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY (Evolucion) REFERENCES Pokemon(Id), FOREIGN KEY (Ataque) REFERENCES Ataque(Id),\n" +
                "\tFOREIGN KEY (Ataque_2) REFERENCES Ataque(Id), FOREIGN KEY (Tipo) REFERENCES Tipo(Id), FOREIGN KEY (Tipo_2) REFERENCES Tipo(Id))");

        db.execSQL("CREATE TABLE Ataque (Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT UNIQUE)");
        db.execSQL("CREATE TABLE Tipo (Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT UNIQUE)");
        db.execSQL("INSERT INTO Tipo (Nombre) values (\"Bicho\"),(\"Dragon\"),(\"Electrico\"),(\"Lucha\"),(\"Fuego\"),(\"Volador\"),(\"Fantasma\"),(\"Planta\"),(\"Hielo\"),(\"Tierra\")," +
                "(\"Normal\"),(\"Veneno\"),(\"Psiquico\"),(\"Roca\"),(\"Acero\"),(\"Agua\"), (\"Siniestro\")");

        db.execSQL("INSERT INTO Pokemon (Nombre, Evolucion, Ataque, Ataque_2, Tipo, Tipo_2) VALUES\n" +
                "(\"Bulbasur\", 2, 5, 16, 8, 12),(\"Ivysaur\", 3, 17,13, 8,12),(\"Venusaur\", null, 7, 13,8, 12), \n"+
                "(\"Charmander\", 5, 1, 4, 5, null),(\"Charmaleon\", 6, 2, 1, 5, null),(\"Charizard\", null, 1, 43, 5, 6), " +
                "(\"Squirtle\", 8, 9, 12, 16, null),(\"Wartortle\", 9, 9, 11, 16, null),(\"Blastoise\", null, 12, 10, 16, null),\n" +
                "(\"Chikorita\", 11, 6, 7, 8, null),(\"Bayleef\", 12, 5, 6, 8, null),(\"Meganium\", null, 7, 8, 8, null), " +
                "(\"Cyndaquill\", 14, 2, 4, 5, null),(\"Quilava\", 15, 3, 4, 5, null),(\"Typhlosion\", null, 1, 2, 5, null),\n" +
                "(\"Totodile\", 17, 9, 10, 16, null),(\"Croconaw\", 18, 10, 12, 16, null),(\"Feraligart\", null, 11, 10, 16, null), " +
                "(\"Treecko\", 20, 5, 6, 8, null),(\"Grovyle\", 21, 5, 7, 8, null),(\"Sceptile\", null, 8, 6, 8, null),\n" +
                "(\"Torchic\", 23, 2, 4, 5, null),(\"Combusken\", 24, 3, 54, 5, 4),(\"Blaziken\", null, 1, 53, 5, 4), " +
                "(\"Mudkip\", 26, 9, 12, 16, null),(\"Marshtomp\", 27, 10, 27, 16, 10),(\"Swampert\", null, 11, 25, 16,10),\n" +
                "(\"Turtwig\", 29, 5, 6, 8, null),(\"Grotle\", 30, 4, 8, 8, null), (\"Torterra\", null, 7, 26, 8, 10), " +
                "(\"Chimchar\", 32, 2, 4, 5, null),(\"Monferno\", 33, 3, 56, 5, 4),(\"Infernape\", null, 1, 53, 5, 4), " +
                "(\"Piplup\", 35, 9, 12, 16, null),(\"Prinplup\", 36, 9, 10, 16, null),(\"Empolepon\", null, 11, 36, 16, 15),\n" +
                "(\"Caterpie\", 38, 49, 50, 1, null),(\"Metapod\", 39, 49, 51, 1, null),(\"Buterfree\", null, 52, 43, 1, 6), " +
                "(\"Weedle\", 41, 50, 13, 1, 12),(\"Kakuna\", 42, 49, 14, 1, 12),(\"Beedrill\", null, 52, 15, 1, 12),\n" +
                "(\"Pidgey\", 44, 20, 44, 11, 6),(\"Pidgeotto\", 45, 19, 44, 11, 6),(\"Pidgeot\", null, 19, 41, 11, 6), " +
                "(\"Beldum\", 47, 33, 63, 15, 13), (\"Metang\", 48, 65, 62, 15, 13),(\"Metagross\", null, 35, 64, 15, 13), " +
                "(\"Onix\", 50, 58, 28, 14, 10),(\"Steelix\", null, 34, 25, 15, 10),\n" +
                "(\"Pichu\", 52, 39, 38, 3, null),(\"Pikachu\", 53, 37, 38, 3, null),(\"Raichu\", null, 40, 38, 3, null), " +
                "(\"Gastly\", 55, 29, 13, 7, 12), (\"Haunter\", 56, 32, 15, 7, 12), (\"Gengar\", null, 30, 14, 7, 12),\n" +
                "(\"Glaceon\", null, 22, 24, 9, null), " +
                "(\"Absol\", null, 65, 68, 17, null), " +
                "(\"Dratini\", 60, 45, 48, 2, null), (\"Dragonair\", 61, 45, 47, 2, null),(\"Dragonite\", null, 46, 44, 2, 6);");

        db.execSQL("INSERT INTO Ataque (Nombre) VALUES (\"Llamarada\"),(\"Ascuas\"),(\"Lanzallamas\"),(\"Colmillo Igneo\"),\n" +
                "(\"Latigo Cepa\"),(\"Hoja Afilada\"),(\"Bomba Germen\"),(\"Paralizador\"),\n" +
                "(\"Pistola Agua\"), (\"Torbellino\"), (\"Hidrobomba\"), (\"Salpicadura\"),\n" +
                "(\"Polvo Veneno\"),(\"Cola veneno\"),(\"Gas Venenoso\"),(\"Bomba Lodo\"),\n" +
                "(\"Doble Filo\"),(\"Atadura\"),(\"Ataque Rapido\"),(\"Placaje\"),\n" +
                "(\"Puño Hielo\"), (\"Alud\"), (\"Ventisca\"), (\"Congelar\"),\n" +
                "(\"Terremoto\"),(\"Ataque Arena\"),(\"Terratemblor\"),(\"Excavar\"),\n" +
                "(\"Bola Sombra\"),(\"Infortunio\"),(\"Lengüetazo\"),(\"Garra Umbría\"),\n" +
                "(\"Puño Bala\"),(\"Cola Ferrea\"),(\"Garra Metal\"),(\"Ala de Acero\"),\n" +
                "(\"Placaje Electrico\"),(\"Trueno\"),(\"Bola Voltio\"),(\"Alto Voltaje\"),\n" +
                "(\"Vuelo\"),(\"Despejar\"),(\"Tajo aéreo\"),(\"Tornado\"),\n" +
                "(\"Pulso Dragon\"),(\"Garra Dragon\"),(\"Ciclon\"),(\"Enfado\"),\n" +
                "(\"Chupavidas\"),(\"Picadura\"),(\"Zumbido\"),(\"Tijera X\"),\n" +
                "(\"A Bocajarro\"),(\"Desquite\"),(\"Golpe Karate\"),(\"Ultrapuño\"),\n" +
                "(\"Avalancha\"),(\"Lanzarrocas\"),(\"Trampa Rocas\"),(\"Pedrada\"),\n" +
                "(\"Cabezazo Zen\"),(\"Confusion\"),(\"Hipnosis\"),(\"Psicorrayo\"),\n" +
                "(\"Mordisco\"),(\"Mofa\"),(\"Vendetta\"),(\"Tajo Umbrío\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}