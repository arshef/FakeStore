package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;

public class Product extends SugarRecord {
    @NotNull
    String Title;
    @NotNull
    int Price;
    byte[] Image;

    public Product() {
    }

    public Product(String title, int price) {
        Title = title;
        Price = price;
    }
}
