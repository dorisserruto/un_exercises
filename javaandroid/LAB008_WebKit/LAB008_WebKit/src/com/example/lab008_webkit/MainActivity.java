package com.example.lab008_webkit;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	WebView browser;
	
	//Ref Pag 205
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        browser = (WebView) this.findViewById(R.id.webView1);
        //browser.loadUrl("http://www.google.com/");
        //browser.loadData("<html><body>Hello World</body></html>","text/html","UTF-8");
        browser.setWebViewClient(new Callback());
        this.loadTime();
    }

    //Pag 205
    void loadTime(){
    	String page="<html><body><a href=\"clock\">" + new Date().toString() + "</a></body></html>";
    	browser.loadData(page,"text/html","UTF-8");
    }
    
    private class Callback extends WebViewClient{
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		loadTime();
    		
    		return (true);
    		//return super.shouldOverrideUrlLoading(view, url);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
