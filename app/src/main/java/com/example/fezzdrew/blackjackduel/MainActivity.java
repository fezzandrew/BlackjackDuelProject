package com.example.fezzdrew.blackjackduel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menu buttons
        Button buttonLowTable = findViewById(R.id.btnLowStakes);
        buttonLowTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.low_stakes_game_view);
            }
        });

        Button buttonHighTable = findViewById(R.id.btnHighStakes);
        buttonHighTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.high_stakes_game_view);
            }
        });

        Button buttonRules = findViewById(R.id.btnRules);
        buttonRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.rules);
            }
        });

        Button buttonAccount = findViewById(R.id.btnAccount);
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.account);
            }
        });
/*
        Button buttonReturn = findViewById(R.id.btnReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }

        });
        */
        //menu end
    }
}
