package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SiteInformationActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private TextInputLayout textInputDate;
    private TextInputLayout textInputDistrict;
    private TextInputLayout textInputCountry;
    private TextInputLayout textInputRoute;
    private TextInputLayout textInputPostMile;
    private TextInputLayout textInputDateIncReport;
    private TextInputLayout textInputLatitude;
    private TextInputLayout textInputLongitude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siteinformation);

        textInputDate = findViewById(R.id.textInputDateSiteInfo);
        textInputDistrict = findViewById(R.id.textInputDistrictSiteInfo);
        textInputCountry = findViewById(R.id.textInputCountrySiteInfo);
        textInputRoute = findViewById(R.id.textInputRouteSiteInfo);
        textInputPostMile = findViewById(R.id.textInputPostMileSiteInfo);
        textInputDateIncReport = findViewById(R.id.textInputDateIncReportSiteInfo);
        textInputLatitude = findViewById(R.id.textInputLatitudeSiteInfo);
        textInputLongitude = findViewById(R.id.textInputLongitudeSiteInfo);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPrefernce();
        nextPageButton();
        saveAndExitButtonActivity();
    }
    @Override public void onBackPressed(){}

    private void nextPageButton(){
        Button nextButton = (Button) findViewById(R.id.buttonNextSiteInformationPage);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            
            public void onClick(View view){
                mEditor.putString(getString(R.string.SiteInfoDate),textInputDate.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoDistrict),textInputDistrict.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoCountry),textInputCountry.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoRoute),textInputRoute.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoPostMile),textInputPostMile.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoDateIncidentReport),textInputDateIncReport.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoLatitude),textInputLatitude.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoLongitude),textInputLongitude.getEditText().getText().toString());

                mEditor.commit();
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
                mEditor.putString(getString(R.string.SiteInfoDate),textInputDate.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoDistrict),textInputDistrict.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoCountry),textInputCountry.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoRoute),textInputRoute.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoPostMile),textInputPostMile.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoDateIncidentReport),textInputDateIncReport.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoLatitude),textInputLatitude.getEditText().getText().toString());
                mEditor.putString(getString(R.string.SiteInfoLongitude),textInputLongitude.getEditText().getText().toString());
                mEditor.commit();
                startActivity(new Intent(SiteInformationActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }
    private void checkSharedPrefernce(){
        String Date = mPreferences.getString(getString(R.string.SiteInfoDate),"");
        String District = mPreferences.getString(getString(R.string.SiteInfoDistrict),"");
        String Country = mPreferences.getString(getString(R.string.SiteInfoCountry),"");
        String Route = mPreferences.getString(getString(R.string.SiteInfoRoute),"");
        String PostMile = mPreferences.getString(getString(R.string.SiteInfoPostMile),"");
        String DateIncidentReport = mPreferences.getString(getString(R.string.SiteInfoDateIncidentReport),"");
        String Latitude = mPreferences.getString(getString(R.string.SiteInfoLatitude),"");
        String Longitude = mPreferences.getString(getString(R.string.SiteInfoLongitude),"");

        textInputDate.getEditText().setText(Date);
        textInputDistrict.getEditText().setText(District);
        textInputCountry.getEditText().setText(Country);
        textInputRoute.getEditText().setText(Route);
        textInputPostMile.getEditText().setText(PostMile);
        textInputDateIncReport.getEditText().setText(DateIncidentReport);
        textInputLatitude.getEditText().setText(Latitude);
        textInputLongitude.getEditText().setText(Longitude);
    }
}
