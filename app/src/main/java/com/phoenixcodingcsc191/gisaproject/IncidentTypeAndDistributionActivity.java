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
        String IncidentTypeRockSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"false");
        String IncidentTypeToppleSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"false");
        String IncidentTypeSlideSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"false");
        String IncidentTypeSpreadSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"false");
        String IncidentTypeFlowSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"false");
        String IncidentTypeCompoundSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"false");
        String IncidentTypeErosionSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"false");
        String IncidentTypeSuperfacialSloughSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"false");
        String IncidentTypeScouredToeSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"false");
        String IncidentTypeWashedoutSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"false");

        String distributionAns = mPreferences.getString(getString(R.string.IncidentTypeAndDistribRadiogroupDistribution),"");
        String highwayStatusAns = mPreferences.getString(getString(R.string.IncidentTypeAndDistribRadiogroupHighWayStatus),"");

        String pavementCheckSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"false");
        String pavementLengthSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentLength),"");
        String pavementVertDispSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentVertDisp),"");
        String pavementHoriDispSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentHoriDisp),"");
        String pavementDepthSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentDepth),"");
        String pavementSettlementSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentSettlement),"");
        String pavementBulgeSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentBulge),"");
        String pavementCheckIndentedbyRockedSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"false");
        //MATERIAL
        String MaterialRockSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialRock),"false");
        String MaterialBeddingSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialBedding),"false");
        String MaterialJointsSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialJoints),"false");
        String MaterialFractureSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialFractures),"false");
        String MaterialSoilSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSoil),"false");
        String MaterialClaySaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialClay),"");
        String MaterialSiltSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSilt),"");
        String MaterialSandSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialSand),"");
        String MaterialGravelSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribMaterialGravel),"");


        //Water Content
        String WaterContentDrySaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentDry),"false");
        String WaterContentMoistSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentMoist),"false");
        String WaterContentWetSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentWet),"false");
        String WaterContentFlowingSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentFlowing),"false");
        String WaterContentSeepSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentSeeping),"false");
        String WaterContentSpringSaved =  mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterContentSpring),"false");
        //VEGETATION
        String VegetationTreesSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribVegetationTree),"");
        String VegetationBushesCoverSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribVegetationBushes),"");
        String VegetationGroundCoverSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribVegetationGroundCover),"");
        //WATER DRAINAGE
        String WaterDrainageCloggedSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainClogged),"false");
        String WaterDrainageCompromiseSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainCompromised),"false");
        String WaterDrainageSurfaceSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainSurface),"false");
        String WaterDrainageTorrentSaved = mPreferences.getString(getString(R.string.IncidentTypeAndDistribWaterDrainTorrent),"false");
        //INCIDENT  TYPE
        if(IncidentTypeRockSaved.equals("false")){
            IncidentTypeRock.setChecked(false);
        }else{
            IncidentTypeRock.setChecked(true);
        }
        if(IncidentTypeToppleSaved.equals("false")){
            IncidentTypeTopple.setChecked(false);
        }else{
            IncidentTypeTopple.setChecked(true);
        }
        if(IncidentTypeSlideSaved.equals("false")){
            IncidentTypeSlide.setChecked(false);
        }else{
            IncidentTypeSlide.setChecked(true);
        }
        if(IncidentTypeSpreadSaved.equals("false")){
            IncidentTypeSpread.setChecked(false);
        }else{
            IncidentTypeSpread.setChecked(true);
        }
        if(IncidentTypeFlowSaved.equals("false")){
            IncidentTypeFlow.setChecked(false);
        }else{
            IncidentTypeFlow.setChecked(true);
        }
        if(IncidentTypeCompoundSaved.equals("false")){
            IncidentTypeCompound.setChecked(false);
        }else{
            IncidentTypeCompound.setChecked(true);
        }
        if(IncidentTypeErosionSaved.equals("false")){
            IncidentTypeErosion.setChecked(false);
        }else{
            IncidentTypeErosion.setChecked(true);
        }
        if(IncidentTypeSuperfacialSloughSaved.equals("false")){
            IncidentTypeSuperfacialSlough.setChecked(false);
        }else{
            IncidentTypeSuperfacialSlough.setChecked(true);
        }
        if(IncidentTypeScouredToeSaved.equals("false")){
            IncidentTypeScouredToe.setChecked(false);
        }else{
            IncidentTypeScouredToe.setChecked(true);
        }
        if(IncidentTypeWashedoutSaved.equals("false")){
            IncidentTypeWashedout.setChecked(false);
        }else{
            IncidentTypeWashedout.setChecked(true);
        }
        if(distributionAns.equals("Advancing")){
            advancing.setChecked(false);
        }else if(distributionAns.equals("Retrogressing")) {
            retrogressing.setChecked(false);
        }else if(distributionAns.equals("Enlarging")){
            enlarging.setChecked(false);
        }else if(distributionAns.equals("Widening")){
            widening.setChecked(false);
        }else if(distributionAns.equals("Moving")){
            moving.setChecked(false);
        }else if(distributionAns.equals("Combined")){
            combined.setChecked(false);
        }
        if(highwayStatusAns.equals("Open")){
            open.setChecked(false);
        }else if(highwayStatusAns.equals("Shoulder Closed")) {
            shoulderclosed.setChecked(false);
        }else if(highwayStatusAns.equals("Lane Closed")){
            laneclosed.setChecked(false);
        }else if(highwayStatusAns.equals("One-way Closed")){
            onewayclosed.setChecked(false);
        }else if(highwayStatusAns.equals("Two-way Closed")){
            twowayclosed.setChecked(false);
        }
        //Toast.makeText(this,distributionAns, Toast.LENGTH_LONG).show();
        //PAVEMENT
        if(pavementCheckSaved.equals("false")){
            paymentCrack.setChecked(false);
        }else {
            paymentCrack.setChecked(true);
        }
        length.setText(pavementLengthSaved);
        verticalDisp.setText(pavementVertDispSaved);
        horizontalDisp.setText(pavementHoriDispSaved);
        depthCrack.setText(pavementDepthSaved);
        settlement.setText(pavementSettlementSaved);
        bulge.setText(pavementBulgeSaved);
        if(pavementCheckIndentedbyRockedSaved.equals("false")){
            IndentedbyRocks.setChecked(false);
        }else {
            IndentedbyRocks.setChecked(true);
        }
        //MATERIAL
        if(MaterialRockSaved.equals("false")){
            MaterialRock.setChecked(false);
        }else {
            MaterialRock.setChecked(true);
        }
        if(MaterialBeddingSaved.equals("false")){
            MaterialBedding.setChecked(false);
        }else {
            MaterialBedding.setChecked(true);
        }
        if(MaterialJointsSaved.equals("false")){
            MaterialJoints.setChecked(false);
        }else {
            MaterialJoints.setChecked(true);
        }
        if(MaterialFractureSaved.equals("false")){
            MaterialFractures.setChecked(false);
        }else {
            MaterialFractures.setChecked(true);
        }
        if(MaterialSoilSaved.equals("false")){
            MaterialSoil.setChecked(false);
        }else {
            MaterialSoil.setChecked(true);
        }
        MaterialClay.setText(MaterialClaySaved);
        MaterialSilt.setText(MaterialSiltSaved);
        MaterialSand.setText(MaterialSandSaved);
        MaterialGravel.setText(MaterialGravelSaved);
        //WATER CONTENT
        if(WaterContentDrySaved.equals("false")){
            WaterContentDry.setChecked(false);
        }else{
            WaterContentDry.setChecked(true);
        }
        if(WaterContentMoistSaved.equals("false")){
            WaterContentMoist.setChecked(false);
        }else{
            WaterContentMoist.setChecked(true);
        }
        if(WaterContentWetSaved.equals("false")){
            WaterContentWet.setChecked(false);
        }else{
            WaterContentWet.setChecked(true);
        }
        if(WaterContentFlowingSaved.equals("false")){
            WaterContentFlowing.setChecked(false);
        }else{
            WaterContentFlowing.setChecked(true);
        }
        if(WaterContentSeepSaved.equals("false")){
            WaterContentSeep.setChecked(false);
        }else{
            WaterContentSeep.setChecked(true);
        }
        if(WaterContentSpringSaved.equals("false")){
            WaterContentSpring.setChecked(false);
        }else{
            WaterContentSpring.setChecked(true);
        }
        //VEGATION
        VegetationSlopeTrees.setText(VegetationTreesSaved);
        VegetationSlopeTreesSlopGroundCover.setText(VegetationGroundCoverSaved);
        VegetationSlopeTreesSlopeBushes.setText(VegetationBushesCoverSaved);
        //WATER DRAINAGE
        if(WaterDrainageCloggedSaved.equals("false")){
            WaterDrainageCloggedInlet.setChecked(false);
        }else{
            WaterDrainageCloggedInlet.setChecked(true);
        }
        if(WaterDrainageCompromiseSaved.equals("false")){
            WaterDrainageCompromisedDrains.setChecked(false);
        }else{
            WaterDrainageCompromisedDrains.setChecked(true);
        }
        if(WaterDrainageSurfaceSaved.equals("false")){
            WaterDrainageSurfaceDrain.setChecked(false);
        }else{
            WaterDrainageSurfaceDrain.setChecked(true);
        }
        if(WaterDrainageTorrentSaved.equals("false")){
            WaterDrainageTorrent.setChecked(false);
        }else{
            WaterDrainageTorrent.setChecked(true);
        }

    }
    private void pushtoSavePref(){
        //IncidentType
        if(IncidentTypeRock.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"(Rock) Fall");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"false");
        }
        if(IncidentTypeTopple.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"Topple");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeTopple),"false");
        }
        if(IncidentTypeSlide.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"Slide");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSlide),"false");
        }
        if(IncidentTypeSpread.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"Spread");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSpread),"false");
        }
        if(IncidentTypeFlow.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"Flow");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeFlow),"false");
        }
        if(IncidentTypeCompound.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"Compound");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeCompound),"false");
        }
        if(IncidentTypeErosion.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"Erosion");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeErosion),"false");
        }
        if(IncidentTypeSuperfacialSlough.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"Surfacial Sloughing");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeSuperfacialSlough),"false");
        }
        if(IncidentTypeScouredToe.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"Scoured Toe");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeScouredToe),"false");
        }
        if(IncidentTypeWashedout.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"Washedout");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentWashedout),"false");
        }
        //DISTRIBUTIONS RADIO GROUP
        int distributionbuttonID = distribution.getCheckedRadioButtonId();
        String distributionAns = "";
        if (distributionbuttonID == -1){
            distributionAns = "false";
        }
        else{
            RadioButton distributionButton = (RadioButton) findViewById(distributionbuttonID);
            distributionAns = distributionButton.getText().toString();
        }
        //HIGHWAY STATUS RADIO GROUP
        int highwaystatusbuttoncheckID = highwayStatus.getCheckedRadioButtonId();
        String highwayStatusAns = "";
        if (highwaystatusbuttoncheckID == -1){
            highwayStatusAns = "false";
        }
        else{
            RadioButton highwaystatusChcked = (RadioButton) findViewById(highwaystatusbuttoncheckID);
            highwayStatusAns = highwaystatusChcked.getText().toString();
        }
        mEditor.putString(getString(R.string.IncidentTypeAndDistribRadiogroupHighWayStatus),highwayStatusAns);
        mEditor.putString(getString(R.string.IncidentTypeAndDistribRadiogroupDistribution),distributionAns);

        //PAVEMENT
        if(paymentCrack.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"Pavement/Ground Cracks");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentCheckbox),"false");
        }
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentLength),length.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentVertDisp),verticalDisp.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentHoriDisp),horizontalDisp.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentDepth),depthCrack.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentSettlement),settlement.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentBulge),bulge.getText().toString());
        if(IndentedbyRocks.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"Indented By Rocks");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribPaymentRockIndentCheckbox),"false");
        }

        //MATERIAL
        if(MaterialRock.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"Rock");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribCheckBoxIncidentTypeRock),"false");
        }
        if(MaterialBedding.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialBedding),"Bedding");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialBedding),"false");
        }
        if(MaterialJoints.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialJoints),"Joints");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialJoints),"false");
        }
        if(MaterialFractures.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialFractures),"Fractures");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialFractures),"false");
        }
        if(MaterialSoil.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSoil),"Soil");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSoil),"false");
        }
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialClay),MaterialClay.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSilt),MaterialSilt.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialSand),MaterialSand.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribMaterialGravel),MaterialGravel.getText().toString());
        //Water Content
        if(WaterContentDry.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentDry),"Dry");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentDry),"false");
        }
        if(WaterContentMoist.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentMoist),"Moist");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentMoist),"false");
        }
        if(WaterContentWet.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentWet),"Wet");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentWet),"false");
        }
        if(WaterContentFlowing.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentFlowing),"Flowing");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentFlowing),"false");
        }
        if(WaterContentSeep.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSeeping),"Seep");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSeeping),"false");
        }
        if(WaterContentSpring.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSpring),"Spring");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterContentSpring),"false");
        }
        //VEGATION
        mEditor.putString(getString(R.string.IncidentTypeAndDistribVegetationTree),VegetationSlopeTrees.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribVegetationBushes),VegetationSlopeTreesSlopeBushes.getText().toString());
        mEditor.putString(getString(R.string.IncidentTypeAndDistribVegetationGroundCover),VegetationSlopeTreesSlopGroundCover.getText().toString());
        //WATER DRAINAGE
        if(WaterDrainageCloggedInlet.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainClogged),"Clogged Inlet");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainClogged),"false");
        }
        if(WaterDrainageCompromisedDrains.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainCompromised),"Compromise Drains");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainCompromised),"false");
        }
        if(WaterDrainageSurfaceDrain.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainSurface),"Surface Runoff");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainSurface),"false");
        }
        if(WaterDrainageTorrent.isChecked()){
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainTorrent),"Torrent, Surge, Flood");
        }
        else{
            mEditor.putString(getString(R.string.IncidentTypeAndDistribWaterDrainTorrent),"false");
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
