package com.arshef.fakestore.Activities;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arshef.fakestore.Activities.Admin.AddProductActivity;
import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;
import com.arshef.fakestore.Tools.StaticTools;

public class LoginActivity extends AppCompatActivity {

    public static boolean isLoggedIn = false;
    public static String user;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView signupLabel = findViewById(R.id.signupLabel);
        signupLabel.setPaintFlags(signupLabel.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        signupLabel.setLinksClickable(true);
        signupLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                if (Username.equals("Admin") && Password.equals("9")) {
                    Intent intent = new Intent(LoginActivity.this, AddProductActivity.class);
                    startActivity(intent);
                    return;
                }
                if (StaticTools.Authenticate(Username)) {
                    if (Authorize(Username, Password)) {
                        isLoggedIn = true;
                        user = Username;
                        Intent intent = new Intent(LoginActivity.this, StoreActivity.class);
                        startActivity(intent);
                    } else {
                        StaticTools.ToastMaker(LoginActivity.this, "Password is incorrect!");
                    }
                } else {
                    StaticTools.ToastMaker(LoginActivity.this, "User is not available!");
                }
            }
        });
    }

    private boolean Authorize(String username, String password) {
        if (User.find(User.class, "Username = ? and Password = ?", username, password).size() > 0) {
            return true;
        }
        return false;
    }
}
