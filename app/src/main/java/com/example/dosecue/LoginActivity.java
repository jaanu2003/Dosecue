package com.example.dosecue;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView btn;
    EditText inputUsername, inputPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.textviewsignup);
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkCredentials();
            }
        });
        btn.setOnClickListener((v) -> {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });
    }
    private void checkCredentials(){
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();
        if(username.isEmpty() || username.length()<7) {
            showError(inputUsername, "Your username is not valid...!!!");
        }
        else if(password.isEmpty() || password.length()<7) {
            showError(inputPassword, "Password must be 7 characters...");
        }
        else{
            Toast.makeText(this, "Login Method!!!", Toast.LENGTH_SHORT).show();
        }
    }
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
}