package com.example.codigoqr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;


public class CodigoQR extends AppCompatActivity {

    private static ImageView codigo;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button escanear = findViewById(R.id.escanear);
        Button generar = findViewById(R.id.generar);
        codigo = findViewById(R.id.codigo);
        txtResultado = findViewById(R.id.txtResultado);
        escanear.setOnClickListener(view -> escanearQR());

        generar.setOnClickListener(view -> generarQR());
    }


    public void escanearQR() {
        IntentIntegrator integrador = new IntentIntegrator(this);
        integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrador.setPrompt("Escanear Código");
        integrador.setCameraId(0);
        integrador.setBeepEnabled(true);
        integrador.setBarcodeImageEnabled(true);
        integrador.initiateScan();
    }

    public static void generarQR() {

        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        int indice_aleaorio;
        Random rn = new Random();

        // Generamos una cadena aleatoria de 20 caracteres de longitud
        for(int i = 0; i < 20; i ++) {
            indice_aleaorio = rn.nextInt(62);
            cadena += caracteres.charAt(indice_aleaorio);
        }

        // Generamos un codigo QR a partir de esa cadena y lo agregamos al ImageView
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(cadena, BarcodeFormat.QR_CODE, 500, 500);
            codigo.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
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
            Intent intent = new Intent(CodigoQR.this, CodigoQR.class);
            startActivity(intent);
        }if (id == R.id.codigobarras){
            Intent intent = new Intent(CodigoQR.this, CodigoBarras.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}