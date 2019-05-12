package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.arshef.fakestore.R;

public class RegisterActivity extends AppCompatActivity {

    Button registerbtn;
    EditText username;
    EditText password;
    EditText confirmpass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_layout);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmpass = findViewById(R.id.confirmpass);
        registerbtn = findViewById(R.id.register_btn);

    }
}
