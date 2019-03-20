package com.example.mireamenu.view.activities;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        FoodGroup foodGroup = new FoodGroup();
        FoodList foodList = foodGroup.getFoodList(
                getBaseContext(),
                UNIVERSITY,
                TYPE_OF_FOOD
        );
        //createList(getBaseContext(), foodList);
    }

    private void createList(Context context, FoodList foodList) {
        LinearLayout mainLayout = findViewById(R.id.mainLayout);
        //List<JsonFoodBody> list = foodList.list;

//        for (int i = 0; i < list.size(); i++) {
//        }
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        ImageView img = (ImageView) layoutInflater.inflate(R.layout.activity_menu, mainLayout, false);
//        img.setImageResource(R.drawable.ic_launcher_background);

//        ImageView imageView = new ImageView(MenuActivity.this);
//        imageView.setImageResource(R.drawable.ic_launcher_background);
//        LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );
//        imageView.setLayoutParams(imageViewLayoutParams);
//
//        mainLayout.addView(imageView);
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