package com.example.mireamenu.controller.actionListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.mireamenu.R;
import com.example.mireamenu.view.activities.MenuActivity;

import static com.example.mireamenu.Variables.*;

public class MenuActivityListener implements View.OnClickListener {
    private Activity activity;
    private String university;

    public MenuActivityListener(Activity activity, String university) {
        this.activity = activity;
        this.university = university;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, MenuActivity.class);
        String foodGroupName = getTextFoodGroupName(v);

        intent.putExtra("university", university);
        intent.putExtra("type", foodGroupName);
        activity.finish();
        activity.startActivity(intent);
    }

    private String getTextFoodGroupName(View v) {
        String foodGroupName = "";
        switch (v.getId()) {
            case R.id.btnEconom:
                foodGroupName = ECONOM;
                break;
            case R.id.btnFirstDish:
                foodGroupName = FIRST_DISH;
                break;
            case R.id.btnSecondDish:
                foodGroupName = SECOND_DISH;
                break;
            case R.id.btnGarnish:
                foodGroupName = GARNISH;
                break;
            case R.id.btnBreadAndSauce:
                foodGroupName = SAUCES_BREAD;
                break;
            case R.id.btnCold:
                foodGroupName = COLD_SNAKE;
                break;
            case R.id.btnDrink:
                foodGroupName = DRINK;
                break;
        }
        return foodGroupName;
    }
}
