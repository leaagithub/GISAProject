package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IncidentOptionsActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_options);
        newIncidentButtonActivity();
        resumeIncidentButtonActivity();

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
    }
    @Override public void onBackPressed(){}

    private void newIncidentButtonActivity(){
        Button newIncidentButton = (Button) findViewById(R.id.buttonNewIncident);
        newIncidentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                clearStrings();
                startActivity(new Intent(IncidentOptionsActivity.this, SiteInformationActivity.class));
                finish();
            }
        });
    }
    private void clearStrings(){
        mEditor.clear();
        /*mEditor.putString(getString(R.string.SiteInfoDate),"");
        mEditor.putString(getString(R.string.SiteInfoDistrict),"");
        mEditor.putString(getString(R.string.SiteInfoCountry),"");
        mEditor.putString(getString(R.string.SiteInfoRoute),"");
        mEditor.putString(getString(R.string.SiteInfoPostMile),"");
        mEditor.putString(getString(R.string.SiteInfoDateIncidentReport),"");
        mEditor.putString(getString(R.string.SiteInfoLatitude),"");
        mEditor.putString(getString(R.string.SiteInfoLongitude),"");

        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"");

        mEditor.putString(getString(R.string.IncidentTypeAndDistribRadiogroupDistribution),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribRadiogroupHighWayStatus),"");

        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentLength),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentVertDisp),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentHoriDisp),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentDepth),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentSettlement),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentBulge),"");
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"");
        */

        mEditor.commit();
    }
    private void resumeIncidentButtonActivity(){
        Button newIncidentButton = (Button) findViewById(R.id.buttonResumeIncidentOptionPage);
        newIncidentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(IncidentOptionsActivity.this, SiteInformationActivity.class));
                finish();
            }
        });
    }

}
