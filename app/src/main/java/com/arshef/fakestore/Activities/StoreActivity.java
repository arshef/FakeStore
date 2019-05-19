package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.StoreRVAdapter;

import java.util.List;

public class StoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(this, 1);
        rv.setLayoutManager(glm);
        List<Product> products = Product.listAll(Product.class);
        Product product = Product.findById(Product.class, 1);
        StoreRVAdapter adapter = new StoreRVAdapter(products, this);
        rv.setAdapter(adapter);

    }
}
