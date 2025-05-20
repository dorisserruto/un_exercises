package com.nhaqp.widget;

import android.app.ListActivity; 
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LAB006_Seleccion2 extends ListActivity {
	
	private TextView seleccion;
	private ListView lv;
	SparseBooleanArray selectedItems;
	
	private static final String[] items = {"abc","efg","hij"};
	
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.main_seleccion2);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,items));
		
		seleccion = (TextView) this.findViewById(R.id.txtSeleccion);
		lv = getListView(); //por ser el unico.
		selectedItems = lv.getCheckedItemPositions();
	}
	
	public void onListItemClick(ListView parent, View v, int pos, long id){
		String value = "";
		
		for (int i=0; i < selectedItems.size(); i++){
			if(selectedItems.get(i)){
				String item = lv.getAdapter().getItem(selectedItems.keyAt(i)).toString();
				value = value +" "+ item;
			}
		}
		seleccion.setText(value);
		
	}
}
