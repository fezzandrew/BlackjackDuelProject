package com.example.fezzdrew.blackjackduel;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fezzdrew.blackjackduel.database.AccountDbHelper;
import com.example.fezzdrew.blackjackduel.database.AccountDbSchema;

public class MainActivity extends AppCompatActivity {

    AccountDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //database
        db = new AccountDbHelper(this);
        boolean insert = db.insertInAccount("TestAccount", "1000");
        //if (insert==true){
          //  Toast.makeText(getApplicationContext(), "Successful insertion", Toast.LENGTH_SHORT).show();
        //}
        //database end

        //menu buttons
        Button buttonLowTable = findViewById(R.id.btnLowStakes);
        buttonLowTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //setContentView(R.layout.low_stakes_game_view);
                Intent lowIntent = new Intent (getBaseContext(), LowGameActivity.class);
                startActivity(lowIntent);
            }
        });

        Button buttonHighTable = findViewById(R.id.btnHighStakes);
        buttonHighTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent highIntent = new Intent (getBaseContext(), HighGameActivity.class);
                startActivity(highIntent);
            }
        });

        Button buttonRules = findViewById(R.id.btnRules);
        buttonRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent rulesIntent = new Intent(getBaseContext(), RulesPageActivity.class);
                startActivity(rulesIntent);
            }
        });

        Button buttonAccount = findViewById(R.id.btnAccount);
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent accountIntent = new Intent(getBaseContext(), AccountActivity.class);
                startActivity(accountIntent);
            }
        });

        //menu end
    }
}
