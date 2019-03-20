package com.example.mireamenu.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.mireamenu.R;
import com.example.mireamenu.controller.actionListeners.MainActivityListener;
import com.example.mireamenu.model.Basket;

import java.util.ArrayList;


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
    }

    @Override
    protected void onResume() {
        super.onResume();
        Basket.shoppingList = new ArrayList<>();
        Basket.cost = 0;
    }
}
