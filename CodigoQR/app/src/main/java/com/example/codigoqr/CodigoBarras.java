package com.example.codigoqr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

public class CodigoBarras extends AppCompatActivity {

    private static ImageView codigo_barras;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_barras);

        codigo_barras = findViewById(R.id.codigo_barras);
        txtResultado = findViewById(R.id.resultado);
        Button generar_barras = findViewById(R.id.generar_barras);
        Button escanear_barras = findViewById(R.id.escanear_barras);

        generar_barras.setOnClickListener(view -> generarBarras());

        escanear_barras.setOnClickListener(view -> escanearBarras());
    }

    public void generarBarras() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        int indice_aleaorio;
        Random rn = new Random();

        // Generamos una cadena aleatoria de 20 caracteres de longitud
        for(int i = 0; i < 20; i ++) {
            indice_aleaorio = rn.nextInt(62);
            cadena += caracteres.charAt(indice_aleaorio);
        }

        // Generamos un codigo de barras a partir de esa cadena y lo agregamos al ImageView
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(cadena, BarcodeFormat.CODE_128, 1250, 500);
            codigo_barras.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void escanearBarras() {
        IntentIntegrator integrador = new IntentIntegrator(this);
        integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrador.setPrompt("Escanear Código");
        integrador.setCameraId(0);
        integrador.setOrientationLocked(false);
        integrador.setBeepEnabled(true);
        integrador.setBarcodeImageEnabled(true);
        integrador.initiateScan();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult resultado = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(resultado != null) {

            // Si no se obtiene resultado se lanz una notificacion
            if(resultado.getContents() == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();

                // Si obtenemos un resultado del escaneo mostramos el texto en un textView
            } else {
                txtResultado.setText(resultado.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.codigoqr) {
            Intent intent = new Intent(CodigoBarras.this, CodigoQR.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}