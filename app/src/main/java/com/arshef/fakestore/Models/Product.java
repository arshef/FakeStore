package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Product extends SugarRecord {
    @NotNull
    String Title;
    @NotNull
    int Price;
    byte[] Image;
    String Description;
    String StoreCmnt;

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

    public void saveToString(List<String> Comments) {
        StoreCmnt = String.join("&%", Comments);
    }

    public List<String> StringToList() {
        List<String> folan = new ArrayList<>();
        String[] strings = StoreCmnt.split("&%");
        for (String s : strings) {
            folan.add(s);
        }
        return folan;
    }
}