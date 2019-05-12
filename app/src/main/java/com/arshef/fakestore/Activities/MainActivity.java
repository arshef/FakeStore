package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.DBTools;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    DBTools dbTools;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(getApplicationContext());
        SugarDb db = new SugarDb(this);
        db.onCreate(db.getDB());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        },1500);
    }
}