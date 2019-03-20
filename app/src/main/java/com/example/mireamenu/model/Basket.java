package com.example.mireamenu.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static List<ProductEntity> shoppingList = new ArrayList<>();
    public static int cost = 0;

    /**
     * Если текущий продукт в корзине уже есть, то мы просто увеличиваем его количество
     */
    public static void addProduct(ProductEntity product) {
        product.count++;
        int i;
        for (i = 0; i < shoppingList.size(); i++) {
            if (product.name.equals(shoppingList.get(i).name))
                break;
        }
        if (i == shoppingList.size()) {
            shoppingList.add(product);
        }
    }
}
