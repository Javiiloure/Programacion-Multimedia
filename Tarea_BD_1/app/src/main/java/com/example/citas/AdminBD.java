package com.example.citas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {

    public AdminBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table usuarios(id integer primary key autoincrement, usuario text, contraseña text unique)");
        db.execSQL("Create table citas(id integer primary key autoincrement, titulo text, fecha text, hora text, asunto text, usuario integer not null, foreign key (usuario) references usuarios(id) on delete cascade on update cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}