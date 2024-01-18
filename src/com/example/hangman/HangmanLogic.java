package com.example.hangman;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HangmanLogic implements View.OnClickListener {
	private Button[] pushButtons;  // keep track of event sources of GUI
	private TextView displayLabel, Misses; // Know where to output
    private int lives = 8, win = 0, perform = 0;
    private char[] charArray, trial;

	public HangmanLogic(Button[] buttons, TextView out, TextView out2, char[] CharArray, char[] Trial) {
		pushButtons = buttons;
		displayLabel = out;
        Misses = out2;
        charArray = CharArray;
        trial = Trial;
	}

	public void onClick(View v) {
		for (int i = 0; i < pushButtons.length; i++) {
			if (v.getId() == pushButtons[i].getId()) {
				pushButtons[i].setEnabled(false);
                perform = 0;

                for(int j = 0; j < charArray.length; j++) {
                    if (((char) (i + 65)) == charArray[j]) {
                        trial[j] = charArray[j];
                        String full = new String(trial);
                        displayLabel.setText(""+full);
                        win++;
                        perform++;
                    }
                    if(perform == 0 && j == charArray.length - 1){
                        lives--;
                        Misses.setText(lives + " lives remaining");
                        if(lives == 0){
                            Misses.setText("No lives remaining. GAME OVER");

                            for(int k = 0; k < pushButtons.length; k++){
                                pushButtons[k].setEnabled(false);
                            }
                        }
                    }

                    if(win == charArray.length){
                        Misses.setText("You Have Won The Game");

                        for(int k = 0; k < pushButtons.length; k++){
                            pushButtons[k].setEnabled(false);
                        }
                    }
                }
			}
		} // end of for

	}

}