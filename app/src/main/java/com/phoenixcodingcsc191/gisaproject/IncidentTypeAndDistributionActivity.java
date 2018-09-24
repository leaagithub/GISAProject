package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IncidentTypeAndDistributionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_type_and_distribution);
        saveAndExitButtonActivity();
    }
    @Override public void onBackPressed(){}

    private void saveAndExitButtonActivity(){
        Button saveAndExitButton = (Button) findViewById(R.id.buttonSaveIncidentType);
        saveAndExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(IncidentTypeAndDistributionActivity.this, MeasurementScreenActivity.class));
                finish();
            }
        });
    }
}
