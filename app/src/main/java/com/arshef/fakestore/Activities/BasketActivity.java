package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arshef.fakestore.Models.ProductBasket;
import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.BasketRVAdapter;
import com.orm.SugarContext;

import java.util.List;

public class BasketActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        TextView emptyLabel = findViewById(R.id.emptyLabel);
        SugarContext.init(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout();
            }
        });
        if (User.Basket != null) {
            fab.show();
            emptyLabel.setVisibility(View.INVISIBLE);
            RecyclerView rv = findViewById(R.id.basket_rv);
            rv.setHasFixedSize(true);
            GridLayoutManager glm = new GridLayoutManager(this, 1);
            rv.setLayoutManager(glm);
            List<ProductBasket> products = User.Basket.getProducts();
            BasketRVAdapter adapter = new BasketRVAdapter(products, this);
            rv.setAdapter(adapter);
        } else {
            emptyLabel.setVisibility(View.VISIBLE);
        }
    }

    private void Checkout() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
