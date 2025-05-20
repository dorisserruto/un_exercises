package com.nhaqp.widget;

import android.app.Activity; 
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class LAB006_Seleccion3 extends Activity implements OnItemClickListener,OnItemSelectedListener{
	
	private TextView seleccion;
	private ListView lv;
	private Spinner spin;
	SparseBooleanArray selectedItems;
	
	private static final String[] items = {"abc","efg","hij"};
	
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.main_seleccion3);
		
		// Ref. Pag 153
		
		//setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,items));
		//ListView
		lv = (ListView) this.findViewById(R.id.list);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
		lv.setOnItemClickListener(this);
		
		//Spin
		spin = (Spinner) this.findViewById(R.id.spinner1);
		ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
		spin.setAdapter(adap);
		spin.setOnItemSelectedListener(this);
		
		seleccion = (TextView) this.findViewById(R.id.txtSeleccion);
		//lv = getListView(); //por ser el unico.
		//selectedItems = lv.getCheckedItemPositions();
	}
	
//	public void onListItemClick(ListView parent, View v, int pos, long id){
//		String value = "";
//		
//		for (int i=0; i < selectedItems.size(); i++){
//			if(selectedItems.get(i)){
//				String item = lv.getAdapter().getItem(selectedItems.keyAt(i)).toString();
//				value = value +" "+ item;
//			}
//		}
//		seleccion.setText(value);
//	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		seleccion.setText(items[arg2]);
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		seleccion.setText(items[arg2]);
		
	}
	public void onNothingSelected(AdapterView<?> arg0) {
		seleccion.setText("");
		
	}
}
