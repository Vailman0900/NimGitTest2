package com.example.nimgittest2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PLayerActivity extends AppCompatActivity implements View.OnClickListener {


    Player p1 = new Player();
    Player p2 = new Player();
    private Button btnContinue;
    private EditText etP1;
    private EditText etP2;
    int gameDifficulty;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        Intent intent = getIntent();
        gameDifficulty = intent.getIntExtra("gameDifficulty", 0);

        btnContinue = findViewById(R.id.btnContinue);

        etP1 = findViewById(R.id.etPlayer1);
        etP2 = findViewById(R.id.etPLayer2);

        btnContinue.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view == btnContinue){
            p1.setName(etP1.getText().toString());
            p2.setName(etP2.getText().toString());
            switch(gameDifficulty){
                case 1:
                    finish();
                    Intent easy = new Intent(PLayerActivity.this, EasyGame.class);
                    easy.putExtra("p1Name", etP1.getText().toString());
                    easy.putExtra("p2Name", etP2.getText().toString());
                    startActivity(easy);
                    break;
                case 2:
                    finish();
                    Intent medium = new Intent(PLayerActivity.this, MediumGame.class);
                    medium.putExtra("p1Name", etP1.getText().toString());
                    medium.putExtra("p2Name", etP2.getText().toString());
                    startActivity(medium);
                    break;
                case 3:
                    finish();
                    Intent hard = new Intent(PLayerActivity.this, HardGame.class);
                    hard.putExtra("p1Name", etP1.getText().toString());
                    hard.putExtra("p2Name", etP2.getText().toString());
                    startActivity(hard);
                    break;
            }
        }
    }
}