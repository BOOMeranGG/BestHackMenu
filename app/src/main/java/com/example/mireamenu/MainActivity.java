package com.example.mireamenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String LOG = "MainActivityLogger";

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
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
        String university = "";
        switch (v.getId()) {
            case R.id.btnMIREA:
                Log.d(LOG, "MIREA was pressed");
                university = "MIREA";
                break;
            case R.id.btnMITHT:
                Log.d(LOG, "MITHT was pressed");
                university = "MITHT";
                break;
            case R.id.btnMGUPI:
                Log.d(LOG, "MGUPI was pressed");
                university = "MGUPI";
                break;
        }
        intent.putExtra("university", university);
        startActivity(intent);
    }
}
