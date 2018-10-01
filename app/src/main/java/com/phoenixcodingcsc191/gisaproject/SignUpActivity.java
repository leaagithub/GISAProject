package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout textInputFirstName;
    private TextInputLayout textInputLastName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputPhoneNo;
    private TextInputLayout textEmployeeID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textInputFirstName = findViewById(R.id.textInputFirstNameSignUp);
        textInputLastName = findViewById(R.id.textInputLastNameSignUp);
        textInputPassword = findViewById(R.id.textInputPasswordSignUp);
        textInputPhoneNo = findViewById(R.id.textInputPhoneNoSignUp);
        textEmployeeID = findViewById(R.id.textInputEmployeeIDSignUp);

        //signUpButonActivity();
    }
    @Override public void onBackPressed(){}
    private void signUpButonActivity(){
        Button signupButton = (Button) findViewById(R.id.buttonSignUpPage);
        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SignUpActivity.this, LoginScreenActivity.class));
                finish();
            }
        });
    }

    private boolean validateFirstName(){
        String firstNameInput = textInputFirstName.getEditText().getText().toString().trim();

        if(firstNameInput.isEmpty()){
            textInputFirstName.setError("First Name Cannot be Empty");
            return false;
        }else{
            textInputFirstName.setError(null);
            return true;
        }
    }
    private boolean validateLastName(){
        String lastNameInput = textInputLastName.getEditText().getText().toString().trim();

        if(lastNameInput.isEmpty()){
            textInputLastName.setError("Last Name Cannot be Empty");
            return false;
        }else{
            textInputLastName.setError(null);
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
    private boolean validateEmployeeID(){
        String employeeIDInput = textEmployeeID.getEditText().getText().toString().trim();

        if(employeeIDInput.isEmpty()){
            textEmployeeID.setError("Employee ID Cannot be Empty");
            return false;
        }else{
            textEmployeeID.setError(null);
            return true;
        }
    }
    private boolean validatePhoneNo(){
        String phoneNoInput = textInputPhoneNo.getEditText().getText().toString().trim();

        if(phoneNoInput.isEmpty()){
            textInputPhoneNo.setError("Phone Number Cannot be Empty");
            return false;
        }else{
            textInputPhoneNo.setError(null);
            return true;
        }
    }

    public void confirmInput(View v){
        if (!validateFirstName() | !validateLastName() | !validateEmployeeID() | !validatePhoneNo() | !validatePassword()){
            return;
        }
        //loginButtonActivity();
        startActivity(new Intent(SignUpActivity.this, LoginScreenActivity.class));
        finish();
    }

}
