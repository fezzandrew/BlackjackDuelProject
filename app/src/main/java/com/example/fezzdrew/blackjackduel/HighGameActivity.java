package com.example.fezzdrew.blackjackduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class HighGameActivity extends AppCompatActivity {

    private SeekBar betSlider;
    private TextView balanceDisplay;
    private TextView betDisplay;

    private int minBet;
    private int playerBalance;
    private int playerBet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.low_stakes_game);

        setBetSlider();
        updatePlayerBetDisplay();


        //menu
        Button buttonMenu = findViewById(R.id.btnMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menuIntent = new Intent (getBaseContext(), MainActivity.class);
                startActivity(menuIntent);
            }
        });
        //menu end
    }

    private void setBetSlider()
    {
        betSlider = (SeekBar) findViewById(R.id.betSlider);
        betDisplay = (TextView) findViewById(R.id.betDisplay);
        balanceDisplay = (TextView) findViewById(R.id.lblBalance);
        playerBalance = 1000;
        minBet = 100;

        balanceDisplay.setText("$" + playerBalance);

        betSlider.setMax(0);
        betSlider.setMax(5000);



        betSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress <= minBet)
                {
                    seekBar.setProgress(minBet);
                }
                else if (progress > playerBalance)
                {
                    betDisplay.setText("Not enough funds!");
                }
                else{
                    betDisplay.setText("$" + progress);
                }
                playerBet = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updatePlayerBetDisplay()
    {


        Button buttonDeal = findViewById(R.id.btnDeal);
        buttonDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( playerBet >= minBet && playerBet <= playerBalance){
                    playerBalance = playerBalance - playerBet;
                    balanceDisplay.setText("$" + playerBalance);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Bet Value" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
