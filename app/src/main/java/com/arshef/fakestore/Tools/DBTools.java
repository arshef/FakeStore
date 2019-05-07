package com.arshef.fakestore.Tools;

import com.arshef.fakestore.Models.Basket;

import java.util.List;

public class DBTools {
    Basket basket;

    public List<Basket> test() {
        basket = new Basket(2000, true);
        basket.save();
        return basket.listAll(Basket.class);
    }
}
