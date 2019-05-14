package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;

import java.util.List;

public class Order extends SugarRecord {
    @NotNull
    String Username;
    @NotNull
    double Lat;
    @NotNull
    double Long;
    @NotNull
    List<Product> Products;
    @NotNull
    int Price;
    @NotNull
    boolean isFinished;

    public Order() {
    }

    public Order(String username, double lat, double aLong, List<Product> products, int price) {
        Username = username;
        Lat = lat;
        Long = aLong;
        Products = products;
        Price = price;
        isFinished = false;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
