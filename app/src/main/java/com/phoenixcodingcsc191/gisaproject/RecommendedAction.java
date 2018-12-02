package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.phoenixcodingcsc191.gisaproject.Retrofit.INODEJS;
import com.phoenixcodingcsc191.gisaproject.Retrofit.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RecommendedAction extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    INODEJS myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private CheckBox checkBoxImmediateActionsOpenHighwayTraffic;
    private CheckBox checkBoxFollowUpActionsOpenHighwayTraffic;
    private CheckBox checkBoxImmediateActionsOpenHighwayShoulder;
    private CheckBox checkBoxFollowUpActionsOpenHighwayShoulder;
    private CheckBox checkBoxImmediateActionsCloseHighway;
    private CheckBox checkBoxImmediateActionsRemovedLandsideDebris;
    private CheckBox checkBoxImmediateActionsPlaceKRail;
    private CheckBox checkBoxImmediateActionsCoverSlope;
    private CheckBox checkBoxImmediateActionsDivertSurface;
    private CheckBox checkBoxImmediateActionsRemoveCulvert;
    private CheckBox checkBoxImmediateActionsDewaterPump;
    private CheckBox checkBoxImmediateActionsDewaterHorizontalDrains;
    private CheckBox checkBoxFollowUpActionsDewaterHorizontalDrains;
    private CheckBox checkBoxImmediateActionsConstructTempShoring;
    private CheckBox checkBoxFollowUpActionsConstructTempShoring;
    private CheckBox checkBoxImmediateActionsButtressToeOfLandslide;
    private CheckBox checkBoxFollowUpActionsButtressToeOfLandslide;
    private CheckBox checkBoxImmediateActionsPlaceRockSlopeProtect;
    private CheckBox checkBoxFollowUpActionsPlaceRockSlopeProtect;
    private CheckBox checkBoxImmediateActionsRoutineVisualMonitor;
    private CheckBox checkBoxFollowUpActionsRoutineVisualMonitor;
    private CheckBox checkBoxImmediateActionsReconstructSlopeOG;
    private CheckBox checkBoxFollowUpActionsReconstructSlopeOG;
    private CheckBox checkBoxImmediateActionsReconstructSlopeGeo;
    private CheckBox checkBoxFollowUpActionsReconstructSlopeGeo;
    private CheckBox checkBoxFollowUpActionsInstallErosion;
    private CheckBox checkBoxFollowUpActionsRepairPipe;
    private CheckBox checkBoxFollowUpActionsSurveyTheSite;
    private CheckBox checkBoxFollowUpActionsPerformGeologicalMapping;
    private CheckBox checkBoxFollowUpActionsPerformSubsurfaceExploration;
    private CheckBox checkBoxFollowUpActionsPerformDetailedDesign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_action);
        //Init API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INODEJS.class);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
        assignCheckboxesID();
        saveAndExitActivity();
        loadSaved();
        PreviousButtonActivity();
        submitActivity();
    }
    @Override public void onBackPressed(){}
    private void assignCheckboxesID(){
        checkBoxImmediateActionsOpenHighwayTraffic = findViewById(R.id.checkBoxImmediateActionsOpenHighwayTraffic);
        checkBoxFollowUpActionsOpenHighwayTraffic = findViewById(R.id.checkBoxFollowUpActionsOpenHighwayTraffic);
        checkBoxImmediateActionsOpenHighwayShoulder = findViewById(R.id.checkBoxImmediateActionsOpenHighwayShoulder);
        checkBoxFollowUpActionsOpenHighwayShoulder = findViewById(R.id.checkBoxFollowUpActionsOpenHighwayShoulder);
        checkBoxImmediateActionsCloseHighway = findViewById(R.id.checkBoxImmediateActionsCloseHighway);
        checkBoxImmediateActionsRemovedLandsideDebris = findViewById(R.id.checkBoxImmediateActionsRemovedLandsideDebris);
        checkBoxImmediateActionsPlaceKRail = findViewById(R.id.checkBoxImmediateActionsPlaceKRail);
        checkBoxImmediateActionsCoverSlope = findViewById(R.id.checkBoxImmediateActionsCoverSlope);
        checkBoxImmediateActionsDivertSurface = findViewById(R.id.checkBoxImmediateActionsDivertSurface);
        checkBoxImmediateActionsRemoveCulvert = findViewById(R.id.checkBoxImmediateActionsRemoveCulvert);
        checkBoxImmediateActionsDewaterPump = findViewById(R.id.checkBoxImmediateActionsDewaterPump);
        checkBoxImmediateActionsDewaterHorizontalDrains = findViewById(R.id.checkBoxImmediateActionsDewaterHorizontalDrains);
        checkBoxFollowUpActionsDewaterHorizontalDrains = findViewById(R.id.checkBoxFollowUpActionsDewaterHorizontalDrains);
        checkBoxImmediateActionsConstructTempShoring = findViewById(R.id.checkBoxImmediateActionsConstructTempShoring);
        checkBoxFollowUpActionsConstructTempShoring = findViewById(R.id.checkBoxFollowUpActionsConstructTempShoring);
        checkBoxImmediateActionsButtressToeOfLandslide = findViewById(R.id.checkBoxImmediateActionsButtressToeOfLandslide);
        checkBoxFollowUpActionsButtressToeOfLandslide = findViewById(R.id.checkBoxFollowUpActionsButtressToeOfLandslide);
        checkBoxImmediateActionsPlaceRockSlopeProtect = findViewById(R.id.checkBoxImmediateActionsPlaceRockSlopeProtect);
        checkBoxFollowUpActionsPlaceRockSlopeProtect = findViewById(R.id.checkBoxFollowUpActionsPlaceRockSlopeProtect);
        checkBoxImmediateActionsRoutineVisualMonitor = findViewById(R.id.checkBoxImmediateActionsRoutineVisualMonitor);
        checkBoxFollowUpActionsRoutineVisualMonitor = findViewById(R.id.checkBoxFollowUpActionsRoutineVisualMonitor);
        checkBoxImmediateActionsReconstructSlopeOG = findViewById(R.id.checkBoxImmediateActionsReconstructSlopeOG);
        checkBoxFollowUpActionsReconstructSlopeOG = findViewById(R.id.checkBoxFollowUpActionsReconstructSlopeOG);
        checkBoxImmediateActionsReconstructSlopeGeo = findViewById(R.id.checkBoxImmediateActionsReconstructSlopeGeo);
        checkBoxFollowUpActionsReconstructSlopeGeo = findViewById(R.id.checkBoxFollowUpActionsReconstructSlopeGeo);
        checkBoxFollowUpActionsInstallErosion = findViewById(R.id.checkBoxFollowUpActionsInstallErosion);
        checkBoxFollowUpActionsRepairPipe = findViewById(R.id.checkBoxFollowUpActionsRepairPipe);
        checkBoxFollowUpActionsSurveyTheSite = findViewById(R.id.checkBoxFollowUpActionsSurveyTheSite);
        checkBoxFollowUpActionsPerformGeologicalMapping = findViewById(R.id.checkBoxFollowUpActionsPerformGeologicalMapping);
        checkBoxFollowUpActionsPerformSubsurfaceExploration = findViewById(R.id.checkBoxFollowUpActionsPerformSubsurfaceExploration);
        checkBoxFollowUpActionsPerformDetailedDesign = findViewById(R.id.checkBoxFollowUpActionsPerformDetailedDesign);

    }

    private void loadSaved(){
        String checkBoxImmediateActionsOpenHighwayTrafficSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"false");
        String checkBoxFollowUpActionsOpenHighwayTrafficSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"false");
        String checkBoxImmediateActionsOpenHighwayShoulderSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"false");
        String checkBoxFollowUpActionsOpenHighwayShoulderSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"false");
        String checkBoxImmediateActionsCloseHighwaySaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"false");
        String checkBoxImmediateActionsRemovedLandsideDebrisSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"false");
        String checkBoxImmediateActionsPlaceKRailSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"false");
        String checkBoxImmediateActionsCoverSlopeSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"false");
        String checkBoxImmediateActionsDivertSurfaceSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"false");
        String checkBoxImmediateActionsRemoveCulvertSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"false");
        String checkBoxImmediateActionsDewaterPumpSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"false");
        String checkBoxImmediateActionsDewaterHorizontalDrainsSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"false");
        String checkBoxFollowUpActionsDewaterHorizontalDrainsSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"false");
        String checkBoxImmediateActionsConstructTempShoringSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"false");
        String checkBoxFollowUpActionsConstructTempShoringSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"false");
        String checkBoxImmediateActionsButtressToeOfLandslideSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"false");
        String checkBoxFollowUpActionsButtressToeOfLandslideSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"false");
        String checkBoxImmediateActionsPlaceRockSlopeProtectSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"false");
        String checkBoxFollowUpActionsPlaceRockSlopeProtectSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"false");
        String checkBoxImmediateActionsRoutineVisualMonitorSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"false");
        String checkBoxFollowUpActionsRoutineVisualMonitorSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"false");
        String checkBoxImmediateActionsReconstructSlopeOGSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"false");
        String checkBoxFollowUpActionsReconstructSlopeOGSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"false");
        String checkBoxImmediateActionsReconstructSlopeGeoSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"false");
        String checkBoxFollowUpActionsReconstructSlopeGeoSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"false");
        String checkBoxFollowUpActionsInstallErosionSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"false");
        String checkBoxFollowUpActionsRepairPipeSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"false");
        String checkBoxFollowUpActionsSurveyTheSiteSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"false");
        String checkBoxFollowUpActionsPerformGeologicalMappingSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"false");
        String checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"false");
        String checkBoxFollowUpActionsPerformDetailedDesignSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformDetailedDesign),"false");

        if(checkBoxImmediateActionsOpenHighwayTrafficSaved.equals("false")){
            checkBoxImmediateActionsOpenHighwayTraffic.setChecked(false);
        }else{
            checkBoxImmediateActionsOpenHighwayTraffic.setChecked(true);
        }
        if(checkBoxFollowUpActionsOpenHighwayTrafficSaved.equals("false")){
            checkBoxFollowUpActionsOpenHighwayTraffic.setChecked(false);
        }else{
            checkBoxFollowUpActionsOpenHighwayTraffic.setChecked(true);
        }
        if(checkBoxImmediateActionsOpenHighwayShoulderSaved.equals("false")){
            checkBoxImmediateActionsOpenHighwayShoulder.setChecked(false);
        }else{
            checkBoxImmediateActionsOpenHighwayShoulder.setChecked(true);
        }
        if(checkBoxFollowUpActionsOpenHighwayShoulderSaved.equals("false")){
            checkBoxFollowUpActionsOpenHighwayShoulder.setChecked(false);
        }else{
            checkBoxFollowUpActionsOpenHighwayShoulder.setChecked(true);
        }
        if(checkBoxImmediateActionsCloseHighwaySaved.equals("false")){
            checkBoxImmediateActionsCloseHighway.setChecked(false);
        }else{
            checkBoxImmediateActionsCloseHighway.setChecked(true);
        }
        if(checkBoxImmediateActionsRemovedLandsideDebrisSaved.equals("false")){
            checkBoxImmediateActionsRemovedLandsideDebris.setChecked(false);
        }else{
            checkBoxImmediateActionsRemovedLandsideDebris.setChecked(true);
        }
        if(checkBoxImmediateActionsPlaceKRailSaved.equals("false")){
            checkBoxImmediateActionsPlaceKRail.setChecked(false);
        }else{
            checkBoxImmediateActionsPlaceKRail.setChecked(true);
        }
        if(checkBoxImmediateActionsCoverSlopeSaved.equals("false")){
            checkBoxImmediateActionsCoverSlope.setChecked(false);
        }else{
            checkBoxImmediateActionsCoverSlope.setChecked(true);
        }
        if(checkBoxImmediateActionsDivertSurfaceSaved.equals("false")){
            checkBoxImmediateActionsDivertSurface.setChecked(false);
        }else{
            checkBoxImmediateActionsDivertSurface.setChecked(true);
        }
        if(checkBoxImmediateActionsRemoveCulvertSaved.equals("false")){
            checkBoxImmediateActionsRemoveCulvert.setChecked(false);
        }else{
            checkBoxImmediateActionsRemoveCulvert.setChecked(true);
        }
        if(checkBoxImmediateActionsDewaterPumpSaved.equals("false")){
            checkBoxImmediateActionsDewaterPump.setChecked(false);
        }else{
            checkBoxImmediateActionsDewaterPump.setChecked(true);
        }
        if(checkBoxImmediateActionsDewaterHorizontalDrainsSaved.equals("false")){
            checkBoxImmediateActionsDewaterHorizontalDrains.setChecked(false);
        }else{
            checkBoxImmediateActionsDewaterHorizontalDrains.setChecked(true);
        }
        if(checkBoxFollowUpActionsDewaterHorizontalDrainsSaved.equals("false")){
            checkBoxFollowUpActionsDewaterHorizontalDrains.setChecked(false);
        }else{
            checkBoxFollowUpActionsDewaterHorizontalDrains.setChecked(true);
        }
        if(checkBoxImmediateActionsConstructTempShoringSaved.equals("false")){
            checkBoxImmediateActionsConstructTempShoring.setChecked(false);
        }else{
            checkBoxImmediateActionsConstructTempShoring.setChecked(true);
        }
        if(checkBoxFollowUpActionsConstructTempShoringSaved.equals("false")){
            checkBoxFollowUpActionsConstructTempShoring.setChecked(false);
        }else{
            checkBoxFollowUpActionsConstructTempShoring.setChecked(true);
        }
        if(checkBoxImmediateActionsButtressToeOfLandslideSaved.equals("false")){
            checkBoxImmediateActionsButtressToeOfLandslide.setChecked(false);
        }else{
            checkBoxImmediateActionsButtressToeOfLandslide.setChecked(true);
        }
        if(checkBoxFollowUpActionsButtressToeOfLandslideSaved.equals("false")){
            checkBoxFollowUpActionsButtressToeOfLandslide.setChecked(false);
        }else{
            checkBoxFollowUpActionsButtressToeOfLandslide.setChecked(true);
        }
        if(checkBoxImmediateActionsPlaceRockSlopeProtectSaved.equals("false")){
            checkBoxImmediateActionsPlaceRockSlopeProtect.setChecked(false);
        }else{
            checkBoxImmediateActionsPlaceRockSlopeProtect.setChecked(true);
        }
        if(checkBoxFollowUpActionsPlaceRockSlopeProtectSaved.equals("false")){
            checkBoxFollowUpActionsPlaceRockSlopeProtect.setChecked(false);
        }else{
            checkBoxFollowUpActionsPlaceRockSlopeProtect.setChecked(true);
        }
        if(checkBoxImmediateActionsRoutineVisualMonitorSaved.equals("false")){
            checkBoxImmediateActionsRoutineVisualMonitor.setChecked(false);
        }else{
            checkBoxImmediateActionsRoutineVisualMonitor.setChecked(true);
        }
        if(checkBoxFollowUpActionsRoutineVisualMonitorSaved.equals("false")){
            checkBoxFollowUpActionsRoutineVisualMonitor.setChecked(false);
        }else{
            checkBoxFollowUpActionsRoutineVisualMonitor.setChecked(true);
        }
        if(checkBoxImmediateActionsReconstructSlopeOGSaved.equals("false")){
            checkBoxImmediateActionsReconstructSlopeOG.setChecked(false);
        }else{
            checkBoxImmediateActionsReconstructSlopeOG.setChecked(true);
        }
        if(checkBoxFollowUpActionsReconstructSlopeOGSaved.equals("false")){
            checkBoxFollowUpActionsReconstructSlopeOG.setChecked(false);
        }else{
            checkBoxFollowUpActionsReconstructSlopeOG.setChecked(true);
        }
        if(checkBoxImmediateActionsReconstructSlopeGeoSaved.equals("false")){
            checkBoxImmediateActionsReconstructSlopeGeo.setChecked(false);
        }else{
            checkBoxImmediateActionsReconstructSlopeGeo.setChecked(true);
        }
        if(checkBoxFollowUpActionsReconstructSlopeGeoSaved.equals("false")){
            checkBoxFollowUpActionsReconstructSlopeGeo.setChecked(false);
        }else{
            checkBoxFollowUpActionsReconstructSlopeGeo.setChecked(true);
        }
        if(checkBoxFollowUpActionsInstallErosionSaved.equals("false")){
            checkBoxFollowUpActionsInstallErosion.setChecked(false);
        }else{
            checkBoxFollowUpActionsInstallErosion.setChecked(true);
        }
        if(checkBoxFollowUpActionsRepairPipeSaved.equals("false")){
            checkBoxFollowUpActionsRepairPipe.setChecked(false);
        }else{
            checkBoxFollowUpActionsRepairPipe.setChecked(true);
        }
        if(checkBoxFollowUpActionsSurveyTheSiteSaved.equals("false")){
            checkBoxFollowUpActionsSurveyTheSite.setChecked(false);
        }else{
            checkBoxFollowUpActionsSurveyTheSite.setChecked(true);
        }
        if(checkBoxFollowUpActionsPerformGeologicalMappingSaved.equals("false")){
            checkBoxFollowUpActionsPerformGeologicalMapping.setChecked(false);
        }else{
            checkBoxFollowUpActionsPerformGeologicalMapping.setChecked(true);
        }
        if(checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved.equals("false")){
            checkBoxFollowUpActionsPerformSubsurfaceExploration.setChecked(false);
        }else{
            checkBoxFollowUpActionsPerformSubsurfaceExploration.setChecked(true);
        }
        if(checkBoxFollowUpActionsPerformDetailedDesignSaved.equals("false")){
            checkBoxFollowUpActionsPerformDetailedDesign.setChecked(false);
        }else{
            checkBoxFollowUpActionsPerformDetailedDesign.setChecked(true);
        }

    }
    private void savePref(){
        if(checkBoxImmediateActionsOpenHighwayTraffic.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"Open Highway Traffic");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"False");
        }
        if(checkBoxFollowUpActionsOpenHighwayTraffic.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"Open Highway Traffic");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"False");
        }
        if(checkBoxImmediateActionsOpenHighwayShoulder.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"Open Highway Shoulder");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"False");
        }
        if(checkBoxFollowUpActionsOpenHighwayShoulder.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"Open Highway Shoulder");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"False");
        }
        if(checkBoxImmediateActionsCloseHighway.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"Close Highway");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"False");
        }
        if(checkBoxImmediateActionsRemovedLandsideDebris.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"Remove Landslide Debris");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"False");
        }
        if(checkBoxImmediateActionsPlaceKRail.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"Place K-Rail or Fence");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"False");
        }
        if(checkBoxImmediateActionsCoverSlope.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"Cover Slope with Plastic");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"False");
        }
        if(checkBoxImmediateActionsDivertSurface.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"Divert Surface Water Runoff");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"False");
        }
        if(checkBoxImmediateActionsRemoveCulvert.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"Remove Culvert Blockage");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"False");
        }
        if(checkBoxImmediateActionsDewaterPump.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"Dewater with Pump, Trench, etc");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"False");
        }
        if(checkBoxImmediateActionsDewaterHorizontalDrains.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"Dewater with Horizontal Drains");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"False");
        }
        if(checkBoxFollowUpActionsDewaterHorizontalDrains.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"Dewater with Horizontal Drains");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"False");
        }
        if(checkBoxImmediateActionsConstructTempShoring.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"Construct Temporary Shoring");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"False");
        }
        if(checkBoxFollowUpActionsConstructTempShoring.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"Construct Temporary Shoring");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"False");
        }
        if(checkBoxImmediateActionsButtressToeOfLandslide.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"Buttress Toe of Landslide");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"False");
        }
        if(checkBoxFollowUpActionsButtressToeOfLandslide.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"Buttress Toe of Landslide");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"False");
        }
        if(checkBoxImmediateActionsPlaceRockSlopeProtect.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"Place Rock Slope Protection");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"False");
        }
        if(checkBoxFollowUpActionsPlaceRockSlopeProtect.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"Place Rock Slope Protection");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"False");
        }
        if(checkBoxImmediateActionsRoutineVisualMonitor.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"Routine Visual Monitor");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"False");
        }
        if(checkBoxFollowUpActionsRoutineVisualMonitor.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"Routine Visual Monitor");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"False");
        }
        if(checkBoxImmediateActionsReconstructSlopeOG.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"Reconstruct Slope to Original Condition");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"False");
        }
        if(checkBoxFollowUpActionsReconstructSlopeOG.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"Reconstruct Slope to Original Condition");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"False");
        }
        if(checkBoxImmediateActionsReconstructSlopeGeo.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"Reconstruct Slope with Geosynthetics");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"False");
        }
        if(checkBoxFollowUpActionsReconstructSlopeGeo.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"Reconstruct Slope with Geosynthetics");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"False");
        }
        if(checkBoxFollowUpActionsInstallErosion.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"Install Erosion Control - by Dist. Landscape");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"False");
        }
        if(checkBoxFollowUpActionsRepairPipe.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"Repair Culvert/Drainage Pipe");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"False");
        }
        if(checkBoxFollowUpActionsSurveyTheSite.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"Survey the Site- by Dist. Survey");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"False");
        }
        if(checkBoxFollowUpActionsPerformGeologicalMapping.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"Perform Geological Mapping");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"False");
        }
        if(checkBoxFollowUpActionsPerformSubsurfaceExploration.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"Perform Subsurface Exploration");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"False");
        }
        if(checkBoxFollowUpActionsPerformDetailedDesign.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformDetailedDesign),"Perform Detailed Design & Produce Plans");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformDetailedDesign),"False");
        }

        mEditor.commit();
    }
    private void saveAndExitActivity(){
        Button saveAndExit = (Button) findViewById(R.id.buttonSaveandExitRecommend);
        saveAndExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                savePref();
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
                savePref();
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
                savePref();
                finalSubmit();
                startActivity(new Intent(RecommendedAction.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }
    private void finalSubmit(){

        submitReport();
        submitMaterial();
        submitFollowUpActionsBackEnd();
        submitIncidentType();
        submitMeasurements();
        submitPavement_Ground_Status();
        submitVegetationOnSlope();
        submitWater_Drainage();
    }
    public void submitReport() {
        compositeDisposable.add(myAPI.submitIncidentReport(
                mPreferences.getString(getString(R.string.SiteInfoDateIncidentReport), ""),
                mPreferences.getString(getString(R.string.SiteInfoDate), ""),
                mPreferences.getString(getString(R.string.SiteInfoDistrict), ""),
                mPreferences.getString(getString(R.string.SiteInfoCountry), ""),
                mPreferences.getString(getString(R.string.SiteInfoRoute), ""),
                mPreferences.getString(getString(R.string.SiteInfoLatitude), ""),
                mPreferences.getString(getString(R.string.SiteInfoLongitude), ""),
                mPreferences.getString(getString(R.string.ObservationNotes), ""),
                mPreferences.getString(getString(R.string.CALTRANSEmployeeID), ""),
                mPreferences.getString(getString(R.string.IncidentTypeAndDistribRadiogroupDistribution), ""),
                mPreferences.getString(getString(R.string.IncidentTypeAndDistribRadiogroupHighWayStatus), ""),
                "",
                "",
                "",
                "",
                "",
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitMaterial(){
        compositeDisposable.add(myAPI.submitMaterial(
                    "",
                    "",
                    "",
                    "",
                    mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialClay), ""),
                    mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSilt), ""),
                    mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSand), ""),
                    mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialGravel), ""))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {

                        }
                    })
        );
    }
    private void submitFollowUpActionsBackEnd(){
        String checkBoxImmediateActionsOpenHighwayTrafficSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"false");
        String checkBoxFollowUpActionsOpenHighwayTrafficSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"false");
        String checkBoxImmediateActionsOpenHighwayShoulderSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"false");
        String checkBoxFollowUpActionsOpenHighwayShoulderSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"false");
        String checkBoxImmediateActionsCloseHighwaySaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"false");
        String checkBoxImmediateActionsRemovedLandsideDebrisSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"false");
        String checkBoxImmediateActionsPlaceKRailSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"false");
        String checkBoxImmediateActionsCoverSlopeSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"false");
        String checkBoxImmediateActionsDivertSurfaceSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"false");
        String checkBoxImmediateActionsRemoveCulvertSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"false");
        String checkBoxImmediateActionsDewaterPumpSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"false");
        String checkBoxImmediateActionsDewaterHorizontalDrainsSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"false");
        String checkBoxFollowUpActionsDewaterHorizontalDrainsSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"false");
        String checkBoxImmediateActionsConstructTempShoringSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"false");
        String checkBoxFollowUpActionsConstructTempShoringSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"false");
        String checkBoxImmediateActionsButtressToeOfLandslideSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"false");
        String checkBoxFollowUpActionsButtressToeOfLandslideSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"false");
        String checkBoxImmediateActionsPlaceRockSlopeProtectSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"false");
        String checkBoxFollowUpActionsPlaceRockSlopeProtectSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"false");
        String checkBoxImmediateActionsRoutineVisualMonitorSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"false");
        String checkBoxFollowUpActionsRoutineVisualMonitorSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"false");
        String checkBoxImmediateActionsReconstructSlopeOGSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"false");
        String checkBoxFollowUpActionsReconstructSlopeOGSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"false");
        String checkBoxImmediateActionsReconstructSlopeGeoSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"false");
        String checkBoxFollowUpActionsReconstructSlopeGeoSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"false");
        String checkBoxFollowUpActionsInstallErosionSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"false");
        String checkBoxFollowUpActionsRepairPipeSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"false");
        String checkBoxFollowUpActionsSurveyTheSiteSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"false");
        String checkBoxFollowUpActionsPerformGeologicalMappingSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"false");
        String checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"false");
        String checkBoxFollowUpActionsPerformDetailedDesignSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformDetailedDesign),"false");

        if(checkBoxImmediateActionsOpenHighwayTrafficSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsOpenHighwayTrafficSaved);
        }
        if(checkBoxFollowUpActionsOpenHighwayTrafficSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsOpenHighwayTrafficSaved);
        }
        if(checkBoxImmediateActionsOpenHighwayShoulderSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsOpenHighwayShoulderSaved);
        }
        if(checkBoxFollowUpActionsOpenHighwayShoulderSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsOpenHighwayShoulderSaved);
        }
        if(checkBoxImmediateActionsCloseHighwaySaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsCloseHighwaySaved);
        }
        if(checkBoxImmediateActionsRemovedLandsideDebrisSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsRemovedLandsideDebrisSaved);
        }
        if(checkBoxImmediateActionsPlaceKRailSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsPlaceKRailSaved);
        }
        if(checkBoxImmediateActionsCoverSlopeSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsCoverSlopeSaved);
        }
        if(checkBoxImmediateActionsDivertSurfaceSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsDivertSurfaceSaved);
        }
        if(checkBoxImmediateActionsRemoveCulvertSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsRemoveCulvertSaved);
        }
        if(checkBoxImmediateActionsDewaterPumpSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsDewaterPumpSaved);
        }
        if(checkBoxImmediateActionsDewaterHorizontalDrainsSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsDewaterHorizontalDrainsSaved);
        }
        if(checkBoxFollowUpActionsDewaterHorizontalDrainsSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsDewaterHorizontalDrainsSaved);
        }
        if(checkBoxImmediateActionsConstructTempShoringSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsConstructTempShoringSaved);
        }
        if(checkBoxFollowUpActionsConstructTempShoringSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsConstructTempShoringSaved);
        }
        if(checkBoxImmediateActionsButtressToeOfLandslideSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsButtressToeOfLandslideSaved);
        }
        if(checkBoxFollowUpActionsButtressToeOfLandslideSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsButtressToeOfLandslideSaved);
        }
        if(checkBoxImmediateActionsPlaceRockSlopeProtectSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsPlaceRockSlopeProtectSaved);
        }
        if(checkBoxFollowUpActionsPlaceRockSlopeProtectSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsPlaceRockSlopeProtectSaved);
        }
        if(checkBoxImmediateActionsRoutineVisualMonitorSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsRoutineVisualMonitorSaved);
        }
        if(checkBoxFollowUpActionsRoutineVisualMonitorSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsRoutineVisualMonitorSaved);
        }
        if(checkBoxImmediateActionsReconstructSlopeOGSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsReconstructSlopeOGSaved);
        }
        if(checkBoxFollowUpActionsReconstructSlopeOGSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsReconstructSlopeOGSaved);
        }
        if(checkBoxImmediateActionsReconstructSlopeGeoSaved.equals("false")){
        }else{
            submitImmediateActions(checkBoxImmediateActionsReconstructSlopeGeoSaved);
        }
        if(checkBoxFollowUpActionsReconstructSlopeGeoSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsReconstructSlopeGeoSaved);
        }
        if(checkBoxFollowUpActionsInstallErosionSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsInstallErosionSaved);
        }
        if(checkBoxFollowUpActionsRepairPipeSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsRepairPipeSaved);
        }
        if(checkBoxFollowUpActionsSurveyTheSiteSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsSurveyTheSiteSaved);
        }
        if(checkBoxFollowUpActionsPerformGeologicalMappingSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsPerformGeologicalMappingSaved);
        }
        if(checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved);
        }
        if(checkBoxFollowUpActionsPerformDetailedDesignSaved.equals("false")){
        }else{
            submitFollowUpActions(checkBoxFollowUpActionsPerformDetailedDesignSaved);
        }
    }
    public void submitFollowUpActions(String s){
        compositeDisposable.add(myAPI.submitFollowUpActions(
                s,
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitImmediateActions(String s){
        compositeDisposable.add(myAPI.submitImmediateActions(
                s,
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitIncidentType(){
        compositeDisposable.add(myAPI.submitIncidentType("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitMeasurements(){
        compositeDisposable.add(myAPI.submitMeasurements(
                "",
                "",
                 "",
                "",
                "",
                "",
                "",
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitPavement_Ground_Status(){
        compositeDisposable.add(myAPI.submitPavement_Ground_Status(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitVegetationOnSlope(){
        compositeDisposable.add(myAPI.submitVegetationOnSlope(
                "",
                "",
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
    public void submitWater_Drainage(){
        compositeDisposable.add(myAPI.submitWater_Drainage(
                "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
        );
    }
}
