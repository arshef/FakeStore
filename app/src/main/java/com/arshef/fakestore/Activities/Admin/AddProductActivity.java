package com.arshef.fakestore.Activities.Admin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.StaticTools;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddProductActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 2;
    byte[] bytes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Button uploadBtn = findViewById(R.id.uploadBtn);
        final TextView titleTxt = findViewById(R.id.titleTxt);
        final TextView priceTxt = findViewById(R.id.priceTxt);
        Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleTxt.getText().toString();
                int price = Integer.parseInt(priceTxt.getText().toString());
                Product product = new Product(title, price);
                if (bytes.length != 0)
                    product.setImage(bytes);
                long l = product.save();
                Log.e("e", "******************");
                Log.wtf("Data added: ", String.valueOf(l));
                Log.e("e", "******************");
            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                bytes = StaticTools.GetBytesFromImage(selectedImage, 100);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                StaticTools.ToastMaker(AddProductActivity.this, "Something went wrong");
            }

        } else {
            StaticTools.ToastMaker(AddProductActivity.this, "You haven't picked Image");
        }
    }
}
