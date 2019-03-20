package com.example.mireamenu.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static List<JsonFoodBody> shoppingList = new ArrayList<>();
    public static int cost = 0;

    public static void addProduct(JsonFoodBody product) {
        product.count++;
        int i = 0;
        for (i = 0; i < shoppingList.size(); i++) {
            if (product.name.equals(shoppingList.get(i).name))
                break;
        }
        if (i == shoppingList.size()) {
            shoppingList.add(product);
        }
    }
}
