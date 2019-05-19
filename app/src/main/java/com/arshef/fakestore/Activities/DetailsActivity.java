package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.CommentsAdapter;
import com.arshef.fakestore.Tools.StaticTools;

public class DetailsActivity extends AppCompatActivity {
    int id = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final Intent intent = getIntent();
        id = intent.getIntExtra("id", -1) + 1;
        Product product = Product.findById(Product.class, id);
        ListView listView = findViewById(R.id.comments_lv);
        TextView nocm = findViewById(R.id.nocm);
        product.addComment("nice!");
        product.addComment("good!");
        product.addComment("nice!");
        product.addComment("good!");
        product.addComment("good!");
        product.addComment("nice!");
        product.addComment("good!");
        product.addComment("good!");
        product.addComment("nice!");
        product.addComment("good!");
        product.addComment("good!");
        product.save();
        if (product.StringToList() != null) {
            nocm.setVisibility(View.INVISIBLE);
            listView.setAdapter(new CommentsAdapter(this, product.StringToList()));
        } else {
            nocm.setVisibility(View.VISIBLE);
        }
        ImageView prdct_img = findViewById(R.id.product_img);
        if (product.getImage() != null) {
            prdct_img.setImageBitmap(StaticTools.GetImageFromBytes(product.getImage(), 150, 150));
        }
        Button button = findViewById(R.id.addBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaticTools.AddToBasket(id);
                Intent intent1 = new Intent(DetailsActivity.this, BasketActivity.class);
                startActivity(intent1);
            }
        });
        TextView des = findViewById(R.id.description);
        des.setText(product.getDescription());
        //todo add textview
    }

    public void goToBasket(View view) {
        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);
    }
}