package com.example.nimgittest2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
    private Button quit;

    private ImageView match1;
    private ImageView match2;
    private ImageView match3;
    private ImageView match4;
    private ImageView match5;
    private ImageView match6;
    private ImageView match7;
    private ImageView match8;
    private ImageView match9;
    GameRunner gr = new GameRunner();
    ImageView[] row1 = new ImageView[1];
    ImageView[] row2 = new ImageView[3];
    ImageView[] row3 = new ImageView[5];

    String p1Name;
    String p2Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_game);

        take1 = findViewById(R.id.btnEasTake1);
        take2 = findViewById(R.id.btnEasTake2);
        take3 = findViewById(R.id.btnEasTake4);
        endTurn = findViewById(R.id.btnEasEndTurn);
        mainMenu = findViewById(R.id.btnEasMainMenu);
        quit = findViewById(R.id.btnEasQuit);

        match1 = findViewById(R.id.ivEasMatch1);
        match2 = findViewById(R.id.igEasMatch2);
        match3 = findViewById(R.id.igEasMatch3);
        match4 = findViewById(R.id.igEasMatch4);
        match5 = findViewById(R.id.igEasMatch5);
        match6 = findViewById(R.id.igEasMatch6);
        match7 = findViewById(R.id.igEasMatch7);
        match8 = findViewById(R.id.igEasMatch8);
        match9 = findViewById(R.id.igEasMatch9);


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
        quit.setOnClickListener(this);

        mainMenu.setVisibility(View.INVISIBLE);
        quit.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        p1Name = intent.getStringExtra("p1Name");
        p2Name = intent.getStringExtra("p2Name");

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
            if (take1.getVisibility() == View.VISIBLE){
                gr.makeMove(1,matchesTaken);
            }
            if(gr.isGameOver()){

            }
            if(gr.getPiles()[0] > 0){
                take1.setVisibility(View.VISIBLE);
            }

        }
    }
}
