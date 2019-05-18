package com.arshef.fakestore.Models;

import com.orm.SugarRecord;

public class ProductBasket extends SugarRecord {
    Product Product;
    int Count;

    public ProductBasket() {
    }

    public ProductBasket(com.arshef.fakestore.Models.Product product) {
        Product = product;
        Count = 1;
    }

    public ProductBasket(com.arshef.fakestore.Models.Product product, int count) {
        Product = product;
        Count = count;
    }

    public com.arshef.fakestore.Models.Product getProduct() {
        return Product;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
