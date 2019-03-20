package com.example.mireamenu.controller.jsonParser;

import android.content.Context;

import com.example.mireamenu.model.FoodList;

import static com.example.mireamenu.Variables.*;

public class FoodGroup {

    /**
     * 'Адаптер' для класса JsonFoodParser. Именно он вызывается из других пакетов
     * @return
     */
    public FoodList getFoodList(Context context, String university, String foodName) {
        JsonFoodParser parser = new JsonFoodParser();
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
        return parser.doParse(context, university, food);
    }
}
