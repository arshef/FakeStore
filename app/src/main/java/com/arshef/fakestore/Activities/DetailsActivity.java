package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.CommentsAdapter;
import com.arshef.fakestore.Tools.StaticTools;

public class DetailsActivity extends AppCompatActivity {
    int id = -1;
    int count = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final Intent intent = getIntent();
        id = intent.getIntExtra("id", -1) + 1;
        final Product product = Product.findById(Product.class, id);
        ListView listView = findViewById(R.id.comments_lv);
        TextView nocm = findViewById(R.id.nocm);
        TextView pricetxt = findViewById(R.id.pricetxt);
        NumberPicker quantityPicker = findViewById(R.id.quantityPicker);
        quantityPicker.setMinValue(1);
        quantityPicker.setMaxValue(20);
        quantityPicker.setValue(1);
        quantityPicker.setWrapSelectorWheel(false);
        quantityPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                count = newVal;
            }
        });
        pricetxt.setText(String.format("%sT", String.valueOf(product.getPrice())));
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
                product.save();
                StaticTools.AddToBasket(id, count);
                Intent intent1 = new Intent(DetailsActivity.this, BasketActivity.class);
                startActivity(intent1);
            }
        });
        TextView des = findViewById(R.id.description);
        des.setText(product.getDescription());
        final EditText cmText = findViewById(R.id.cmText);
        FloatingActionButton fab = findViewById(R.id.addcmBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cmText.getText().toString().equals("")) {
                    product.addComment(cmText.getText().toString());
                    product.save();
                    StaticTools.ToastMaker(DetailsActivity.this,"Comment added!");
                }
            }
        });
    }

    public void goToBasket(View view) {
        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);
    }
}