package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.arshef.fakestore.R;

public class DetailsActivity extends AppCompatActivity {
    long id = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView prdct_img = findViewById(R.id.product_img);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", -1);
    }

    public void goToBasket(View view) {
        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);
    }
}