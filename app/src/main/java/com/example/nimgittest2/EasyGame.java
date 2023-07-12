package com.example.nimgittest2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EasyGame extends AppCompatActivity implements View.OnClickListener{


    int turn = 0;
    int matchesRemaining1 = 1;
    int matchesRemaining2 = 3;
    int matchesRemaining3 = 5;

    int matchesTaken = 0;
    private Button take1;
    private Button take2;
    private Button take3;
    private Button endTurn;
    private Button mainMenu;

    private ImageView match1;
    private ImageView match2;
    private ImageView match3;
    private ImageView match4;
    private ImageView match5;
    private ImageView match6;
    private ImageView match7;
    private ImageView match8;
    private ImageView match9;
     TextView win;
    GameRunner gr = new GameRunner();
    ImageView[] row1 = new ImageView[1];
    ImageView[] row2 = new ImageView[3];
    ImageView[] row3 = new ImageView[5];

    String p1Name;
    String p2Name;
    Player p1 = new Player();
    Player p2 = new Player();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_game);

        take1 = findViewById(R.id.btnMedTake1);
        take2 = findViewById(R.id.btnHarTake2);
        take3 = findViewById(R.id.btnHarTake4);
        endTurn = findViewById(R.id.btnHarEndTurn);
        mainMenu = findViewById(R.id.btnEasMainMenu);
        win = findViewById(R.id.tvWin);

        match1 = findViewById(R.id.ivMedMatch1);
        match2 = findViewById(R.id.igMedMatch2);
        match3 = findViewById(R.id.igMedMatch3);
        match4 = findViewById(R.id.igMedMatch4);
        match5 = findViewById(R.id.igMedMatch5);
        match6 = findViewById(R.id.igMedMatch6);
        match7 = findViewById(R.id.igMedMatch7);
        match8 = findViewById(R.id.igMedMatch8);
        match9 = findViewById(R.id.igMedMatch9);


        row1[0] = match1;

        row2[0] = match2;
        row2[1] = match3;
        row2[2] = match4;


        row3[0] = match5;
        row3[1] = match6;
        row3[2] = match7;
        row3[3] = match8;
        row3[4] = match9;



        gr.GameLogic(1);

        take1.setOnClickListener(this);
        take2.setOnClickListener(this);
        take3.setOnClickListener(this);
        endTurn.setOnClickListener(this);
        mainMenu.setOnClickListener(this);


        mainMenu.setVisibility(View.INVISIBLE);


        Intent intent = getIntent();
        p1Name = intent.getStringExtra("p1Name");
        p2Name = intent.getStringExtra("p2Name");


        p1.setName(p1Name);
        p2.setName(p2Name);

    }

    @Override
    public void onClick(View view){
        if (view == take1){
            take2.setVisibility(View.INVISIBLE);
            take3.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row1[matchesRemaining1-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining1 > 1){
                matchesRemaining1--;
            }
        }
        if(view == take2){
            take1.setVisibility(View.INVISIBLE);
            take3.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row2[matchesRemaining2-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining2 > 1){
                matchesRemaining2--;
            }
        }
        if (view == take3){
            take2.setVisibility(View.INVISIBLE);
            take1.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row3[matchesRemaining3-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining3 > 1){
                matchesRemaining3--;
            }
        }
        if (view == endTurn){
            turn++;
            if (take1.getVisibility() == View.VISIBLE){
                gr.makeMove(0,matchesTaken);
            }
            if (take2.getVisibility() == View.VISIBLE){
                gr.makeMove(1,matchesTaken);
            }
            if (take3.getVisibility() == View.VISIBLE){
                gr.makeMove(2,matchesTaken);
            }
            take1.setVisibility(View.INVISIBLE);
            take2.setVisibility(View.INVISIBLE);
            take3.setVisibility(View.INVISIBLE);
            if(gr.isGameOver()){
                turn %= 2;
                switch(turn){
                    case 0:
                        win.setText(p1.getName() + "  Wins");
                        break;
                    case 1:
                        win.setText(p2.getName() + " Wins");
                        break;
                }
                take1.setVisibility(View.INVISIBLE);
                take2.setVisibility(View.INVISIBLE);
                take3.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                endTurn.setVisibility(View.INVISIBLE);


            }
            if(gr.getPiles()[0] > 0){
                take1.setVisibility(View.VISIBLE);
            }
            if(gr.getPiles()[1] > 0){
                take2.setVisibility(View.VISIBLE);
            }
            if(gr.getPiles()[2] > 0){
                take3.setVisibility(View.VISIBLE);
            }

            matchesTaken = 0;
        }

        if (view == mainMenu){
            finish();
            Intent intent = new Intent(EasyGame.this, MainActivity.class);
            startActivity(intent);
        }

    }
}
