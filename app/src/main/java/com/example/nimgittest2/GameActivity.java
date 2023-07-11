package com.example.nimgittest2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent = getIntent();
    int gameDifficulty = intent.getIntExtra("gameDifficulty", 0);
    Player p1 = new Player();
    Player p2 = new Player();
    private Button btnContinue;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnContinue){

        }
    }
}