package com.example.mireamenu.controller.actionListeners;

import android.app.AlertDialog;

import com.example.mireamenu.model.Basket;
import com.example.mireamenu.model.JsonFoodBody;
import com.example.mireamenu.view.activities.MenuActivity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionsMenuListener {
    private MenuActivity activity;

    public OptionsMenuListener(MenuActivity activity) {
        this.activity = activity;
    }

    public void createDialogWithBasketInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Корзина");
        builder.setMessage(getBasketInfo());
        AlertDialog alert = builder.create();
        alert.show();
    }

    private String getBasketInfo() {
        //int weight = 0;
        float calories = 0;
        StringBuilder info = new StringBuilder();
        List<JsonFoodBody> shoppingList = Basket.shoppingList;
        for (int i = 0; i < shoppingList.size(); i++) {
            JsonFoodBody item = shoppingList.get(i);
            info.append(item.name);
            info.append("\n\t\t\tСтоимость: ").append(item.cost).append("\u20BD");
            info.append("\n\t\t\tВес: \t").append(item.weight);
            info.append("\n\t\t\tКаллории: \t").append(item.calorie);
            info.append("\n\t\t\tБ/Ж/У: \t").append(item.proteins)
                    .append("/")
                    .append(item.fats)
                    .append("/")
                    .append(item.carbohydrates)
                    .append("\n");

            calories += item.calorie;
        }
        info.append("\nСуммарная стоимость = ")
                .append(Basket.cost)
                .append("\u20BD")
                .append(", всего каллорий = ")
                .append(calories).append(", вес: ");
        //        .append(weight);
        return info.toString();
    }
}
