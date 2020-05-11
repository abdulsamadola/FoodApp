package com.campstore.foodapp.model;

public class FoodItem {
    private int image;
    private String title, min, price;
    private float rating;

    public FoodItem(int image, String price, String title, String min, float rating) {
        this.image = image;
        this.price = price;
        this.title = title;
        this.min = min;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getMin() {
        return min;
    }

    public float getRating() {
        return rating;
    }
}
