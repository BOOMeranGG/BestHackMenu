package com.example.mireamenu.view.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mireamenu.R;
import com.example.mireamenu.controller.jsonParser.FoodGroup;
import com.example.mireamenu.controller.actionListeners.MenuActivityListener;
import com.example.mireamenu.model.FoodList;
import com.example.mireamenu.model.JsonFoodBody;

import java.util.List;

import static com.example.mireamenu.Variables.*;

public class MenuActivity extends AppCompatActivity{

    private String UNIVERSITY;
    private String TYPE_OF_FOOD;
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

        initTextOnActivity();
        initButtonListener();

        Context context = getBaseContext();
        FoodGroup foodGroup = new FoodGroup();
        FoodList foodList = foodGroup.getFoodList(
                context,
                UNIVERSITY,
                TYPE_OF_FOOD
        );
        createList(context, foodList);
    }

    private void createList(Context context, FoodList foodList) {
        LinearLayout lMain = findViewById(R.id.mainLayout);
        List<JsonFoodBody> foods = foodList.list;

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        );
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < foods.size(); i++) {
            JsonFoodBody product = foods.get(i);
            TextView name = new TextView(this);
//            name.setText(i + UNIVERSITY + " HELLO WORLD!");
//            name.setTextSize(22);
//            linearLayout.addView(name);
            name.setText(product.name + " " + product.weight);
            name.setTextSize(24);
            name.setTypeface(Typeface.DEFAULT_BOLD);

            TextView description = new TextView(this);
            description.setTextSize(14);
            description.setTypeface(Typeface.SERIF);

            linearLayout.addView(name);
            linearLayout.addView(description);
        }
        scrollView.addView(linearLayout);
        lMain.addView(scrollView);
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
        TYPE_OF_FOOD = intent.getStringExtra("type");
        tvTypeName.setText(TYPE_OF_FOOD);
    }

    private void initButtonListener() {
        btnEconom = findViewById(R.id.btnEconom);
        btnFirstDish = findViewById(R.id.btnFirstDish);
        btnSecondDish = findViewById(R.id.btnSecondDish);
        btnGarnish = findViewById(R.id.btnGarnish);
        btnBreadAndSauce = findViewById(R.id.btnBreadAndSauce);
        btnCold = findViewById(R.id.btnCold);
        btnDrink = findViewById(R.id.btnDrink);

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
