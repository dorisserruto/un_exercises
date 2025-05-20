package com.nhaqp.lab02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LAB002_ActivityActivity extends Activity implements OnClickListener{
    int t = 5; //Set the integer to 5
    double p1,p2,res = 0;
    
    TextView tvR;
    Button btnMas, btnMenos;
    EditText edtRP1, edtRP2;
    
    Calculadora calc = new Calculadora(p1);
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        //+id permite colocar .id al momento de obtener el valor (ordenarlo)
        //R: referencia a resources
        tvR =(TextView) this.findViewById(R.id.tvResultado);
        //tvR.setText("hola");
        //tvR.setText(String.valueOf(t));
        
        btnMas = (Button) this.findViewById(R.id.btnMas);
        btnMas.setOnClickListener(this); //necesita "implements OnClickListener"
        
        btnMenos = (Button) this.findViewById(R.id.btnMenos);
        btnMenos.setOnClickListener(this); //necesita "implements OnClickListener"
        
        edtRP1 = (EditText) this.findViewById(R.id.edtParametro1);
        //edtRP2 = (EditText) this.findViewById(R.id.edtParametro2);
    }
    
    //onclick responde a cualquier elemento visual al click
    public void onClick(View src){
    
    	   p1 = Double.valueOf(String.valueOf(edtRP1.getText())); //gettext devuelve tipo editable
    	   //p2 = Double.valueOf(String.valueOf(edtRP2.getText())); 
    	   //res = p1 + p2;
    	   
    	   switch (src.getId()){
    	   case R.id.btnMas:
    		   calc.sumar(res,p1);
    		   break;
    	   case R.id.btnMenos:
    		   calc.restar(res,p1);
    		   break;
    	   }
    	   
    	   //calc.multiplicar(2);
    	   //calc.dividir(2);
    	   res = calc.getResultado();
    	   
           //tvR.setText("Respuesta = "+ res);
    	   tvR.setText(String.valueOf(res));
    	   edtRP1.setText("");
    }
}