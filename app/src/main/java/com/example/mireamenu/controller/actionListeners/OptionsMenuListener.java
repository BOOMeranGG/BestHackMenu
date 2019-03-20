package com.example.mireamenu.controller.actionListeners;

import android.app.AlertDialog;

import com.example.mireamenu.model.Basket;
import com.example.mireamenu.model.ProductEntity;
import com.example.mireamenu.view.activities.MenuActivity;

import java.util.List;

public class OptionsMenuListener {
    private MenuActivity activity;

    public OptionsMenuListener(MenuActivity activity) {
        this.activity = activity;
    }

    /**
     * Создаёт диалоговое окно при нажатии на TextView с продуктом
     */
    public void createDialogWithBasketInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Корзина");
        builder.setMessage(getBasketInfo());
        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * @return - строка с необходимой информацией по шаблону.
     */
    private String getBasketInfo() {
        float calories = 0;
        StringBuilder info = new StringBuilder();
        List<ProductEntity> shoppingList = Basket.shoppingList;
        for (int i = 0; i < shoppingList.size(); i++) {
            ProductEntity item = shoppingList.get(i);
            int count = item.count;

            info.append(item.name);
            info.append("\t\tX")
                .append(count);
            info.append("\n\t\t\tСтоимость: ").append(item.cost).append("\u20BD");
            info.append("\n\t\t\tВес: \t").append(item.weight);
            info.append("\n\t\t\tКаллории: \t").append(item.calorie);
            info.append("\n\t\t\tБ/Ж/У: \t").append(item.proteins)
                    .append("/")
                    .append(item.fats)
                    .append("/")
                    .append(item.carbohydrates)
                    .append("\n");

            calories += item.calorie * count;
        }
        info.append("\nСуммарная стоимость = ")
                .append(Basket.cost)
                .append("\u20BD")
                .append(", всего каллорий = ")
                .append(calories).append(", вес: ");
        return info.toString();
    }
}
