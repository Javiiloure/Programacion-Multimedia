package com.example.conexion_android;

import android.os.StrictMode;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {
	public Cliente() throws IOException {
		// Se usa el constructor para cliente de Conexion
		super("cliente");
	}

	// Metodo para iniciar el cliente
	public void startClient(String mensaje) {
		try {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
			// Flujo de datos hacia el servidor
			salidaServidor = new DataOutputStream(cs.getOutputStream());

			// Se escribe en el servidor usando su flujo de datos
			Log.i("TCP", "Enviando mensaje");
			salidaServidor.writeUTF(mensaje);

			// Fin de la conexion
			cs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
