package com.example.conexion_android;

import android.os.StrictMode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {

	private final int PUERTO = 1234; // Puerto para la conexion
	private final String HOST = "192.168.1.105"; // Host para la conexion
	protected String mensajeServidor; // Mensajes entrantes (recibidos) en el servidor
	protected ServerSocket ss; // Socket del servidor
	protected Socket cs; // Socket del cliente
	protected DataOutputStream salidaServidor, salidaCliente; // Flujo de datos de salida

	// Constructor
	public Conexion(String tipo) throws IOException {
		if (tipo.equalsIgnoreCase("servidor")) {

			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
			// Se crea el socket para el servidor en puerto 1234
			ss = new ServerSocket(PUERTO);

			// Socket para el cliente
			cs = new Socket();
		} else {

			// Socket para el cliente en localhost en puerto 1234
			cs = new Socket(HOST, PUERTO);
		}
	}
}
