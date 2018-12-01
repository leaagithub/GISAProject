package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Observable;

public class ObservationScreenActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText ObservationNotesET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation_screen);

        ObservationNotesET = findViewById(R.id.EditTextNotesObservation);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        loadSaved();
        previousButton();
        nextButtonActivity();
        saveAndExitActivity();
    }

    @Override public void onBackPressed(){}
    private void savePref(){
        mEditor.putString(getString(R.string.ObservationNotes),ObservationNotesET.getText().toString());
        mEditor.commit();
    }

    private void loadSaved(){
        String ObservationNotes = mPreferences.getString(getString(R.string.ObservationNotes),"");
        ObservationNotesET.setText(ObservationNotes);
    }
    private void previousButton(){
        Button previous = (Button) findViewById(R.id.buttonPreviousObservation);
        previous.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                savePref();
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
                savePref();
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
                savePref();
                startActivity(new Intent(ObservationScreenActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }

}
