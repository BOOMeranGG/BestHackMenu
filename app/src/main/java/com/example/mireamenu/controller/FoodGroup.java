package com.example.mireamenu.controller;

import android.content.Context;
import android.util.Log;

import com.example.mireamenu.model.FoodList;

import static com.example.mireamenu.Variables.PARSER_LOGGER;

public class FoodGroup {

    public FoodList getFoodGroup(Context context, String university, String foodName) {
        JsonEatParser parser = new JsonEatParser();
        FoodList listOfFoods;
        try {
            listOfFoods = parser.doParse(context, university, foodName);
        } catch (Exception e) {
            Log.e(PARSER_LOGGER, "Error parsing");
            return null;
        }
        return listOfFoods;
    }
}
