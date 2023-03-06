package com.example.conexion_android;

import android.util.Log;

import java.io.IOException;

public class LanzadorServer {

	public static String main() throws IOException {
		// Se crea el servidor
		Servidor serv = new Servidor();
		Log.i("TCP","Iniciando servidor\n");

		// Se inicia el servidor
		String mensaje = serv.startServer();
		return mensaje;
	}
}
