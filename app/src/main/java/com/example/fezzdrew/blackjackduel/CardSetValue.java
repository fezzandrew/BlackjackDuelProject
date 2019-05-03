package com.example.fezzdrew.blackjackduel;

import android.widget.ImageView;

public class CardSetValue {



    private int value;
    private int suit;
    private ImageView image;



    public CardSetValue(int value, int suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }


}
