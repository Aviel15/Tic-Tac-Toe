package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //properties
    int[][] matt = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
    private int raw;
    private int col;
    private int XorO = 1;
    private TextView res;
    private String result;
    private String ret = "WINNER?";
    private boolean end = false;
    private int gameOver = 0;

    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;
    private ImageButton imageButton9;
    //object of TicTacToe class
    TicTacToe ticTacToe = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get id
        res = findViewById(R.id.result);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);
        imageButton9 = findViewById(R.id.imageButton9);
    }
    //print the images on ImageButtons that we choose and check if has win
    public void btnCheck(View view) {
        //get id and choose the place you click on
        String tag=view.getTag().toString();
        String[] loc=tag.split(",");
        raw= Integer.parseInt(loc[0]);
        col= Integer.parseInt(loc[1]);
        //1 = X
        if(XorO == 1){
            matt[raw][col]= 1;      //use to check who win
            ((ImageButton)view).setImageResource(R.drawable.x);      //print X
            ((ImageButton)view).setEnabled(false);      //can't change this imageButton

            XorO = -1;
        }
        //-1 = O
        else{
            matt[raw][col]=  -1;          //use to check who win
            ((ImageButton)view).setImageResource(R.drawable.o);     //print O
            ((ImageButton)view).setEnabled(false);       //can't change this imageButton
            XorO = 1;
        }
        res.setText(ticTacToe.checkWinner(matt, ret,0,0,0,0));     //call to method checkWinner
    }
    //on click reset
    public void btnRes(View view) {
        //change all imageButton to default
        imageButton.setImageResource(android.R.drawable.screen_background_light);
        imageButton2.setImageResource(android.R.drawable.screen_background_light);
        imageButton3.setImageResource(android.R.drawable.screen_background_light);
        imageButton4.setImageResource(android.R.drawable.screen_background_light);
        imageButton5.setImageResource(android.R.drawable.screen_background_light);
        imageButton6.setImageResource(android.R.drawable.screen_background_light);
        imageButton7.setImageResource(android.R.drawable.screen_background_light);
        imageButton8.setImageResource(android.R.drawable.screen_background_light);
        imageButton9.setImageResource(android.R.drawable.screen_background_light);
        //can change and play on imageButton
        imageButton.setEnabled(true);
        imageButton2.setEnabled(true);
        imageButton3.setEnabled(true);
        imageButton4.setEnabled(true);
        imageButton5.setEnabled(true);
        imageButton6.setEnabled(true);
        imageButton7.setEnabled(true);
        imageButton8.setEnabled(true);
        imageButton9.setEnabled(true);
        //reset array mat for next game and reset count if game over
        for (int i = 0; i < matt.length; i++) {
            for (int j = 0; j < matt[i].length; j++) {
                matt[i][j] = 0;
            }
        }
        gameOver=0;
    }
    //in - none
    //out - when has win can't change the image of image button - when game over
    public void disable(){
        imageButton.setEnabled(false);
        imageButton2.setEnabled(false);
        imageButton3.setEnabled(false);
        imageButton4.setEnabled(false);
        imageButton5.setEnabled(false);
        imageButton6.setEnabled(false);
        imageButton7.setEnabled(false);
        imageButton8.setEnabled(false);
        imageButton9.setEnabled(false);
    }
}