package com.nhaqp.widget;

import android.app.Activity; 
import android.os.Bundle;
import android.widget.TabHost;


public class LAB006_Tabs extends Activity{
	//Pag 185 - 196
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.main_tabs);
		
		TabHost tabs = (TabHost) this.findViewById(R.id.tabhost);
		tabs.setup();
		
		TabHost.TabSpec spec = tabs.newTabSpec("tab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("Clock");
		
		tabs.addTab(spec); //Agrega el 1erTab
		
		TabHost.TabSpec spec2 = tabs.newTabSpec("tab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Button");
		
		tabs.addTab(spec2); //Agrega el 2doTab
	}
}
