package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;

import java.util.List;

public class BasketActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        User user = User.find(User.class, "Username = ?", LoginActivity.user).get(0);
        List<Basket> baskets = user.getBaskets();
        for (Basket basket :
                baskets) {
            Log.wtf("*", "******************");
            Log.wtf("*", String.valueOf(basket.isActive()));
            Log.wtf("*", "******************");
        }
    }
}
