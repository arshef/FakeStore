package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
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

    public String getDescription() {
        return Description;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public void saveToString(List<String> Comments) {
        StoreCmnt = String.join("&%", Comments);
    }

    public List<String> StringToList() {
        if (StoreCmnt == null)
            return null;
        List<String> folan = new ArrayList<>();
        String[] strings = StoreCmnt.split("&%");
        for (String s : strings) {
            folan.add(s);
        }
        return folan;
    }

    public void addComment(String s) {
        if (StringToList() != null) {
            List<String> strings = StringToList();
            strings.add(s);
            saveToString(strings);
        } else {
            List<String> strings = new ArrayList<>();
            strings.add(s);
            saveToString(strings);
        }
    }
}