package com.phoenixcodingcsc191.gisaproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class IncidentTypeAndDistributionActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private CheckBox IncidentTypeRock;
    private CheckBox IncidentTypeTopple;
    private CheckBox IncidentTypeSlide;
    private CheckBox IncidentTypeSpread;
    private CheckBox IncidentTypeFlow;
    private CheckBox IncidentTypeCompound;
    private CheckBox IncidentTypeErosion;
    private CheckBox IncidentTypeSuperfacialSlough;
    private CheckBox IncidentTypeScouredToe;
    private CheckBox IncidentTypeWashedout;

    private RadioGroup distribution;
    private RadioButton advancing;
    private RadioButton retrogressing;
    private RadioButton enlarging;
    private RadioButton widening;
    private RadioButton moving;
    private RadioButton combined;

    private RadioGroup highwayStatus;
    private RadioButton open;
    private RadioButton shoulderclosed;
    private RadioButton laneclosed;
    private RadioButton onewayclosed;
    private RadioButton twowayclosed;

    private CheckBox paymentCrack;
    private EditText length;
    private EditText verticalDisp;
    private EditText horizontalDisp;
    private EditText depthCrack;
    private EditText settlement;
    private EditText bulge;
    private CheckBox IndentedbyRocks;

    private CheckBox MaterialRock;
    private CheckBox MaterialBedding;
    private CheckBox MaterialJoints;
    private CheckBox MaterialFractures;
    private CheckBox MaterialSoil;
    private EditText MaterialClay;
    private EditText MaterialSilt;
    private EditText MaterialSand;
    private EditText MaterialGravel;

    private CheckBox WaterContentDry;
    private CheckBox WaterContentMoist;
    private CheckBox WaterContentWet;
    private CheckBox WaterContentFlowing;
    private CheckBox WaterContentSeep;
    private CheckBox WaterContentSpring;

    private EditText VegetationSlopeTrees;
    private EditText VegetationSlopeTreesSlopeBushes;
    private EditText VegetationSlopeTreesSlopGroundCover;

    private CheckBox WaterDrainageCloggedInlet;
    private CheckBox WaterDrainageCompromisedDrains;
    private CheckBox WaterDrainageSurfaceDrain;
    private CheckBox WaterDrainageTorrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_type_and_distribution);

        IncidentTypeRock = findViewById(R.id.checkBoxRockIT);
        IncidentTypeTopple= findViewById(R.id.checkBoxToppleIT);
        IncidentTypeSlide = findViewById(R.id.checkBoxSlideIT);
        IncidentTypeSpread = findViewById(R.id.checkBoxSpreadIT);
        IncidentTypeFlow = findViewById(R.id.checkBoxFlowIT);
        IncidentTypeCompound = findViewById(R.id.checkBoxCompoundIT);
        IncidentTypeErosion = findViewById(R.id.checkBoxErosionIT);
        IncidentTypeSuperfacialSlough = findViewById(R.id.checkBoxSuperFacialIT);
        IncidentTypeScouredToe = findViewById(R.id.checkBoxScouredToeIT);
        IncidentTypeWashedout = findViewById(R.id.checkBoxWashOutIT);

        distribution = findViewById(R.id.radioGroupDistribIT);
        advancing = findViewById(R.id.radioButtonAdvancingIT);
        retrogressing = findViewById(R.id.radioButtonRetrogressingIT);
        enlarging = findViewById(R.id.radioButtonEnlargingIT);
        widening = findViewById(R.id.radioButtonWideningIT);
        moving = findViewById(R.id.radioButtonMovingIT);
        combined = findViewById(R.id.radioButtonCombinedIT);

        highwayStatus = findViewById(R.id.radioGroupHighWayStatusIT);
        open = findViewById(R.id.radioButtonOpenIT);
        shoulderclosed = findViewById(R.id.radioButtonShoulderClosedIT);
        laneclosed = findViewById(R.id.radioButtonLaneClosedIT);
        onewayclosed = findViewById(R.id.radioButtonOneWayClosedIT);
        twowayclosed = findViewById(R.id.radioButtonTwoWayClosedIT);

        paymentCrack = findViewById(R.id.checkBoxPavementStatusIT);
        length = findViewById(R.id.editTextFeetLengthIT);
        verticalDisp = findViewById(R.id.editTextInchesVertDisIT);
        horizontalDisp = findViewById(R.id.editTextInchesHorizDisIT);
        depthCrack = findViewById(R.id.editTextInchesDepthCrackIT);
        settlement = findViewById(R.id.editTextSettlementInchIT);
        bulge = findViewById(R.id.editTextBulgeIT);
        IndentedbyRocks = findViewById(R.id.checkBoxIndentRocksIT);

        MaterialRock = findViewById(R.id.checkBoxMatRockIT);
        MaterialBedding = findViewById(R.id.checkBoxMatBeddingIT);
        MaterialJoints = findViewById(R.id.checkBoxMatJointsIT);
        MaterialFractures = findViewById(R.id.checkBoxMatFacturesIT);
        MaterialSoil = findViewById(R.id.checkBoxMatSoilIT);
        MaterialClay = findViewById(R.id.editTextClayPercIT);
        MaterialSilt = findViewById(R.id.editTextSiltPercIT);
        MaterialSand = findViewById(R.id.editTextSandPercIT);
        MaterialGravel = findViewById(R.id.editTextGravPercIT);

        WaterContentDry = findViewById(R.id.checkBoxWaterContentDryIT);
        WaterContentMoist = findViewById(R.id.checkBoxWaterContentMoistIT);
        WaterContentWet = findViewById(R.id.checkBoxWaterContentWetIT);
        WaterContentFlowing = findViewById(R.id.checkBoxWaterContentFlowingIT);
        WaterContentSeep = findViewById(R.id.checkBoxWaterContentSeepIT);
        WaterContentSpring = findViewById(R.id.checkBoxWaterContentSpringIT);

        VegetationSlopeTrees = findViewById(R.id.editTextTreeCoverageIT);
        VegetationSlopeTreesSlopeBushes = findViewById(R.id.editTextBushesCoverageIT);
        VegetationSlopeTreesSlopGroundCover = findViewById(R.id.editTextGroundCoverageIT);

        WaterDrainageCloggedInlet = findViewById(R.id.checkBoxCloggedInletIT);
        WaterDrainageCompromisedDrains = findViewById(R.id.checkBoxCompromiseDrainsIT);
        WaterDrainageSurfaceDrain = findViewById(R.id.checkBoxSurfaceDrainsIT);
        WaterDrainageTorrent = findViewById(R.id.checkBoxTorrentSurgeFloodIT);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreference();
        saveAndExitButtonActivity();
        backButtonActivity();
        nextButtonActivity();
    }

    private void checkSharedPreference() {
        String IncidentTypeRockSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"False");
        String IncidentTypeToppleSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"False");
        String IncidentTypeSlideSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"False");
        String IncidentTypeSpreadSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"False");
        String IncidentTypeFlowSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"False");
        String IncidentTypeCompoundSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"False");
        String IncidentTypeErosionSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"False");
        String IncidentTypeSuperfacialSloughSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"False");
        String IncidentTypeScouredToeSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"False");
        String IncidentTypeWashedoutSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"False");

        String distributionAns = mPreferences.getString(getString(R.string.IncidentTypeAndDistribRadiogroupDistribution),"");
        String highwayStatusAns = mPreferences.getString(getString(R.string.IncidentTypeAndDistribRadiogroupHighWayStatus),"");

        String pavementCheckSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"False");
        String pavementLengthSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentLength),"");
        String pavementVertDispSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentVertDisp),"");
        String pavementHoriDispSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentHoriDisp),"");
        String pavementDepthSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentDepth),"");
        String pavementSettlementSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentSettlement),"");
        String pavementBulgeSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentBulge),"");
        String pavementCheckIndentedbyRockedSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"False");
        //MATERIAL
        String MaterialRockSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialRock),"False");
        String MaterialBeddingSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialBedding),"False");
        String MaterialJointsSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialJoints),"False");
        String MaterialFractureSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialFractures),"False");
        String MaterialSoilSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSoil),"False");
        String MaterialClaySaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialClay),"False");
        String MaterialSiltSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSilt),"False");
        String MaterialSandSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSand),"False");
        String MaterialGravelSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialGravel),"False");


        //Water Content
        String WaterContentDrySaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentDry),"False");
        String WaterContentMoistSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentMoist),"False");
        String WaterContentWetSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentWet),"False");
        String WaterContentFlowingSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentFlowing),"False");
        String WaterContentSeepSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentSeeping),"False");
        String WaterContentSpringSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentSpring),"False");
        //VEGETATION
        String VegetationTreesSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribVegetationTree),"");
        String VegetationBushesCoverSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribVegetationBushes),"");
        String VegetationGroundCoverSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribVegetationGroundCover),"");
        //WATER DRAINAGE
        String WaterDrainageCloggedSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainClogged),"False");
        String WaterDrainageCompromiseSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainCompromised),"False");
        String WaterDrainageSurfaceSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainSurface),"False");
        String WaterDrainageTorrentSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainTorrent),"False");
        //INCIDENT  TYPE
        if(IncidentTypeRockSaved.equals("True")){
            IncidentTypeRock.setChecked(true);
        }else{
            IncidentTypeRock.setChecked(false);
        }
        if(IncidentTypeToppleSaved.equals("True")){
            IncidentTypeTopple.setChecked(true);
        }else{
            IncidentTypeTopple.setChecked(false);
        }
        if(IncidentTypeSlideSaved.equals("True")){
            IncidentTypeSlide.setChecked(true);
        }else{
            IncidentTypeSlide.setChecked(false);
        }
        if(IncidentTypeSpreadSaved.equals("True")){
            IncidentTypeSpread.setChecked(true);
        }else{
            IncidentTypeSpread.setChecked(false);
        }
        if(IncidentTypeFlowSaved.equals("True")){
            IncidentTypeFlow.setChecked(true);
        }else{
            IncidentTypeFlow.setChecked(false);
        }
        if(IncidentTypeCompoundSaved.equals("True")){
            IncidentTypeCompound.setChecked(true);
        }else{
            IncidentTypeCompound.setChecked(false);
        }
        if(IncidentTypeErosionSaved.equals("True")){
            IncidentTypeErosion.setChecked(true);
        }else{
            IncidentTypeErosion.setChecked(false);
        }
        if(IncidentTypeSuperfacialSloughSaved.equals("True")){
            IncidentTypeSuperfacialSlough.setChecked(true);
        }else{
            IncidentTypeSuperfacialSlough.setChecked(false);
        }
        if(IncidentTypeScouredToeSaved.equals("True")){
            IncidentTypeScouredToe.setChecked(true);
        }else{
            IncidentTypeScouredToe.setChecked(false);
        }
        if(IncidentTypeWashedoutSaved.equals("True")){
            IncidentTypeWashedout.setChecked(true);
        }else{
            IncidentTypeWashedout.setChecked(false);
        }
        if(distributionAns.equals("Advancing")){
            advancing.setChecked(true);
        }else if(distributionAns.equals("Retrogressing")) {
            retrogressing.setChecked(true);
        }else if(distributionAns.equals("Enlarging")){
            enlarging.setChecked(true);
        }else if(distributionAns.equals("Widening")){
            widening.setChecked(true);
        }else if(distributionAns.equals("Moving")){
            moving.setChecked(true);
        }else if(distributionAns.equals("Combined")){
            combined.setChecked(true);
        }
        if(highwayStatusAns.equals("Open")){
            open.setChecked(true);
        }else if(highwayStatusAns.equals("Shoulder Closed")) {
            shoulderclosed.setChecked(true);
        }else if(highwayStatusAns.equals("Lane Closed")){
            laneclosed.setChecked(true);
        }else if(highwayStatusAns.equals("One-way Closed")){
            onewayclosed.setChecked(true);
        }else if(highwayStatusAns.equals("Two-way Closed")){
            twowayclosed.setChecked(true);
        }
        //Toast.makeText(this,distributionAns, Toast.LENGTH_LONG).show();
        //PAVEMENT
        if(pavementCheckSaved.equals("True")){
            paymentCrack.setChecked(true);
        }else {
            paymentCrack.setChecked(false);
        }
        length.setText(pavementLengthSaved);
        verticalDisp.setText(pavementVertDispSaved);
        horizontalDisp.setText(pavementHoriDispSaved);
        depthCrack.setText(pavementDepthSaved);
        settlement.setText(pavementSettlementSaved);
        bulge.setText(pavementBulgeSaved);
        if(pavementCheckIndentedbyRockedSaved.equals("True")){
            IndentedbyRocks.setChecked(true);
        }else {
            IndentedbyRocks.setChecked(false);
        }
        //MATERIAL
        if(MaterialRockSaved.equals("True")){
            MaterialRock.setChecked(true);
        }else {
            MaterialRock.setChecked(false);
        }
        if(MaterialBeddingSaved.equals("True")){
            MaterialBedding.setChecked(true);
        }else {
            MaterialBedding.setChecked(false);
        }
        if(MaterialJointsSaved.equals("True")){
            MaterialJoints.setChecked(true);
        }else {
            MaterialJoints.setChecked(false);
        }
        if(MaterialFractureSaved.equals("True")){
            MaterialFractures.setChecked(true);
        }else {
            MaterialFractures.setChecked(false);
        }
        if(MaterialSoilSaved.equals("True")){
            MaterialSoil.setChecked(true);
        }else {
            MaterialSoil.setChecked(false);
        }
        MaterialClay.setText(MaterialClaySaved);
        MaterialSilt.setText(MaterialSiltSaved);
        MaterialSand.setText(MaterialSandSaved);
        MaterialGravel.setText(MaterialGravelSaved);
        //WATER CONTENT
        if(WaterContentDrySaved.equals("True")){
            WaterContentDry.setChecked(true);
        }else{
            WaterContentDry.setChecked(false);
        }
        if(WaterContentMoistSaved.equals("True")){
            WaterContentMoist.setChecked(true);
        }else{
            WaterContentMoist.setChecked(false);
        }
        if(WaterContentWetSaved.equals("True")){
            WaterContentWet.setChecked(true);
        }else{
            WaterContentWet.setChecked(false);
        }
        if(WaterContentFlowingSaved.equals("True")){
            WaterContentFlowing.setChecked(true);
        }else{
            WaterContentFlowing.setChecked(false);
        }
        if(WaterContentSeepSaved.equals("True")){
            WaterContentSeep.setChecked(true);
        }else{
            WaterContentSeep.setChecked(false);
        }
        if(WaterContentSpringSaved.equals("True")){
            WaterContentSpring.setChecked(true);
        }else{
            WaterContentSpring.setChecked(false);
        }
        //VEGATION
        VegetationSlopeTrees.setText(VegetationTreesSaved);
        VegetationSlopeTreesSlopGroundCover.setText(VegetationGroundCoverSaved);
        VegetationSlopeTreesSlopeBushes.setText(VegetationBushesCoverSaved);
        //WATER DRAINAGE
        if(WaterDrainageCloggedSaved.equals("True")){
            WaterDrainageCloggedInlet.setChecked(true);
        }else{
            WaterDrainageCloggedInlet.setChecked(false);
        }
        if(WaterDrainageCompromiseSaved.equals("True")){
            WaterDrainageCompromisedDrains.setChecked(true);
        }else{
            WaterDrainageCompromisedDrains.setChecked(false);
        }
        if(WaterDrainageSurfaceSaved.equals("True")){
            WaterDrainageSurfaceDrain.setChecked(true);
        }else{
            WaterDrainageSurfaceDrain.setChecked(false);
        }
        if(WaterDrainageTorrentSaved.equals("True")){
            WaterDrainageTorrent.setChecked(true);
        }else{
            WaterDrainageTorrent.setChecked(false);
        }

    }
    private void pushtoSavePref(){
        //IncidentType
        if(IncidentTypeRock.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"False");
        }
        if(IncidentTypeTopple.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"False");
        }
        if(IncidentTypeSlide.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"False");
        }
        if(IncidentTypeSpread.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"False");
        }
        if(IncidentTypeFlow.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"False");
        }
        if(IncidentTypeCompound.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"False");
        }
        if(IncidentTypeErosion.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"False");
        }
        if(IncidentTypeSuperfacialSlough.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"False");
        }
        if(IncidentTypeScouredToe.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"False");
        }
        if(IncidentTypeWashedout.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"False");
        }
        //DISTRIBUTIONS RADIO BUTTONS
        int distributionbuttonID = distribution.getCheckedRadioButtonId();
        RadioButton distributionButton = (RadioButton) findViewById(distributionbuttonID);
        String distributionAns = distributionButton.getText().toString();
        //HIGHWAY STATUS RADIO BUTTONS
        int highwaystatusbuttoncheckID = highwayStatus.getCheckedRadioButtonId();
        RadioButton highwaystatusChcked = (RadioButton) findViewById(highwaystatusbuttoncheckID);
        String highwayStatusAns = highwaystatusChcked.getText().toString();
        mEditor.putString(getString(R.string.IncidentTypeAndDistribRadiogroupHighWayStatus),highwayStatusAns);
        mEditor.putString(getString(R.string.IncidentTypeAndDistribRadiogroupDistribution),distributionAns);

        //PAVEMENT
        if(paymentCrack.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"False");
        }
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentLength),length.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentVertDisp),verticalDisp.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentHoriDisp),horizontalDisp.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentDepth),depthCrack.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentSettlement),settlement.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentBulge),bulge.getText().toString());
        if(IndentedbyRocks.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"False");
        }

        //MATERIAL
        if(MaterialRock.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"False");
        }
        if(MaterialBedding.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialBedding),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialBedding),"False");
        }
        if(MaterialJoints.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialJoints),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialJoints),"False");
        }
        if(MaterialFractures.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialFractures),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialFractures),"False");
        }
        if(MaterialSoil.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSoil),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSoil),"False");
        }
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialClay),MaterialClay.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSilt),MaterialSilt.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSand),MaterialSand.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialGravel),MaterialGravel.getText().toString());
        //Water Content
        if(WaterContentDry.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentDry),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentDry),"False");
        }
        if(WaterContentMoist.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentMoist),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentMoist),"False");
        }
        if(WaterContentWet.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentWet),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentWet),"False");
        }
        if(WaterContentFlowing.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentFlowing),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentFlowing),"False");
        }
        if(WaterContentSeep.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSeeping),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSeeping),"False");
        }
        if(WaterContentSpring.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSpring),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSpring),"False");
        }
        //VEGATION
        mEditor.putString(getString(R.string.IncidentTypeAndDistribVegetationTree),VegetationSlopeTrees.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribVegetationBushes),VegetationSlopeTreesSlopeBushes.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribVegetationGroundCover),VegetationSlopeTreesSlopGroundCover.getText().toString());
        //WATER DRAINAGE
        if(WaterDrainageCloggedInlet.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainClogged),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainClogged),"False");
        }
        if(WaterDrainageCompromisedDrains.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainCompromised),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainCompromised),"False");
        }
        if(WaterDrainageSurfaceDrain.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainSurface),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainSurface),"False");
        }
        if(WaterDrainageTorrent.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainTorrent),"True");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainTorrent),"False");
        }
        mEditor.commit();
    }
    @Override public void onBackPressed(){}

    private void nextButtonActivity(){
        Button nextButton = (Button) findViewById(R.id.buttonNextIT);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pushtoSavePref();
                startActivity(new Intent(IncidentTypeAndDistributionActivity.this, MeasurementScreenActivity.class));
                finish();
            }
        });
    }
    private void saveAndExitButtonActivity(){
        Button saveAndExitButton = (Button) findViewById(R.id.buttonSaveIncidentType);
        saveAndExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pushtoSavePref();
                startActivity(new Intent(IncidentTypeAndDistributionActivity.this, IncidentOptionsActivity.class));
                finish();
            }
        });
    }
    private void backButtonActivity(){
        Button backButton = (Button) findViewById(R.id.buttonBackIT);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pushtoSavePref();
                startActivity(new Intent(IncidentTypeAndDistributionActivity.this, SiteInformationActivity.class));
                finish();
            }
        });
    }
}
