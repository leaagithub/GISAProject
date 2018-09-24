package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ObservationScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation_screen);
        previousButtonActivity();
        nextButtonActivity();
        saveAndExitActivity();
    }
    @Override public void onBackPressed(){}

    private void previousButtonActivity(){
        Button previousButton = (Button) findViewById(R.id.buttonPreviousSketch);
        previousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ObservationScreenActivity.this, SketchActivity.class));
                finish();
            }
        });
    }
    private void nextButtonActivity(){
        Button nextButton = (Button) findViewById(R.id.buttonNextObservation);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ObservationScreenActivity.this, RecommendedAction.class));
                finish();
            }
        });
    }
    private void saveAndExitActivity(){
        Button saveAndExit = (Button) findViewById(R.id.buttonSaveAndExitObservation);
        saveAndExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ObservationScreenActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }

}
