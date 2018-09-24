package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SketchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketch);
        nextPageButton();
        previousButtonActivity();
        saveAndExitButtonActivity();

    }
    @Override public void onBackPressed(){}

    private void nextPageButton(){
        Button nextButton = (Button) findViewById(R.id.buttonNextSketch);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SketchActivity.this, ObservationScreenActivity.class));
                finish();
            }
        });
    }

    private void previousButtonActivity(){
        Button previousButton = (Button) findViewById(R.id.buttonPreviousSketch);
        previousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SketchActivity.this, MeasurementScreenActivity.class));
                finish();
            }
        });
    }

    private void saveAndExitButtonActivity(){
        Button saveAndExit = (Button) findViewById(R.id.buttonSaveAndExitSketch);
        saveAndExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SketchActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }

}
