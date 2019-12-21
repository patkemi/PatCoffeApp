package com.example.patcoffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class PatCoffeeMain2Activity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "com.example.patcoffeapp.MESSAGE";
    public static String food = "1";
    public static String drinks = "2";
    public static String snacks = "3";

    Button foodBut;
    Button drinksBut;
    Button snacksBut;
    TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_coffee_main2);

        foodBut = findViewById(R.id.foodButton);
        drinksBut = findViewById(R.id.drinksButton);
        snacksBut = findViewById(R.id.snacksButton);
        aboutText = findViewById(R.id.aboutTextView);

        foodBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendFood();

            }
        });

        drinksBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDrinks();

            }
        });

        snacksBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSnacks();

            }
        });

    }

    public void sendFood() {
        Intent intent = new Intent(this, PatCoffListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, food);
        startActivity(intent);
    }

    public void sendDrinks() {
        Intent intent = new Intent(this, PatCoffListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, drinks);
        startActivity(intent);
    }

    public void sendSnacks() {
        Intent intent = new Intent(this, PatCoffListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, snacks);
        startActivity(intent);
    }
}
