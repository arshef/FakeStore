package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.StaticTools;
import com.google.android.gms.maps.model.LatLng;

import java.util.Timer;
import java.util.TimerTask;

public class SendingActivity extends AppCompatActivity {
    private final static LatLng myPos = MapActivity.pos;
    private final static Basket basket = User.Basket;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);
        LatLng pos = MapActivity.pos;
        final ImageButton finalBtn = findViewById(R.id.finalBtn);
        final TextView funtext = findViewById(R.id.funtext);
        finalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funtext.setText("Thanks for your purchase");
                StaticTools.ToastMaker(SendingActivity.this, "Going back to store");
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SendingActivity.this, StoreActivity.class);
                        startActivity(intent);
                    }
                }, 2000);
                User.Basket = null;
                finalBtn.setEnabled(false);
            }
        });
        //int d = StaticTools.getDistance(pos, myPos);
    }
}