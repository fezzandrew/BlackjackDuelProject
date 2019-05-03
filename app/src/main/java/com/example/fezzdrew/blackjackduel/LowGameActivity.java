package com.example.fezzdrew.blackjackduel;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class LowGameActivity extends AppCompatActivity {

    ImageView dealerCardOne, dealerCardTwo, dealerCardThree, dealerCardFour, dealerCardFive, playerCardOne, playerCardTwo, playerCardThree, playerCardFour, playerCardFive;
    ArrayList<Integer> deck;

    private SeekBar betSlider;
    private TextView balanceDisplay;
    private TextView betDisplay;
    private TextView playerValue;
    private TextView dealerValue;
    //gamePlayVariables
    private int turnCounter = 0;
    private int minBet;
    private int playerBalance;
    private int playerBet;
    private int playerHandValue;
    //playerCards
    int playerCardOneValue = 0;
    int playerCardTwoValue = 0;
    int playerCardThreeValue = 0;
    int playerCardFourValue = 0;
    int playerCardFiveValue = 0;
    //dealerCards
    int dealerCardOneValue = 0;
    int dealerCardTwoValue = 0;
    int dealerCardThreeValue = 0;
    int dealercardFourValue = 0;
    int dealerCardFiveValue = 0;

    private int dealerHandValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.low_stakes_game);

        Button buttonHit = findViewById(R.id.btnHit);
        buttonHit.setEnabled(false);

        Button buttonStand = findViewById(R.id.btnStand);
        buttonStand.setEnabled(false);

        Button buttonSplit = findViewById(R.id.btnSplit);
        buttonSplit.setEnabled(false);

        Button buttonDouble = findViewById(R.id.btnDoubleDown);
        buttonDouble.setEnabled(false);

        playerValue = (TextView) findViewById(R.id.txtPlayerValue);
        dealerValue = (TextView) findViewById(R.id.txtDealerValue);

        setBetSlider();
        gameStart();


        //creating deck
        playerCardOne = (ImageView) findViewById(R.id.playerCardOne);
        playerCardTwo = (ImageView) findViewById(R.id.playerCardTwo);
        playerCardThree = (ImageView) findViewById(R.id.playerCardThree);
        dealerCardOne = (ImageView) findViewById(R.id.dealerCardOne);
        dealerCardTwo = (ImageView) findViewById(R.id.dealerCardTwo);


        deck = new ArrayList<>();

        deck.add(1);//hearts
        deck.add(2);
        deck.add(3);
        deck.add(4);
        deck.add(5);
        deck.add(6);
        deck.add(7);
        deck.add(8);
        deck.add(9);
        deck.add(10);
        deck.add(11);
        deck.add(12);
        deck.add(13);

        deck.add(14);//diamonds
        deck.add(15);
        deck.add(16);
        deck.add(17);
        deck.add(18);
        deck.add(19);
        deck.add(20);
        deck.add(21);
        deck.add(22);
        deck.add(23);
        deck.add(24);
        deck.add(25);
        deck.add(26);

        deck.add(27);//spades
        deck.add(28);
        deck.add(29);
        deck.add(30);
        deck.add(31);
        deck.add(32);
        deck.add(33);
        deck.add(34);
        deck.add(35);
        deck.add(36);
        deck.add(37);
        deck.add(38);
        deck.add(39);

        deck.add(40);//clubs
        deck.add(41);
        deck.add(42);
        deck.add(43);
        deck.add(44);
        deck.add(45);
        deck.add(46);
        deck.add(47);
        deck.add(48);
        deck.add(49);
        deck.add(50);
        deck.add(51);
        deck.add(52);
        //deck end


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

    private int cardImages(int card, ImageView image){
        int value = 0;
        switch(card){

            case 1:
                image.setImageResource(R.drawable.two_hearts);
                value = 2;
                break;
            case 2:
                image.setImageResource(R.drawable.three_hearts);
                value = 3;
                break;
            case 3:
                image.setImageResource(R.drawable.four_hearts);
                value = 4;
                break;
            case 4:
                image.setImageResource(R.drawable.five_hearts);
                value = 5;
                break;
            case 5:
                image.setImageResource(R.drawable.six_hearts);
                value = 6;
                break;
            case 6:
                image.setImageResource(R.drawable.seven_hearts);
                value = 7;
                break;
            case 7:
                image.setImageResource(R.drawable.eight_hearts);
                value = 8;
                break;
            case 8:
                image.setImageResource(R.drawable.nine_hearts);
                value = 9;
                break;
            case 9:
                image.setImageResource(R.drawable.ten_hearts);
                value = 10;
                break;
            case 10:
                image.setImageResource(R.drawable.jack_hearts);
                value = 10;
                break;
            case 11:
                image.setImageResource(R.drawable.queen_hearts);
                value = 10;
                break;
            case 12:
                image.setImageResource(R.drawable.king_hearts);
                value = 10;
                break;
            case 13:
                image.setImageResource(R.drawable.one_hearts);
                value = 11;
                break;
            case 14:
                image.setImageResource(R.drawable.two_diamonds);
                value = 2;
                break;
            case 15:
                image.setImageResource(R.drawable.three_diamonds);
                value =3;
                break;
            case 16:
                image.setImageResource(R.drawable.four_diamonds);
                value = 4;
                break;
            case 17:
                image.setImageResource(R.drawable.five_diamonds);
                value = 5;
                break;
            case 18:
                image.setImageResource(R.drawable.six_diamonds);
                value =6;
                break;
            case 19:
                image.setImageResource(R.drawable.seven_diamonds);
                value =7;
                break;
            case 20:
                image.setImageResource(R.drawable.eight_diamonds);
                value =8;
                break;
            case 21:
                image.setImageResource(R.drawable.nine_diamonds);
                value = 9;
                break;
            case 22:
                image.setImageResource(R.drawable.ten_diamonds);
                value = 10;
                break;
            case 23:
                image.setImageResource(R.drawable.jack_diamonds);
                value = 10;
                break;
            case 24:
                image.setImageResource(R.drawable.queen_diamonds);
                value =10;
                break;
            case 25:
                image.setImageResource(R.drawable.king_diamonds);
                value = 10;
                break;
            case 26:
                image.setImageResource(R.drawable.one_diamonds);
                value =11;
                break;
            case 27:
                image.setImageResource(R.drawable.two_spades);
                value =2;
                break;
            case 28:
                image.setImageResource(R.drawable.three_spades);
                value = 3;
                break;
            case 29:
                image.setImageResource(R.drawable.four_spades);
                value =4;
                break;
            case 30:
                image.setImageResource(R.drawable.five_spades);
                value =5;
                break;
            case 31:
                image.setImageResource(R.drawable.six_spades);
                value =6;
                break;
            case 32:
                image.setImageResource(R.drawable.seven_spades);
                value =7;
                break;
            case 33:
                image.setImageResource(R.drawable.eight_spades);
                value =8;
                break;
            case 34:
                image.setImageResource(R.drawable.nine_spades);
                value =9;
                break;
            case 35:
                image.setImageResource(R.drawable.ten_spades);
                value =10;
                break;
            case 36:
                image.setImageResource(R.drawable.jack_spades);
                value =10;
                break;
            case 37:
                image.setImageResource(R.drawable.queen_spades);
                value = 10;
                break;
            case 38:
                image.setImageResource(R.drawable.king_spades);
                value = 10;
                break;
            case 39:
                image.setImageResource(R.drawable.one_spades);
                value = 11;
                break;
            case 40:
                image.setImageResource(R.drawable.two_clubs);
                value = 2;
                break;
            case 41:
                image.setImageResource(R.drawable.three_clubs);
                value = 3;
                break;
            case 42:
                image.setImageResource(R.drawable.four_clubs);
                value = 4;
                break;
            case 43:
                image.setImageResource(R.drawable.five_clubs);
                value = 5;
                break;
            case 44:
                image.setImageResource(R.drawable.six_clubs);
                value = 6;
                break;
            case 45:
                image.setImageResource(R.drawable.seven_clubs);
                value = 7;
                break;
            case 46:
                image.setImageResource(R.drawable.eight_clubs);
                value = 8;
                break;
            case 47:
                image.setImageResource(R.drawable.nine_clubs);
                value = 9;
                break;
            case 48:
                image.setImageResource(R.drawable.ten_clubs);
                value = 10;
                break;
            case 49:
                image.setImageResource(R.drawable.jack_clubs);
                value = 10;
                break;
            case 50:
                image.setImageResource(R.drawable.queen_clubs);
                value = 10;
                break;
            case 51:
                image.setImageResource(R.drawable.king_clubs);
                value = 10;
                break;
            case 52:
                image.setImageResource(R.drawable.one_clubs);
                value = 11;
                break;
        }
        return value;
    }

    private void Deal(){


        Collections.shuffle(deck);

        dealerCardTwo.setVisibility(View.INVISIBLE);
        playerCardOneValue = cardImages(deck.get(0), playerCardOne);
        dealerCardOneValue = cardImages(deck.get(1), dealerCardOne);
        playerCardTwoValue = cardImages(deck.get(2), playerCardTwo);
        dealerCardTwoValue= cardImages(deck.get(3), dealerCardTwo);

        dealerHandValue = dealerCardOneValue + dealerCardTwoValue;
        playerHandValue = playerCardOneValue + playerCardTwoValue;

        playerValue.setText("Score: " + playerHandValue);
        dealerValue.setText("Score: " + dealerHandValue);

    }

    private void setBetSlider()
    {
        betSlider = (SeekBar) findViewById(R.id.betSlider);
        betDisplay = (TextView) findViewById(R.id.betDisplay);
        balanceDisplay = (TextView) findViewById(R.id.lblBalance);

        minBet = 1;
        playerBalance = 1000;


        balanceDisplay.setText("$" + playerBalance);

        betSlider.setMax(0);
        betSlider.setMax(100);


        betSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < minBet)
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

    private void gameStart()
    {

        Button buttonDeal = findViewById(R.id.btnDeal);
        buttonDeal.setEnabled(true);

        buttonDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( playerBet >= minBet && playerBet <= playerBalance){
                    playerBalance = playerBalance - playerBet;
                    balanceDisplay.setText("$" + playerBalance);
                    Deal();
                    playerTurn();
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Bet Value" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void dealerTurn(){
        if (dealerHandValue == 17){
            if (dealerHandValue > playerHandValue && dealerHandValue <= 21){
                Bust();
            }
            else if (dealerHandValue < playerHandValue && playerHandValue <= 21){
                Toast.makeText(getApplicationContext(),"You Win!" , Toast.LENGTH_SHORT).show();
            }
        }
        else if (dealerHandValue < 21 && dealerHandValue < playerHandValue){
            Toast.makeText(getApplicationContext(),"Dealer Hits!" , Toast.LENGTH_SHORT).show();
        }
    }

    private void playerTurn(){
       // Toast.makeText(getApplicationContext(), "PLAYER TURN STARTING", Toast.LENGTH_SHORT).show();
        final Button buttonDeal = findViewById(R.id.btnDeal);
        buttonDeal.setEnabled(false);

        final Button buttonHit = findViewById(R.id.btnHit);
        buttonHit.setEnabled(true);

        final Button buttonStand = findViewById(R.id.btnStand);
        buttonStand.setEnabled(true);

        buttonStand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDeal.setEnabled(false);
                buttonHit.setEnabled(false);
                buttonStand.setEnabled(false);
                dealerTurn();
            }
        });


        buttonHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    turnCounter++;
                    if (playerHandValue < 21 && turnCounter == 1){

                        Hit();

                    }
                    else if ( playerHandValue < 21 && turnCounter == 2){

                        HitTwo();

                    }
                    else if (playerHandValue < 21 && turnCounter == 3 ){
                        HitThree();
                    }
            }
        });

    }

    private void Hit(){

       playerCardThreeValue = cardImages(deck.get(4), playerCardThree);
        playerCardThree.setVisibility(View.VISIBLE);
       playerHandValue = playerHandValue + playerCardThreeValue;
        playerValue.setText("Score: " + playerHandValue);

        if (playerHandValue > 21){
            Bust();
        }
    }

    private void HitTwo(){

        playerCardFourValue = cardImages(deck.get(4), playerCardFour);
        playerCardFour.setVisibility(View.VISIBLE);
        playerHandValue = playerHandValue + playerCardFourValue;
        playerValue.setText("Score: " + playerHandValue);

        if (playerHandValue > 21){
            Bust();
        }
    }

    private void HitThree(){

        playerCardFiveValue = cardImages(deck.get(5), playerCardFive);
        playerCardFive.setVisibility(View.VISIBLE);
        playerHandValue = playerHandValue + playerCardFiveValue;
        playerValue.setText("Score: " + playerHandValue);

        if (playerHandValue > 21){
           Bust();
        }
    }

    private void Bust(){
        Toast.makeText(getApplicationContext(),"YOU LOSE" , Toast.LENGTH_SHORT).show();




    }


}

