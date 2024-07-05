package com.example.recipeguide;

public class Recipe {
    private int imageResId;
    private String name;

    public Recipe(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}