package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;
import com.google.android.gms.maps.model.LatLng;

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
        //int d = StaticTools.getDistance(pos, myPos);
    }
}