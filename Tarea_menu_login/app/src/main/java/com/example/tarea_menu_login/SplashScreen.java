package com.example.tarea_menu_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Una splashscreen con un timer de toda la vida
        ImageView imageView = findViewById(R.id.img);
        Timer t = new Timer();
        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(SplashScreen.this, Login.class);
            startActivity(intent);
            t.cancel();
        });

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        }, 3000);
    }
}