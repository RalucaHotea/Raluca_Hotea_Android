package com.example.traveljournal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_id);
        password = findViewById(R.id.password_id);
        loginButton = findViewById(R.id.loginButton);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String emailAdress = email.getText().toString();
                if (emailAdress.isEmpty()) {
                    email.setError("Field cannot be empty!");
                    email.requestFocus();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(emailAdress).matches()) {
                    email.setError("Invalid email!");
                    email.requestFocus();

                }

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String passwordText = password.getText().toString();
                if (passwordText.isEmpty()) {
                    password.setError("Field cannot be empty!");
                    password.requestFocus();
                }

            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        });


    }
}