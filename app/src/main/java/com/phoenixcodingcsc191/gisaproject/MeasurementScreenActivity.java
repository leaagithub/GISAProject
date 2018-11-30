package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeasurementScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_screen);
        saveAndExitButtonActivity();
        previousButtonActivity();
        nextPageButtonActivity();
        helpButtonActivity();
    }
    @Override public void onBackPressed(){}

    private void helpButtonActivity(){
        Button helpButton = (Button) findViewById(R.id.buttonHelpMeasurementScreen);
        helpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }
    private void saveAndExitButtonActivity(){
        Button saveAndExitButton = (Button) findViewById(R.id.buttonSaveAndExitMeasurementPage);
        saveAndExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MeasurementScreenActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }
    private void previousButtonActivity(){
        Button previousButton = (Button) findViewById(R.id.buttonPreviousMeasurementPage);
        previousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MeasurementScreenActivity.this, IncidentTypeAndDistributionActivity.class));
                finish();
            }
        });
    }
    private void nextPageButtonActivity(){
        Button nextButton = (Button) findViewById(R.id.buttonNextMeasurementPage);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MeasurementScreenActivity.this, SketchActivity.class));
                finish();
            }
        });
    }
}
