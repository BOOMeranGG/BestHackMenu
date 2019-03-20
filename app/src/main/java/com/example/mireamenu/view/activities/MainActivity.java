package com.example.mireamenu.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.mireamenu.R;
import com.example.mireamenu.controller.actionListeners.MainActivityListener;


public class MainActivity extends AppCompatActivity {

    Button btnMIREA, btnMITHT, btnMGUPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMIREA = findViewById(R.id.btnMIREA);
        btnMITHT = findViewById(R.id.btnMITHT);
        btnMGUPI = findViewById(R.id.btnMGUPI);

        MainActivityListener listener = new MainActivityListener(this);
        btnMIREA.setOnClickListener(listener);
        btnMITHT.setOnClickListener(listener);
        btnMGUPI.setOnClickListener(listener);

//        JsonEatParser parser = new JsonEatParser();
//        parser.doParse(getBaseContext(), "mgupi", "secondDish");
    }
}
