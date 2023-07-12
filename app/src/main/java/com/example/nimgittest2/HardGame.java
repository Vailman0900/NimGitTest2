package com.example.nimgittest2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HardGame extends AppCompatActivity implements View.OnClickListener{


    int turn = 0;
    int matchesRemaining1 = 3;
    int matchesRemaining2 = 5;
    int matchesRemaining3 = 7;
    int matchesRemaining4 = 9;

    int matchesTaken = 0;
    private Button take1;
    private Button take2;
    private Button take3;
    private Button take4;
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
    private ImageView match10;
    private ImageView match11;
    private ImageView match12;
    private ImageView match13;
    private ImageView match14;
    private ImageView match15;
    private ImageView match16;
    private ImageView match17;
    private ImageView match18;
    private ImageView match19;
    private ImageView match20;
    private ImageView match21;
    private ImageView match22;
    private ImageView match23;
    private ImageView match24;


    TextView win;
    GameRunner gr = new GameRunner();
    ImageView[] row1 = new ImageView[3];
    ImageView[] row2 = new ImageView[5];
    ImageView[] row3 = new ImageView[7];
    ImageView[] row4 = new ImageView[9];

    String p1Name;
    String p2Name;
    Player p1 = new Player();
    Player p2 = new Player();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard_game);

        take1 = findViewById(R.id.btnHarTake1);
        take2 = findViewById(R.id.btnHarTake2);
        take3 = findViewById(R.id.btnHarTake3);
        take4 = findViewById(R.id.btnHarTake4);
        endTurn = findViewById(R.id.btnHarEndTurn);
        mainMenu = findViewById(R.id.btnEasMainMenu);
        win = findViewById(R.id.tvWin);

        match1 = findViewById(R.id.ivHarMatch1);
        match2 = findViewById(R.id.igHarMatch2);
        match3 = findViewById(R.id.igHarMatch3);
        match4 = findViewById(R.id.igHarMatch4);
        match5 = findViewById(R.id.igHarMatch5);
        match6 = findViewById(R.id.igHarMatch6);
        match7 = findViewById(R.id.igHarMatch7);
        match8 = findViewById(R.id.igHarMatch8);
        match9 = findViewById(R.id.igHarMatch9);
        match10 = findViewById(R.id.igHarMatch10);
        match11 = findViewById(R.id.igHarMatch11);
        match12 = findViewById(R.id.igHarMatch12);
        match13 = findViewById(R.id.igHarMatch13);
        match14 = findViewById(R.id.igHarMatch14);
        match15 = findViewById(R.id.igHarMatch15);
        match16 = findViewById(R.id.igHarMatch16);
        match17 = findViewById(R.id.igHarMatch17);
        match18 = findViewById(R.id.igHarMatch18);
        match19 = findViewById(R.id.igHarMatch19);
        match20 = findViewById(R.id.igHarMatch20);
        match21 = findViewById(R.id.igHarMatch21);
        match22 = findViewById(R.id.igHarMatch22);
        match23 = findViewById(R.id.igHarMatch23);
        match24 = findViewById(R.id.igHarMatch24);



        row1[0] = match1;
        row1[1] = match2;
        row1[2] = match3;

        row2[0] = match4;
        row2[1] = match5;
        row2[2] = match6;
        row2[3] = match7;
        row2[4] = match8;

        row3[0] = match9;
        row3[1] = match10;
        row3[2] = match11;
        row3[3] = match12;
        row3[4] = match13;
        row3[5] = match14;
        row3[6] = match15;

        row4[0] = match16;
        row4[1] = match17;
        row4[2] = match18;
        row4[3] = match19;
        row4[4] = match20;
        row4[5] = match21;
        row4[6] = match22;
        row4[7] = match23;
        row4[8] = match24;




        gr.GameLogic(3);

        take1.setOnClickListener(this);
        take2.setOnClickListener(this);
        take3.setOnClickListener(this);
        take4.setOnClickListener(this);
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
            take4.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row1[matchesRemaining1-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining1 > 1){
                matchesRemaining1--;
            }
        }
        if(view == take2){
            take1.setVisibility(View.INVISIBLE);
            take3.setVisibility(View.INVISIBLE);
            take4.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row2[matchesRemaining2-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining2 > 1){
                matchesRemaining2--;
            }
        }
        if (view == take3){
            take2.setVisibility(View.INVISIBLE);
            take1.setVisibility(View.INVISIBLE);
            take4.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row3[matchesRemaining3-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining3 > 1){
                matchesRemaining3--;
            }
        }
        if (view == take4){
            take3.setVisibility(View.INVISIBLE);
            take2.setVisibility(View.INVISIBLE);
            take1.setVisibility(View.INVISIBLE);
            matchesTaken++;
            row4[matchesRemaining4-1].setVisibility(View.INVISIBLE);
            if(matchesRemaining4 > 1){
                matchesRemaining4--;
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
            if (take4.getVisibility() == View.VISIBLE){
                gr.makeMove(3,matchesTaken);
            }
            take1.setVisibility(View.INVISIBLE);
            take2.setVisibility(View.INVISIBLE);
            take3.setVisibility(View.INVISIBLE);
            take4.setVisibility(View.INVISIBLE);
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
                take4.setVisibility(View.INVISIBLE);
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
            if(gr.getPiles()[3] > 0){
                take4.setVisibility(View.VISIBLE);
            }

            matchesTaken = 0;
        }

        if (view == mainMenu){
            finish();
            Intent intent = new Intent(HardGame.this, MainActivity.class);
            startActivity(intent);
        }

    }
}
