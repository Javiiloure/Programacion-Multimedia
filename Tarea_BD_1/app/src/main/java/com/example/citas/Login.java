package com.example.citas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    protected static final String nombreBD = "Citas";
    private final AdminBD admin = new AdminBD(Login.this, nombreBD, null, 1);
    protected static SQLiteDatabase bd;
    protected ArrayList<Usuario> usuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText input_usuario = findViewById(R.id.input_usuario);
        EditText input_contraseña = findViewById(R.id.input_contraseña);
        ImageView login = findViewById(R.id.login);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        bd = admin.getWritableDatabase();
        //bd.execSQL("insert into usuarios(usuario, contraseña) values ('prueba', 'prueba')");
        //bd.execSQL("insert into usuarios(usuario, contraseña) values ('prueba2', 'prueba2')");

        getUsuarios();
        // Comprobamos que existe el usuario introducido al clickar en login
        login.setOnClickListener(v -> {
            for(int i = 0; i < usuarios.size(); i++) {
                // Guardamos el usuario en las sharedPreferences e iniciamos MainActivity
                if(usuarios.get(i).getUsuario().equals(input_usuario.getText().toString()) && usuarios.get(i).getContraseña().equals(input_contraseña.getText().toString())) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    myEdit.putInt("usuario", usuarios.get(i).getId());
                    myEdit.commit();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Obtenemos los usuarios de la BD y los guardamos en el arraylist
    public void getUsuarios(){
        bd = admin.getReadableDatabase();
        Cursor c = bd.rawQuery("Select * from Usuarios", null);
        Usuario aux;
        while(c.moveToNext()){
            aux = new Usuario(c.getInt(0), c.getString(1), c.getString(2));
            usuarios.add(aux);
        }
    }
}