package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class RecommendedAction extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

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
        String checkBoxImmediateActionsOpenHighwayTrafficSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"False");
        String checkBoxFollowUpActionsOpenHighwayTrafficSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"False");
        String checkBoxImmediateActionsOpenHighwayShoulderSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"False");
        String checkBoxFollowUpActionsOpenHighwayShoulderSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"False");
        String checkBoxImmediateActionsCloseHighwaySaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"False");
        String checkBoxImmediateActionsRemovedLandsideDebrisSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"False");
        String checkBoxImmediateActionsPlaceKRailSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"False");
        String checkBoxImmediateActionsCoverSlopeSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"False");
        String checkBoxImmediateActionsDivertSurfaceSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"False");
        String checkBoxImmediateActionsRemoveCulvertSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"False");
        String checkBoxImmediateActionsDewaterPumpSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"False");
        String checkBoxImmediateActionsDewaterHorizontalDrainsSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"False");
        String checkBoxFollowUpActionsDewaterHorizontalDrainsSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"False");
        String checkBoxImmediateActionsConstructTempShoringSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"False");
        String checkBoxFollowUpActionsConstructTempShoringSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"False");
        String checkBoxImmediateActionsButtressToeOfLandslideSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"False");
        String checkBoxFollowUpActionsButtressToeOfLandslideSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"False");
        String checkBoxImmediateActionsPlaceRockSlopeProtectSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"False");
        String checkBoxFollowUpActionsPlaceRockSlopeProtectSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"False");
        String checkBoxImmediateActionsRoutineVisualMonitorSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"False");
        String checkBoxFollowUpActionsRoutineVisualMonitorSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"False");
        String checkBoxImmediateActionsReconstructSlopeOGSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"False");
        String checkBoxFollowUpActionsReconstructSlopeOGSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"False");
        String checkBoxImmediateActionsReconstructSlopeGeoSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"False");
        String checkBoxFollowUpActionsReconstructSlopeGeoSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"False");
        String checkBoxFollowUpActionsInstallErosionSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"False");
        String checkBoxFollowUpActionsRepairPipeSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"False");
        String checkBoxFollowUpActionsSurveyTheSiteSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"False");
        String checkBoxFollowUpActionsPerformGeologicalMappingSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"False");
        String checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"False");
        String checkBoxFollowUpActionsPerformDetailedDesignSaved= mPreferences.getString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformDetailedDesign),"False");

        if(checkBoxImmediateActionsOpenHighwayTrafficSaved.equals("True")){
            checkBoxImmediateActionsOpenHighwayTraffic.setChecked(true);
        }else{
            checkBoxImmediateActionsOpenHighwayTraffic.setChecked(false);
        }
        if(checkBoxFollowUpActionsOpenHighwayTrafficSaved.equals("True")){
            checkBoxFollowUpActionsOpenHighwayTraffic.setChecked(true);
        }else{
            checkBoxFollowUpActionsOpenHighwayTraffic.setChecked(false);
        }
        if(checkBoxImmediateActionsOpenHighwayShoulderSaved.equals("True")){
            checkBoxImmediateActionsOpenHighwayShoulder.setChecked(true);
        }else{
            checkBoxImmediateActionsOpenHighwayShoulder.setChecked(false);
        }
        if(checkBoxFollowUpActionsOpenHighwayShoulderSaved.equals("True")){
            checkBoxFollowUpActionsOpenHighwayShoulder.setChecked(true);
        }else{
            checkBoxFollowUpActionsOpenHighwayShoulder.setChecked(false);
        }
        if(checkBoxImmediateActionsCloseHighwaySaved.equals("True")){
            checkBoxImmediateActionsCloseHighway.setChecked(true);
        }else{
            checkBoxImmediateActionsCloseHighway.setChecked(false);
        }
        if(checkBoxImmediateActionsRemovedLandsideDebrisSaved.equals("True")){
            checkBoxImmediateActionsRemovedLandsideDebris.setChecked(true);
        }else{
            checkBoxImmediateActionsRemovedLandsideDebris.setChecked(false);
        }
        if(checkBoxImmediateActionsPlaceKRailSaved.equals("True")){
            checkBoxImmediateActionsPlaceKRail.setChecked(true);
        }else{
            checkBoxImmediateActionsPlaceKRail.setChecked(false);
        }
        if(checkBoxImmediateActionsCoverSlopeSaved.equals("True")){
            checkBoxImmediateActionsCoverSlope.setChecked(true);
        }else{
            checkBoxImmediateActionsCoverSlope.setChecked(false);
        }
        if(checkBoxImmediateActionsDivertSurfaceSaved.equals("True")){
            checkBoxImmediateActionsDivertSurface.setChecked(true);
        }else{
            checkBoxImmediateActionsDivertSurface.setChecked(false);
        }
        if(checkBoxImmediateActionsRemoveCulvertSaved.equals("True")){
            checkBoxImmediateActionsRemoveCulvert.setChecked(true);
        }else{
            checkBoxImmediateActionsRemoveCulvert.setChecked(false);
        }
        if(checkBoxImmediateActionsDewaterPumpSaved.equals("True")){
            checkBoxImmediateActionsDewaterPump.setChecked(true);
        }else{
            checkBoxImmediateActionsDewaterPump.setChecked(false);
        }
        if(checkBoxImmediateActionsDewaterHorizontalDrainsSaved.equals("True")){
            checkBoxImmediateActionsDewaterHorizontalDrains.setChecked(true);
        }else{
            checkBoxImmediateActionsDewaterHorizontalDrains.setChecked(false);
        }
        if(checkBoxFollowUpActionsDewaterHorizontalDrainsSaved.equals("True")){
            checkBoxFollowUpActionsDewaterHorizontalDrains.setChecked(true);
        }else{
            checkBoxFollowUpActionsDewaterHorizontalDrains.setChecked(false);
        }
        if(checkBoxImmediateActionsConstructTempShoringSaved.equals("True")){
            checkBoxImmediateActionsConstructTempShoring.setChecked(true);
        }else{
            checkBoxImmediateActionsConstructTempShoring.setChecked(false);
        }
        if(checkBoxFollowUpActionsConstructTempShoringSaved.equals("True")){
            checkBoxFollowUpActionsConstructTempShoring.setChecked(true);
        }else{
            checkBoxFollowUpActionsConstructTempShoring.setChecked(false);
        }
        if(checkBoxImmediateActionsButtressToeOfLandslideSaved.equals("True")){
            checkBoxImmediateActionsButtressToeOfLandslide.setChecked(true);
        }else{
            checkBoxImmediateActionsButtressToeOfLandslide.setChecked(false);
        }
        if(checkBoxFollowUpActionsButtressToeOfLandslideSaved.equals("True")){
            checkBoxFollowUpActionsButtressToeOfLandslide.setChecked(true);
        }else{
            checkBoxFollowUpActionsButtressToeOfLandslide.setChecked(false);
        }
        if(checkBoxImmediateActionsPlaceRockSlopeProtectSaved.equals("True")){
            checkBoxImmediateActionsPlaceRockSlopeProtect.setChecked(true);
        }else{
            checkBoxImmediateActionsPlaceRockSlopeProtect.setChecked(false);
        }
        if(checkBoxFollowUpActionsPlaceRockSlopeProtectSaved.equals("True")){
            checkBoxFollowUpActionsPlaceRockSlopeProtect.setChecked(true);
        }else{
            checkBoxFollowUpActionsPlaceRockSlopeProtect.setChecked(false);
        }
        if(checkBoxImmediateActionsRoutineVisualMonitorSaved.equals("True")){
            checkBoxImmediateActionsRoutineVisualMonitor.setChecked(true);
        }else{
            checkBoxImmediateActionsRoutineVisualMonitor.setChecked(false);
        }
        if(checkBoxFollowUpActionsRoutineVisualMonitorSaved.equals("True")){
            checkBoxFollowUpActionsRoutineVisualMonitor.setChecked(true);
        }else{
            checkBoxFollowUpActionsRoutineVisualMonitor.setChecked(false);
        }
        if(checkBoxImmediateActionsReconstructSlopeOGSaved.equals("True")){
            checkBoxImmediateActionsReconstructSlopeOG.setChecked(true);
        }else{
            checkBoxImmediateActionsReconstructSlopeOG.setChecked(false);
        }
        if(checkBoxFollowUpActionsReconstructSlopeOGSaved.equals("True")){
            checkBoxFollowUpActionsReconstructSlopeOG.setChecked(true);
        }else{
            checkBoxFollowUpActionsReconstructSlopeOG.setChecked(false);
        }
        if(checkBoxImmediateActionsReconstructSlopeGeoSaved.equals("True")){
            checkBoxImmediateActionsReconstructSlopeGeo.setChecked(true);
        }else{
            checkBoxImmediateActionsReconstructSlopeGeo.setChecked(false);
        }
        if(checkBoxFollowUpActionsReconstructSlopeGeoSaved.equals("True")){
            checkBoxFollowUpActionsReconstructSlopeGeo.setChecked(true);
        }else{
            checkBoxFollowUpActionsReconstructSlopeGeo.setChecked(false);
        }
        if(checkBoxFollowUpActionsInstallErosionSaved.equals("True")){
            checkBoxFollowUpActionsInstallErosion.setChecked(true);
        }else{
            checkBoxFollowUpActionsInstallErosion.setChecked(false);
        }
        if(checkBoxFollowUpActionsRepairPipeSaved.equals("True")){
            checkBoxFollowUpActionsRepairPipe.setChecked(true);
        }else{
            checkBoxFollowUpActionsRepairPipe.setChecked(false);
        }
        if(checkBoxFollowUpActionsSurveyTheSiteSaved.equals("True")){
            checkBoxFollowUpActionsSurveyTheSite.setChecked(true);
        }else{
            checkBoxFollowUpActionsSurveyTheSite.setChecked(false);
        }
        if(checkBoxFollowUpActionsPerformGeologicalMappingSaved.equals("True")){
            checkBoxFollowUpActionsPerformGeologicalMapping.setChecked(true);
        }else{
            checkBoxFollowUpActionsPerformGeologicalMapping.setChecked(false);
        }
        if(checkBoxFollowUpActionsPerformSubsurfaceExplorationSaved.equals("True")){
            checkBoxFollowUpActionsPerformSubsurfaceExploration.setChecked(true);
        }else{
            checkBoxFollowUpActionsPerformSubsurfaceExploration.setChecked(false);
        }
        if(checkBoxFollowUpActionsPerformDetailedDesignSaved.equals("True")){
            checkBoxFollowUpActionsPerformDetailedDesign.setChecked(true);
        }else{
            checkBoxFollowUpActionsPerformDetailedDesign.setChecked(false);
        }

    }
    private void savePref(){
        if(checkBoxImmediateActionsOpenHighwayTraffic.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayTraffic),"False");
        }
        if(checkBoxFollowUpActionsOpenHighwayTraffic.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayTraffic),"False");
        }
        if(checkBoxImmediateActionsOpenHighwayShoulder.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsOpenHighwayShoulder),"False");
        }
        if(checkBoxFollowUpActionsOpenHighwayShoulder.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsOpenHighwayShoulder),"False");
        }
        if(checkBoxImmediateActionsCloseHighway.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCloseHighway),"False");
        }
        if(checkBoxImmediateActionsRemovedLandsideDebris.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemovedLandsideDebris),"False");
        }
        if(checkBoxImmediateActionsPlaceKRail.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceKRail),"False");
        }
        if(checkBoxImmediateActionsCoverSlope.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsCoverSlope),"False");
        }
        if(checkBoxImmediateActionsDivertSurface.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDivertSurface),"False");
        }
        if(checkBoxImmediateActionsRemoveCulvert.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRemoveCulvert),"False");
        }
        if(checkBoxImmediateActionsDewaterPump.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterPump),"False");
        }
        if(checkBoxImmediateActionsDewaterHorizontalDrains.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsDewaterHorizontalDrains),"False");
        }
        if(checkBoxFollowUpActionsDewaterHorizontalDrains.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsDewaterHorizontalDrains),"False");
        }
        if(checkBoxImmediateActionsConstructTempShoring.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsConstructTempShoring),"False");
        }
        if(checkBoxFollowUpActionsConstructTempShoring.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsConstructTempShoring),"False");
        }
        if(checkBoxImmediateActionsButtressToeOfLandslide.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsButtressToeOfLandslide),"False");
        }
        if(checkBoxFollowUpActionsButtressToeOfLandslide.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsButtressToeOfLandslide),"False");
        }
        if(checkBoxImmediateActionsPlaceRockSlopeProtect.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsPlaceRockSlopeProtect),"False");
        }
        if(checkBoxFollowUpActionsPlaceRockSlopeProtect.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPlaceRockSlopeProtect),"False");
        }
        if(checkBoxImmediateActionsRoutineVisualMonitor.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsRoutineVisualMonitor),"False");
        }
        if(checkBoxFollowUpActionsRoutineVisualMonitor.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRoutineVisualMonitor),"False");
        }
        if(checkBoxImmediateActionsReconstructSlopeOG.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeOG),"False");
        }
        if(checkBoxFollowUpActionsReconstructSlopeOG.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeOG),"False");
        }
        if(checkBoxImmediateActionsReconstructSlopeGeo.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxImmediateActionsReconstructSlopeGeo),"False");
        }
        if(checkBoxFollowUpActionsReconstructSlopeGeo.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsReconstructSlopeGeo),"False");
        }
        if(checkBoxFollowUpActionsInstallErosion.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsInstallErosion),"False");
        }
        if(checkBoxFollowUpActionsRepairPipe.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsRepairPipe),"False");
        }
        if(checkBoxFollowUpActionsSurveyTheSite.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsSurveyTheSite),"False");
        }
        if(checkBoxFollowUpActionsPerformGeologicalMapping.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformGeologicalMapping),"False");
        }
        if(checkBoxFollowUpActionsPerformSubsurfaceExploration.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"True");
        }
        else{
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformSubsurfaceExploration),"False");
        }
        if(checkBoxFollowUpActionsPerformDetailedDesign.isChecked()){
            mEditor.putString(getString(R.string.RecommendedActioncheckBoxFollowUpActionsPerformDetailedDesign),"True");
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
                startActivity(new Intent(RecommendedAction.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }

}
