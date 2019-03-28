package com.example.fezzdrew.blackjackduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button buttonRules = findViewById(R.id.btnRules);
        buttonRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent rulesIntent = new Intent(getBaseContext(), RulesPageActivity.class);
                startActivity(rulesIntent);
            }
        });
    }
}
