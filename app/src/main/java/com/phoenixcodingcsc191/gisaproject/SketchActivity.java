package com.phoenixcodingcsc191.gisaproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.byox.drawview.enums.DrawingCapture;
import com.byox.drawview.views.DrawView;
//import com.byox.drawviewproject.dialogs.SaveBitmapDialog;

public class SketchActivity extends AppCompatActivity {

    private DrawView mDrawView;
    private FloatingActionButton mFabClearDraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketch);
        nextPageButton();
        previousButtonActivity();
        saveAndExitButtonActivity();
        undoDrawButton();
        redoDrawButton();
        clearButton();
        saveSketch();

        mDrawView = (DrawView) findViewById(R.id.draw_view);

        mDrawView.setOnDrawViewListener(new DrawView.OnDrawViewListener() {
            @Override
            public void onStartDrawing() {
                // Your stuff here
            }
            @Override
            public void onEndDrawing() {
                // Your stuff here
            }
            @Override
            public void onClearDrawing() {
                // Your stuff here
            }
            @Override
            public void onRequestText() {
                // Your stuff here
            }
            @Override
            public void onAllMovesPainted() {
                // Your stuff here
            }
        });


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

    private void undoDrawButton(){
        Button undoButton = (Button) findViewById(R.id.buttonUndoSketch);
        undoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mDrawView.canUndo())
                    mDrawView.undo();
            }
        });
    }
    private void redoDrawButton(){
        Button redoButton = (Button) findViewById(R.id.buttonRedoSketch);
        redoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mDrawView.canRedo())
                    mDrawView.redo();
            }
        });
    }
    private void clearButton(){
        Button clearButton = (Button) findViewById(R.id.buttonClearSketch);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mDrawView.restartDrawing();
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

    private void saveSketch(){
        Button saveButton = (Button) findViewById(R.id.buttonSaveSketch);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                SaveBitmapDialog saveBitmapDialog = SaveBitmapDialog.newInstance();
                Object[] createCaptureResponse = mDrawView.createCapture(DrawingCapture.BITMAP);
                saveBitmapDialog.setPreviewBitmap((Bitmap) createCaptureResponse[0]);
                saveBitmapDialog.setPreviewFormat(String.valueOf(createCaptureResponse[1]));
                saveBitmapDialog.setOnSaveBitmapListener(new SaveBitmapDialog.OnSaveBitmapListener() {
                    @Override
                    public void onSaveBitmapCompleted() {
                        //Snackbar.make(mFabClearDraw, "Capture saved succesfully!", 2000).show();
                        showResponse("Capture saved succesfully!");
                    }

                    @Override
                    public void onSaveBitmapCanceled() {
                        //Snackbar.make(mFabClearDraw, "Capture saved canceled.", 2000).show();
                        showResponse("Capture saved canceled.");
                    }
                });
                saveBitmapDialog.show(getSupportFragmentManager(), "saveBitmap");
            }
        });
    }
    public void showResponse(String response){
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
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
