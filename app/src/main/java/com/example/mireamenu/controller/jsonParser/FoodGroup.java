package com.example.mireamenu.controller.jsonParser;

import android.content.Context;

import com.example.mireamenu.model.FoodList;

import static com.example.mireamenu.Variables.*;

public class FoodGroup {

    public FoodList getFoodList(Context context, String university, String foodName) {
        JsonEatParser parser = new JsonEatParser();
        String food = "";
        switch (foodName) {
            case COLD_SNAKE:
                food = COLD_SNAKE_PATH;
                break;
            case DRINK:
                food = DRINK_PATH;
                break;
            case ECONOM:
                food = ECONOM_PATH;
                break;
            case FIRST_DISH:
                food = FIRST_DISH_PATH;
                break;
            case GARNISH:
                food = GARNISH_PATH;
                break;
            case SAUCES_BREAD:
                food = SAUCES_BREAD_PATH;
                break;
            case SECOND_DISH:
                food = SECOND_DISH_PATH;
                break;
        }
        System.out.println(1);
        return parser.doParse(context, university, food);
    }
}
