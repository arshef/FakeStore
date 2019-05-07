package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;

import java.util.Date;
import java.util.List;

public class BasketHistory extends SugarRecord {
    @NotNull
    List<Product> Products;
    @NotNull
    Date Date;

    public BasketHistory() {
    }

    public BasketHistory(List<Product> products, java.util.Date date) {
        Products = products;
        Date = date;
    }
}
