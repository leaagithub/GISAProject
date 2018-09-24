package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecommendedAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_action);
    }
    @Override public void onBackPressed(){}

    private void saveAndExitActivity(){
        Button saveAndExit = (Button) findViewById(R.id.buttonSaveandExitRecommend);
        saveAndExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(RecommendedAction.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }
    private void PreviousButtonActivity(){
        Button saveAndExit = (Button) findViewById(R.id.buttonPreviousRecommend);
        saveAndExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(RecommendedAction.this, ObservationScreenActivity.class));
                finish();
            }
        });
    }
    private void submitActivity(){
        Button submitButton = (Button) findViewById(R.id.buttonSubmitRecommend);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(RecommendedAction.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }

}
