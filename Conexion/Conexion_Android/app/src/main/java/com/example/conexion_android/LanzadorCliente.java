package com.example.conexion_android;

import android.util.Log;

import java.io.IOException;

public class LanzadorCliente {

	public static void main(String mensaje) throws IOException {

		//Se crea el cliente
		Cliente cli = new Cliente();

		//Se inicia el cliente
		Log.i("TCP", "Iniciando cliente\n");
		cli.startClient(mensaje);
	}
}
