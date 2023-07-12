package com.example.nimgittest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEasy;
    private Button btnMedium;
    private Button btnHard;
    private Button btnRules;
    private Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        btnEasy = findViewById(R.id.btnEasy);
        btnMedium = findViewById(R.id.btnMedium);
        btnHard = findViewById(R.id.btnHard);
        btnRules = findViewById(R.id.btnRules);
        btnQuit = findViewById(R.id.btnQuit);

        btnEasy.setOnClickListener(this);
        btnMedium.setOnClickListener(this);
        btnHard.setOnClickListener(this);
        btnRules.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnEasy){
            GameStart(1);
        }
        if(view == btnMedium){
            GameStart(2);
        }
        if(view == btnHard){
            GameStart(3);
        }
        if(view == btnRules){
            Intent intent = new Intent(MainActivity.this, RulesActivity.class);

            startActivity(intent);
        }
        if(view == btnQuit){
            GameStart(3);
        }
        if(view == btnQuit){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }


    }

    public void GameStart(int i){
        Intent intent = new Intent(MainActivity.this, PLayerActivity.class);
        intent.putExtra("gameDifficulty", i);
        startActivity(intent);
    }
}



