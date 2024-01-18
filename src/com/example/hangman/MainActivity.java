package com.example.hangman;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {
	private TextView displayLabel, Misses;
	private Button[] pushButtons;
    HangmanLogic controller;

    String[] words = {"HANGMAN","AMERICA","KENYA","KINGKONG","HALO","FOOTBALL","DRAGON","TELEVISION","BLACKHOLE"};

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        int high = words.length, low = 0;
        int word = random.nextInt(high) + low;

        String answer = words[word];
        char[] charArray = answer.toCharArray();
        char[] trial = new char[charArray.length];

        final Button Restart = (Button) findViewById(R.id.restart);
        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
        
        pushButtons = new Button[26];
        displayLabel = (TextView) findViewById(R.id.displayLabel);
        Misses = (TextView) findViewById(R.id.Misses);

        for (int i = 0; i < charArray.length; i++) {
            trial[i] = '_';
        }

        String full = new String(trial);
        displayLabel.setText(""+full);
        Misses.setText("You start with 8 lives");
        
        controller = new HangmanLogic(pushButtons, displayLabel, Misses, charArray, trial);
        
        for (int i = 0; i< 26; i++) {
        	pushButtons[i] = (Button) findViewById(R.id.button1+i);	
        	pushButtons[i].setOnClickListener(controller);
        }
    }
}