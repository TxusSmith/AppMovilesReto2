package com.example.pokestorage_reto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText trainerName;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trainerName = findViewById(R.id.trainerName);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(
                (v) -> {
                    String username = trainerName.getText().toString();
                    //Toast.makeText(this, trainerName + "", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, StorageActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
        );
    }
}