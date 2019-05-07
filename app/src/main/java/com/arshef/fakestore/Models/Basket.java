package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;

import java.util.List;

public class Basket extends SugarRecord {
    @NotNull
    int Price;
    @NotNull
    boolean IsActive;
    List<Product> Products;

    public Basket() {
    }

    public Basket(int price, boolean isActive) {
        Price = price;
        IsActive = isActive;
    }
}
