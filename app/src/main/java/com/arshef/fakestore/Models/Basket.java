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

    public Basket(List<Product> products) {
        Products = products;
        IsActive = true;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public boolean isActive() {
        return IsActive;
    }

    public int getPrice() {
        return Price;
    }
}
