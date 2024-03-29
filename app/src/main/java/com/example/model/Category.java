package com.example.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int categoryThumb;
    private String categoryName;

    public Category(int categoryThumb, String categoryName) {
        this.categoryThumb = categoryThumb;
        this.categoryName = categoryName;
    }

    public int getCategoryThumb() {
        return categoryThumb;
    }

    public void setCategoryThumb(int categoryThumb) {
        this.categoryThumb = categoryThumb;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
