package com.arshef.fakestore.Models;

public class ProductBasket {
    Product Product;
    int Count;

    public ProductBasket(com.arshef.fakestore.Models.Product product) {
        Product = product;
        Count = 1;
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
