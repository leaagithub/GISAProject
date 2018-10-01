package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        textInputUsername = findViewById(R.id.textInputUser);
        textInputPassword = findViewById(R.id.textInputPassword);

        signUpButtonActivity();
        //
    }
    @Override public void onBackPressed(){}

    private void signUpButtonActivity(){
        Button signupButton = (Button) findViewById(R.id.buttonSignUp);
        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(LoginScreenActivity.this, SignUpActivity.class));
                finish();
            }
        });
    }
    private void loginButtonActivity(){
        Button loginButton = (Button) findViewById(R.id.buttonLogIn);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(LoginScreenActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }

    private boolean validateUser(){
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if(usernameInput.isEmpty()){
            textInputUsername.setError("Username Cannot be Empty");
            return false;
        }else if (usernameInput.length() > 15) {
            textInputUsername.setError("Username too long");
            return false;
        }else{
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if(passwordInput.isEmpty()){
            textInputPassword.setError("Password Cannot be Empty");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }
    public void confirmInput(View v){
        if (!validateUser() | !validatePassword()){
            return;
        }

        String input = "Username: "+ textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Password: "+ textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        //loginButtonActivity();
        startActivity(new Intent(LoginScreenActivity.this, IncidentOptionsActivity.class));
        finish();
    }
}
