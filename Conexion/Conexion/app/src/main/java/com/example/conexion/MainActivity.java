package com.example.conexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;

import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    //private static final String SERVER_IP = "192.168.0.14";
    //private static final String SERVER_PORT = "1234";
    //private static final String TIME_OUT = "5000";
    private static String ip = "192.168.110.238";
    private static int puerto = 1234;
    private int i = 0;
    private TextView txtMensaje;
    private TextView txtAvisos;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        Button btnConectar = (Button) findViewById(R.id.btnConectar);
        // Button btnRecibir = (Button) findViewById(R.id.btnRecibir);
        txtMensaje = (TextView) findViewById(R.id.txtMensaje);
        txtAvisos = (TextView) findViewById(R.id.txtAvisos);

        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler mainHandler = new Handler(Looper.getMainLooper());
                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            resultado=connectSocket(txtMensaje.getText().toString(), ip, puerto);
                            txtAvisos.setText("Servidor: "+resultado);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                mainHandler.post(myRunnable);
            }
        });
    }

    private String connectSocket(String mensaje, String direccion, Integer puerto) throws IOException {

        try {
            InetAddress serverAddr = InetAddress.getByName(direccion);
            Log.i("TCP", "Conectando...");

            Socket socket = new Socket(serverAddr, puerto);
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                Log.i("TCP", "C: Sending: '" + mensaje + "'");
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(mensaje);
                socket.shutdownOutput();
                StringBuilder total = new StringBuilder();
                String line;
                if(in!=null) {
                    while ((line = in.readLine()) != null) {
                        total.append(line);
                    }
                    resultado = total.toString();
                }
                Log.i("TAG", "resultado");
                Log.i("TCP", "C: Sent.");
                Log.i("TCP", "C: Done.");

            } catch (Exception e) {
                Log.e("TCP", "S: Error", e);
            } finally {

            }
        } catch (UnknownHostException e) {
            Log.e("TCP", "C: UnknownHostException", e);
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("TCP", "C: IOException", e);
            e.printStackTrace();
        }
        return resultado;
    }
}