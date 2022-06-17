package com.example.tictactoe;

import static java.lang.Compiler.disable;

import android.widget.ImageButton;
import android.widget.TextView;

public class TicTacToe {
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


    //in - get array matt and counts to check if has a win
    //out - return message in accordance (who win or draw)
    public String checkWinner(int[][] matt, String ret ,int sumRow,int sumCol, int sumSlant, int sumSlant2){
        //check if has win at slant
        sumSlant =matt[0][0]+matt[1][1]+matt[2][2];
        sumSlant2 =matt[2][0]+matt[1][1]+matt[0][2];
        if (sumSlant==3) {
            ret = ("Player X win!");
            end = true;
            disable();
        }
        if (sumSlant==-3) {
            ret = ("Player O win!");
            end = true;
            disable();
        }
        if (sumSlant2==3) {
            ret = ("Player X win!");
            end = true;
            disable();
        }
        if (sumSlant2==-3) {
            ret = ("Player O win!");
            end = true;
            disable();
        }

        //run of every place at array matt
        for (int i = 0; i < matt.length; i++) {
            sumRow =0;
            sumCol =0;
            for (int j = 0; j < matt[i].length; j++) {
                sumRow += matt[i][j];     //check if has victory on column
                sumCol += matt[j][i];     //check if has victory on row
            }

            //if X column win
            if (sumCol == 3)
            {
                ret = ("Player X win!");
                end = true;
                disable();
            }
            //if o column win
            else if (sumCol == -3)
            {
                ret = ("Player O win!");
                end = true;
                disable();
            }
            //if X row win
            if (sumRow == 3)
            {
                ret = ("Player X win!");
                end = true;
                disable();
            }
            //if O row win
            else if (sumRow == -3)
            {
                ret = ("Player O win!");
                end = true;
                disable();
            }
        }
        //check at the end if no onw win
        gameOver++;
        if(ret.equals("WINNER?")&&gameOver==9){
            ret = ("No one win!");
            gameOver=0;
        }
        return ret;        //return the value in ret
    }
}
