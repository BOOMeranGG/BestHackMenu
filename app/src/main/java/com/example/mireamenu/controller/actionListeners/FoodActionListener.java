package com.example.mireamenu.controller.actionListeners;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mireamenu.model.Basket;
import com.example.mireamenu.model.JsonFoodBody;
import com.example.mireamenu.view.activities.MenuActivity;

import static com.example.mireamenu.Variables.BASKET;

public class FoodActionListener implements View.OnClickListener {

    private MenuActivity activity;
    private JsonFoodBody product;

    public FoodActionListener(MenuActivity activity, JsonFoodBody product) {
        this.activity = activity;
        this.product = product;
    }

    @Override
    public void onClick(View v) {
        TextView tv = (TextView) v;
        Log.d(BASKET, tv.getText() + " выбрано");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("КОРЗИНА");
        builder.setMessage(getInfoAboutProduct());
        builder.setPositiveButton("OK", (dialog, arg1) -> addToBasket());
        builder.setNegativeButton("Отмена", (dialog, arg1) -> { });
        builder.show();
    }

    private String getInfoAboutProduct() {
        StringBuilder info = new StringBuilder();
        info.append("Добавить \"")
                .append(product.name)
                .append("\" в корзину?")
                .append("\nКалорийность: ")
                .append(product.calorie)
                .append("\nБ/Ж/У: ")
                .append(product.proteins)
                .append("/")
                .append(product.fats)
                .append("/")
                .append(product.carbohydrates);
        return info.toString();
    }

    private void addToBasket() {
        Basket.addProduct(product);
        Basket.cost += product.cost;
        Log.d(BASKET, "Добавлено. Общая стоимость: " + Basket.cost);
        Toast.makeText(activity, "Общая стоимость: " + Basket.cost, Toast.LENGTH_SHORT).show();
    }
}
