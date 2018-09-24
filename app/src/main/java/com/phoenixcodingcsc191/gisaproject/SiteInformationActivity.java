package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SiteInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siteinformation);
        nextPageButton();
        saveAndExitButtonActivity();
    }
    @Override public void onBackPressed(){}

    private void nextPageButton(){
        Button nextButton = (Button) findViewById(R.id.buttonNextSiteInformationPage);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SiteInformationActivity.this, IncidentTypeAndDistributionActivity.class));
                finish();
            }
        });
    }
    private void saveAndExitButtonActivity(){
        Button saveAndExitButton = (Button) findViewById(R.id.buttonSaveAndExitSiteInformationPage);
        saveAndExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SiteInformationActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }
}
