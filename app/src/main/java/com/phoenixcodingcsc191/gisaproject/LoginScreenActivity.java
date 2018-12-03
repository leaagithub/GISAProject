package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
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


public class LoginScreenActivity extends AppCompatActivity {

    INODEJS myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SharedPreferences mLogin;
    private SharedPreferences.Editor mEditor;

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    private String postResponse = "";

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
        setContentView(R.layout.activity_login_screen);

        textInputUsername = findViewById(R.id.textInputUser);
        textInputPassword = findViewById(R.id.textInputPassword);

        //Init API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INODEJS.class);

        mLogin = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mLogin.edit();

        signUpButtonActivity();
        //loginButtonActivity();
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
    private void loginUser(String eid, String password){
        compositeDisposable.add(myAPI.loginUser(eid, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //showResponse(s);
                        correctLogin(s);
                    }
                })
        );
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
    private void correctLogin(String s){
        String successful = new String("Successful");
        if(successful.equals(s)){
            showResponse("Status: " + s);
            mEditor.putString(getString(R.string.CALTRANSEmployeeID),textInputUsername.getEditText().getText().toString());
            mEditor.commit();
            showResponse(mLogin.getString(getString(R.string.CALTRANSEmployeeID),""));
            startActivity(new Intent(LoginScreenActivity.this, IncidentOptionsActivity.class));
            finish();
        }
        else {
            showResponse("Status: " + s);
        }
    }
    public void skip(View v){
        startActivity(new Intent(LoginScreenActivity.this, IncidentOptionsActivity.class));
        finish();
    }
    public void confirmInput(View v){
        String input = "Username: "+ textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Password: "+ textInputPassword.getEditText().getText().toString();
        //Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

        if (!validateUser() | !validatePassword()){
            return;
        }
        loginUser(textInputUsername.getEditText().getText().toString(),
                textInputPassword.getEditText().getText().toString());
        //loginButtonActivity();
    }
    public void showResponse(String response){
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }

}
