package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        signUpButonActivity();
        loginButtonActivity();
    }
    @Override public void onBackPressed(){}

    private void signUpButonActivity(){
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
}
