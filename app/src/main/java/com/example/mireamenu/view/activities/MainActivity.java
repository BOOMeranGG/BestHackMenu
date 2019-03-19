package com.example.mireamenu.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mireamenu.R;
import com.example.mireamenu.controller.JsonEatParser;
import com.example.mireamenu.model.listsOfJsonBody.FirstDishList;

import static com.example.mireamenu.Variables.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMIREA, btnMITHT, btnMGUPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMIREA = findViewById(R.id.btnMIREA);
        btnMITHT = findViewById(R.id.btnMITHT);
        btnMGUPI = findViewById(R.id.btnMGUPI);

        btnMIREA.setOnClickListener(this);
        btnMITHT.setOnClickListener(this);
        btnMGUPI.setOnClickListener(this);

//        JsonEatParser parser = new JsonEatParser();
//        parser.doParse(getBaseContext(), "mgupi", "firstDish", FirstDishList.class);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
        String university = "";
        switch (v.getId()) {
            case R.id.btnMIREA:
                Log.d(ACTIVITY_LOGGER, "MIREA was pressed");
                university = MIREA;
                break;
            case R.id.btnMITHT:
                Log.d(ACTIVITY_LOGGER, "MITHT was pressed");
                university = MITHT;
                break;
            case R.id.btnMGUPI:
                Log.d(ACTIVITY_LOGGER, "MGUPI was pressed");
                university = MGUPI;
                break;
        }
        intent.putExtra("university", university);
        intent.putExtra("type", "Эконом обеды");
        startActivity(intent);
    }
}
