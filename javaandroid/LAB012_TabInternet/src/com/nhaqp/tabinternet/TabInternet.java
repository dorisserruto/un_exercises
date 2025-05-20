package com.nhaqp.tabinternet;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabInternet extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TabHost host = getTabHost();
        
        //Tab1
        Intent i = new Intent(this,NHBrowser.class);
        i.putExtra("URL", "http://www.android.com");
        host.addTab(host.newTabSpec("tab1")
        		.setIndicator("android")
        		.setContent(i));
        
        //Tab2
        Intent j = new Intent(this,NHBrowser.class);
        j.putExtra("URL", "http://www.microsoft.com");
        host.addTab(host.newTabSpec("tab2")
        		.setIndicator("microsoft")
        		.setContent(j));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

    
}
