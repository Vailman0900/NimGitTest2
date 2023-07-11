package com.example.nimgittest2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    Player p1 = new Player();
    Player p2 = new Player();
    private Button btnContinue;
    private Button btnTake1;
    private Button btnTake2;
    private Button btnTake3;
    private Button btnTake4;
    private Button btnTake5;
    private Button btnQuit;
    private Button btnMainMenu;
    private Button btnEndTurn;
    private EditText etP1;
    private EditText etP2;
    LinearLayout imageContainer;
    int[] piecesArray = {3, 4, 5};
    int gameDifficulty;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        Intent intent = getIntent();
        gameDifficulty = intent.getIntExtra("gameDifficulty", 0);

        imageContainer = findViewById(R.id.layMatches);

        btnContinue = findViewById(R.id.btnContinue);
        btnTake1 = findViewById(R.id.btnTake1);
        btnTake2 = findViewById(R.id.btnTake2);
        btnTake3 = findViewById(R.id.btnTake3);
        btnTake4 = findViewById(R.id.btnTake4);
        btnTake5 = findViewById(R.id.btnTake5);
        btnMainMenu = findViewById(R.id.btnMainMenu);
        btnQuit = findViewById(R.id.btnQuit2);
        btnEndTurn = findViewById(R.id.btnEndTurn);
        etP1 = findViewById(R.id.etPlayer1);
        etP2 = findViewById(R.id.etPLayer2);




        btnContinue.setOnClickListener(this);
        btnTake1.setOnClickListener(this);
        btnTake2.setOnClickListener(this);
        btnTake3.setOnClickListener(this);
        btnTake4.setOnClickListener(this);
        btnTake5.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnMainMenu.setOnClickListener(this);
        btnEndTurn.setOnClickListener(this);

        btnTake1.setVisibility(View.INVISIBLE);
        btnTake2.setVisibility(View.INVISIBLE);
        btnTake3.setVisibility(View.INVISIBLE);
        btnTake4.setVisibility(View.INVISIBLE);
        btnTake5.setVisibility(View.INVISIBLE);
        btnQuit.setVisibility(View.INVISIBLE);
        btnMainMenu.setVisibility(View.INVISIBLE);
        btnEndTurn.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View view) {
        if (view == btnContinue){
            p1.setName(etP1.getText().toString());
            p2.setName(etP2.getText().toString());
            etP1.setVisibility(View.INVISIBLE);
            etP2.setVisibility(View.INVISIBLE);
            btnContinue.setVisibility(View.INVISIBLE);
            btnTake1.setVisibility(View.VISIBLE);
            btnTake2.setVisibility(View.VISIBLE);
            btnTake3.setVisibility(View.VISIBLE);
            btnTake4.setVisibility(View.VISIBLE);
            btnTake5.setVisibility(View.VISIBLE);
            btnEndTurn.setVisibility(View.VISIBLE);

            for (int i = 0; i < piecesArray.length; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                for (int j = 0; j < piecesArray[i]; j++) {
                    ImageView imageView = new ImageView(this);
                    imageView.setImageResource(R.drawable.matchstick_notip); // Replace with your desired image resource

                    // Modify layout parameters for each ImageView
                    layoutParams.setMargins(10, 10, 10, 10); // Set desired margins in pixels or dp
                    imageView.setLayoutParams(layoutParams);

                    imageContainer.addView(imageView);
                }
            }


        }
    }
}