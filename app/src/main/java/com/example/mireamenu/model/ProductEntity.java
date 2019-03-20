package com.example.mireamenu.model;

/**
 * У каждого продукта есть эти поля. Этот класс считывается с json
 */
public class ProductEntity {
    public int id;
    public String name;
    public String  weight;
    public float calorie;
    public float proteins;
    public float fats;
    public float carbohydrates;
    public float cost;

    public transient int count = 0;
}
