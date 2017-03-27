package com.rit.se.treasurehuntvuz;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StartGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        // Set where to play location text
        String whereToPlayString = getString(R.string.where_to_start);
        TextView whereToPlayTextView = (TextView) findViewById(R.id.whereToPlayTextView);
        whereToPlayTextView.setText(whereToPlayString);

        // Set random button
        String randomButtonString = getString(R.string.random_button);
        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setText(randomButtonString);
        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRandomButtonClick((Button) v);
            }
        });

        // Set file button
        String fileButtonString = getString(R.string.file_button);
        Button fileButton = (Button) findViewById(R.id.file_button);
        fileButton.setText(fileButtonString);
        fileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onFileButtonClick((Button) v);
            }
        });

        // Set resume
        String resumeButtonString = getString(R.string.resume_button);
        Button resumeButton = (Button) findViewById(R.id.resume_button);
        resumeButton.setText(resumeButtonString);
        resumeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onResumeButtonClick((Button) v);
            }
        });

        // Set resume visibility
        resumeButton.setEnabled(TreasuresSingleton.getTreasures().getResume());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        try {
            Intent mainActivityIntent = new Intent(StartGameActivity.this, MainActivity.class);
            startActivity(mainActivityIntent);
            finish();
        }
        catch(Exception exception) {
            Log.e("StartGameActivity", exception.getMessage());
        }
    }

    private void onRandomButtonClick(Button randomButton) {
        if(TreasuresSingleton.getTreasures().getResume()) {
            try {
            /*
            Intent randomActivityIntent = new Intent(StartGameActivity.this, RandomSelectionActivity.class);
            startActivity(randomActivityIntent);
            finish();
            */
            } catch (Exception exception) {
                Log.e("StartGameActivity", exception.getMessage());
            }
        }
    }

    private void onFileButtonClick(Button fileButton) {
        TextView tv = (TextView)findViewById(R.id.textView);

        File dir = Environment.getExternalStorageDirectory();

        File file = new File(dir,"text.txt");
        if(file.exists())   // check if file exist
        {
            String text = new String();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                line = br.readLine();
                tv.setText(line);

            }
            catch (IOException e) {
                tv.setText(e.toString());
            }

        }
        else
        {
            tv.setText("Sorry file doesn't exist!!");
        }

    }

    private void onResumeButtonClick(Button resumeButton) {

    }
}
