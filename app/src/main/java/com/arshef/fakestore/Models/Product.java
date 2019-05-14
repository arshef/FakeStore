package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;

public class Product extends SugarRecord {
    @NotNull
    String Title;
    @NotNull
    int Price;
    byte[] Image;
    String Description;

    public Product() {
    }

    public Product(String title, int price) {
        Title = title;
        Price = price;
        Image = null;
    }

    public String getTitle() {
        return Title;
    }

    public int getPrice() {
        return Price;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}