package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IncidentOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_options);
        newIncidentButtonActivity();
    }
    @Override public void onBackPressed(){}

    private void newIncidentButtonActivity(){
        Button newIncidentButton = (Button) findViewById(R.id.buttonNewIncident);
        newIncidentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(IncidentOptionsActivity.this, SiteInformationActivity.class));
                finish();
            }
        });
    }

}
