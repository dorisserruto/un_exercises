package com.nhaqp.widget;

import android.app.ListActivity; //Nuevo tipo de actividad
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LAB006_Seleccion1 extends ListActivity {
	
	private TextView seleccion;
	private static final String[] items = {"abc","efg","hij"};
	
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.main_seleccion1);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
		seleccion = (TextView) this.findViewById(R.id.txtSeleccion);
		
	}
	
	public void onListItemClick(ListView parent, View v, int pos, long id){
		seleccion.setText(items[pos]); //pag.133
		
	}
}
