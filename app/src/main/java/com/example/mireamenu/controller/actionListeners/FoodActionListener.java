package com.example.mireamenu.controller.actionListeners;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.mireamenu.Variables.BASKET;

public class FoodActionListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        TextView tv = (TextView) v;
        Log.d(BASKET, tv.getText() + " added");
    }
}
