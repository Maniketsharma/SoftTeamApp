package com.example.softteamapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    Button login;
    Button register;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        welcome = findViewById(R.id.welcome);

        welcome.setText("Welcome to MySoftTeam \n" +
                "\n project team communication platform" +
                "Ans - Intent");

        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Groupjoin.class);
            startActivity(intent);
        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Groupadd.class);
            startActivity(intent);
        });
    }
}
