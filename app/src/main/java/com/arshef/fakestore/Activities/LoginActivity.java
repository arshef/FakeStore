package com.arshef.fakestore.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.StaticTools;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Authenticate(username.getText().toString())) {
                    if (Authorize(username.getText().toString(), password.getText().toString())) {
                    } else {
                        StaticTools.ToastMaker(LoginActivity.this, "Password is incorrect!");
                    }
                } else {
                    StaticTools.ToastMaker(LoginActivity.this, "User is not available!");
                }
            }
        });
    }

    private boolean Authenticate(String username) {
        if (User.find(User.class, "Username = ?", username).size() > 0) {
            return true;
        }
        return false;
    }

    private boolean Authorize(String username, String password) {
        if (User.find(User.class, "Username = ? and Password = ?", username, password).size() > 0) {
            return true;
        }
        return false;
    }
}
