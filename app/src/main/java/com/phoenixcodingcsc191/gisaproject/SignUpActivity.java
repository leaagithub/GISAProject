package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.phoenixcodingcsc191.gisaproject.Retrofit.INODEJS;
import com.phoenixcodingcsc191.gisaproject.Retrofit.RetrofitClient;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {

    INODEJS myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TextInputLayout textInputFirstName;
    private TextInputLayout textInputLastName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputPhoneNo;
    private TextInputLayout textEmployeeID;
    private TextInputLayout textEmail;
    private Button signupButton;


    @Override
    protected void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textInputFirstName = findViewById(R.id.textInputFirstNameSignUp);
        textInputLastName = findViewById(R.id.textInputLastNameSignUp);
        textInputPassword = findViewById(R.id.textInputPasswordSignUp);
        textInputPhoneNo = findViewById(R.id.textInputPhoneNoSignUp);
        textEmployeeID = findViewById(R.id.textInputEmployeeIDSignUp);
        textEmail = findViewById(R.id.textInputEmailAddress);

        //Init API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INODEJS.class);

        signupButton = findViewById(R.id.buttonSignUpPage);

        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                registerUser(textEmployeeID.getEditText().toString(),
                        textInputFirstName.getEditText().toString(),
                        textInputLastName.getEditText().toString(),
                        textInputPhoneNo.getEditText().toString(),
                        textInputPassword.getEditText().toString(),
                        textEmail.getEditText().toString());
            }
        });

        //signUpButonActivity();
    }
    private void registerUser(String eid, String fname, String lname, String phoneNo, String password, String email){
        compositeDisposable.add(myAPI.registerUser(eid, fname, lname, phoneNo, password, email)
        .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {

                }
            })
        );
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
