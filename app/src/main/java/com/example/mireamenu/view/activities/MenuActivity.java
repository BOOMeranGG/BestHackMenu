package com.example.mireamenu.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.mireamenu.R;
import com.example.mireamenu.controller.actionListeners.MenuActivityListener;

import static com.example.mireamenu.Variables.*;

public class MenuActivity extends AppCompatActivity{

    private String UNIVERSITY;
    TextView tvUniversityName;
    Button btnEconom, btnFirstDish, btnSecondDish, btnGarnish, btnBreadAndSauce, btnCold, btnDrink;
    TextView tvTypeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Log.d(ACTIVITY_LOGGER, "MainMenu activity was created");
        tvUniversityName = findViewById(R.id.tvUniversityName);
        tvTypeName = findViewById(R.id.tvTypeName);

        btnEconom = findViewById(R.id.btnEconom);
        btnFirstDish = findViewById(R.id.btnFirstDish);
        btnSecondDish = findViewById(R.id.btnSecondDish);
        btnGarnish = findViewById(R.id.btnGarnish);
        btnBreadAndSauce = findViewById(R.id.btnBreadAndSauce);
        btnCold = findViewById(R.id.btnCold);
        btnDrink = findViewById(R.id.btnDrink);

        initTextOnActivity();
        initButtonListener();
    }

    private void initTextOnActivity() {
        Intent intent = getIntent();
        UNIVERSITY = intent.getStringExtra("university");
        String universityRus;

        if (UNIVERSITY.equals(MIREA)) {
            universityRus = "Столовая МИРЭА";
        } else if (UNIVERSITY.equals(MITHT)) {
            universityRus = "Столовая МИТХТ";
        } else if (UNIVERSITY.equals(MGUPI)){
            universityRus = "Столовая МГУПИ";
        } else {
            universityRus = UNIVERSITY;
        }
        tvUniversityName.setText(universityRus);
        tvTypeName.setText((intent.getStringExtra("type")));
    }

    private void initButtonListener() {
        MenuActivityListener listener = new MenuActivityListener(this, UNIVERSITY);
        btnEconom.setOnClickListener(listener);
        btnFirstDish.setOnClickListener(listener);
        btnSecondDish.setOnClickListener(listener);
        btnGarnish.setOnClickListener(listener);
        btnBreadAndSauce.setOnClickListener(listener);
        btnCold.setOnClickListener(listener);
        btnDrink.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_location);
        menuItem.setVisible(true);
        MenuItem menuItem2 = menu.findItem(R.id.action_info);
        menuItem2.setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
