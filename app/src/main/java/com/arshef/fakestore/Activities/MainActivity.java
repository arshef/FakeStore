package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.DBTools;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBTools dbTools;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(getApplicationContext());
        SugarDb db = new SugarDb(this);
        db.onCreate(db.getDB());
        dbTools = new DBTools();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Basket> basketList = dbTools.test();
                TextView textView = findViewById(R.id.textView);
                textView.setText(basketList.toString());
            }
        });
    }
}