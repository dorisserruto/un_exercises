package com.nhaqp.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LAB005_TicTacToeActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	
	
	char valuePiece = 'X';
	int position = 0;
	char[] gameMoves = new char[9];
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn1 = (Button) this.findViewById(R.id.btn01);
        btn2 = (Button) this.findViewById(R.id.btn02);
        btn3 = (Button) this.findViewById(R.id.btn03);
        btn4 = (Button) this.findViewById(R.id.btn04);
        btn5 = (Button) this.findViewById(R.id.btn05);
        btn6 = (Button) this.findViewById(R.id.btn06);
        btn7 = (Button) this.findViewById(R.id.btn07);
        btn8 = (Button) this.findViewById(R.id.btn08);
        btn9 = (Button) this.findViewById(R.id.btn09);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

	public void onClick(View v) {
		switch (v.getId()){
		case R.id.btn01:
			position = 1;
			btn1.setText(valuePiece);
			gameMoves[0]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn02:
			position = 2;
			btn2.setText(valuePiece);
			gameMoves[1]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;	
		case R.id.btn03:
			position = 3;
			btn3.setText(valuePiece);
			gameMoves[2]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn04:
			position = 4;
			btn4.setText(valuePiece);
			gameMoves[3]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn05:
			position = 5;
			btn5.setText(valuePiece);
			gameMoves[4]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn06:
			position = 6;
			btn6.setText(valuePiece);
			gameMoves[5]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn07:
			position = 7;
			btn7.setText(valuePiece);
			gameMoves[6]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn08:
			position = 8;
			btn8.setText(valuePiece);
			gameMoves[7]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		case R.id.btn09:
			position = 9;
			btn9.setText(valuePiece);
			gameMoves[8]=valuePiece;
			if (verifyWinMove()){
				finalizeGame();
				break;
			}
			changePiece();
			break;
		}
	}
	
	private boolean verifyWinMove(){
		int posx, posy, posz;
		posx = position - 1;
		posy = (position + 1)% 3;
		posz = (position + 2)% 3;
		
		//position 2  posx 1 posy 0 posz 1
		
		//((gameMoves[0] == gameMoves[1]) && (gameMoves[1] == gameMoves[2])) || ((gameMoves[0] == gameMoves[4]) && ((gameMoves[4] == gameMoves[8])
		if ((gameMoves[posx] == gameMoves[posy]) && (gameMoves[posy] == gameMoves[posz]))
			return true;
		posy = (posy + 3)% 9;
		posz = (posz + 6)% 9;
		
		// posx1 posy3 posz 7
		if ((gameMoves[posx] == gameMoves[posy]) && (gameMoves[posy] == gameMoves[posz]))
			return true;
		posy = (posy + 2)% 9;
		posz = (posz + 4)% 9;
		if ((gameMoves[posx] == gameMoves[posy]) && (gameMoves[posy] == gameMoves[posz]))
			return true;
		return false;
	}
	
	private void changePiece(){
		if (valuePiece == 'O')
			valuePiece = 'X';
		else
			valuePiece= 'O';
	}
	
	private void finalizeGame(){
		Toast.makeText(this, "Gano jugador "+ valuePiece, Toast.LENGTH_LONG).show();
	}
}