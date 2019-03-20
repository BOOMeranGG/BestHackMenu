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
        builder.setMessage("Добавить \"" + product.name + "\" в корзину?");
        builder.setPositiveButton("OK", (dialog, arg1) -> {
            addToBasket();
        });
        builder.setNegativeButton("Отмена", (dialog, arg1) -> {
        });
        builder.show();
    }

    private void addToBasket() {
        Basket.shoppingList.add(product);
        Basket.cost += product.cost;
        Log.d(BASKET, "Добавлено. Общая стоимость: " + Basket.cost);
        Toast.makeText(activity, "Общая стоимость: " + Basket.cost, Toast.LENGTH_SHORT).show();
    }
}
