package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;

    // Player Represent
    // 0 = x
    // 1 = O
    int activePlayer = 0;
    int [] gameState={2, 2, 2, 2, 2, 2, 2, 2, 2};
    //state means
    // 0 = x
    // 1 = O
    // 2 = null

    int [] [] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                              {0,3,6}, {1,4,7}, {2,5,8},
                              {0,4,8}, {2,4,6}};

    public void playertap(View view){

        ImageView img = (ImageView) view;

        int tapImage = Integer.parseInt(img.getTag().toString());
        if (!gameactive){
            reset(view);
        }
        if (gameState[tapImage] == 2 ){
            gameState[tapImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O Turn - Tap To Play");

            }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X Turn - Tap To Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        // check If any player win

        for(int [] winPosition:winPositions){
          if (  gameState[winPosition[0]] == gameState[winPosition[1]] &&
                  gameState[winPosition[1]] == gameState[winPosition[2]] &&
                  gameState[winPosition[0]] != 2 ) {
              // somebody won find out who won

                String winnerStr;
                gameactive = false;
              if(gameState[winPosition[0]] == 0 ){
                  winnerStr = "X Has Won";

              }
              else {
                  winnerStr = " O Has Won ";
              }
              // update status bar for winner announcement

              TextView status = findViewById(R.id.status);
              status.setText(winnerStr);

          }

        }


    }
    public void reset(View view){
        gameactive = true;
        activePlayer = 0;
        for (int i=0; i<gameState.length;i++){
            gameState [i] = 2;

        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X Turn - Tap To Play");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}