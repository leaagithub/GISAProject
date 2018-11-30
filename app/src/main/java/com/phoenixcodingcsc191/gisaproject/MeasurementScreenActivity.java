package com.phoenixcodingcsc191.gisaproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MeasurementScreenActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private TextInputLayout textInputLSLength;
    private TextInputLayout textInputMSHeightt;
    private TextInputLayout textInputLSSlope;
    private TextInputLayout textInputRoadwayLength;
    private TextInputLayout textInputRoadwayWidth;
    private TextInputLayout textInputLSWidth;
    private TextInputLayout textInputSlopeHeight;
    private TextInputLayout textInputOriginalSlope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_screen);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
        textInputLSLength = findViewById(R.id.textInputLandSlideLength);
        textInputOriginalSlope = findViewById(R.id.textInputOriginalSlope);
        textInputSlopeHeight = findViewById(R.id.textInputSlopeHeight);
        textInputMSHeightt = findViewById(R.id.textInputMainScrapHeight);
        textInputLSWidth = findViewById(R.id.textInputLandSlideWidth);
        textInputRoadwayLength = findViewById(R.id.textInputLengthOfRoadwayEnroached);
        textInputRoadwayWidth = findViewById(R.id.textInputWidthOfRoadwayEnroached);
        textInputLSSlope = findViewById(R.id.textInputLandSlideSlope);

        savedInformation();
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
                showImage();
            }
        });
    }
    private void pushToString(){
        mEditor.putString(getString(R.string.MeasurementOriginalSlope),textInputOriginalSlope.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementSlopeHeight),textInputSlopeHeight.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementLandslideSlope),textInputLSSlope.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementWidthOfRoadwayEncroached),textInputRoadwayWidth.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementLengthOfRoadwayEncroached),textInputRoadwayLength.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementMainscrapHeight),textInputMSHeightt.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementLandslideLength),textInputLSLength.getEditText().getText().toString());
        mEditor.putString(getString(R.string.MeasurementLandslideWidth),textInputLSWidth.getEditText().getText().toString());
        mEditor.commit();
    }
    private void savedInformation(){
        String MeasurementOriginalSlopeSaved = mPreferences.getString(getString(R.string.MeasurementOriginalSlope),"");
        String MeasurementSlopeHeightSaved = mPreferences.getString(getString(R.string.MeasurementSlopeHeight),"");
        String MeasurementLandslideSlopeSaved = mPreferences.getString(getString(R.string.MeasurementLandslideSlope),"");
        String MeasurementWidthOfRoadwayEncroachedSaved = mPreferences.getString(getString(R.string.MeasurementWidthOfRoadwayEncroached),"");
        String MeasurementLengthOfRoadwayEncroachedSaved = mPreferences.getString(getString(R.string.MeasurementLengthOfRoadwayEncroached),"");
        String MeasurementMainscrapHeightSaved = mPreferences.getString(getString(R.string.MeasurementMainscrapHeight),"");
        String MeasurementLandslideLengthSaved = mPreferences.getString(getString(R.string.MeasurementLandslideLength),"");
        String MeasurementLandslideWidthSaved = mPreferences.getString(getString(R.string.MeasurementLandslideWidth),"");

        textInputOriginalSlope.getEditText().setText(MeasurementOriginalSlopeSaved);
        textInputSlopeHeight.getEditText().setText(MeasurementSlopeHeightSaved);
        textInputLSSlope.getEditText().setText(MeasurementLandslideSlopeSaved);
        textInputRoadwayWidth.getEditText().setText(MeasurementWidthOfRoadwayEncroachedSaved);
        textInputRoadwayLength.getEditText().setText(MeasurementLengthOfRoadwayEncroachedSaved);
        textInputMSHeightt.getEditText().setText(MeasurementMainscrapHeightSaved);
        textInputLSLength.getEditText().setText(MeasurementLandslideLengthSaved);
        textInputLSWidth.getEditText().setText(MeasurementLandslideWidthSaved);
    }
    private void showImage(){

        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(this);
        Uri imageUri = Uri.parse("android.resource://com.phoenixcodingcsc191.gisaproject/"+R.drawable.exdrawing);
        imageView.setImageURI(null);
        imageView.setImageURI(imageUri);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();

    }
    private void saveAndExitButtonActivity(){
        Button saveAndExitButton = (Button) findViewById(R.id.buttonSaveAndExitMeasurementPage);
        saveAndExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pushToString();
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
                pushToString();
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
                pushToString();
                startActivity(new Intent(MeasurementScreenActivity.this, SketchActivity.class));
                finish();
            }
        });
    }
}
