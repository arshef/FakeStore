package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import com.arshef.fakestore.R;

public class LoginActivity extends AppCompatActivity {

    Button login_btn;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);
        username = findViewById("username");


    }
}
