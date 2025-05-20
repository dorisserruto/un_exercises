package com.nhaqp.files;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Lab15_static extends ListActivity {
    /** Called when the activity is first created. */
	  TextView selection;
	  ArrayList<String> items=new ArrayList<String>();
	  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        
        selection=(TextView)findViewById(R.id.selection);
        
        try {
          InputStream in=getResources().openRawResource(R.raw.words);
          //PARSER
          DocumentBuilder builder=DocumentBuilderFactory
                                    .newInstance()
                                    .newDocumentBuilder();
          Document doc=builder.parse(in, null);
          NodeList words=doc.getElementsByTagName("word");
          
        //start items.add
         for (int i=0; i < words.getLength(); i++){
        	 items.add(((Element) words.item(i)).getAttribute("value"));
         }
          
        //end items.add
                   
          in.close();
        }
        catch (Throwable t) {
          Toast
            .makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG)
            .show();
        }
      //start setListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
      //end setListAdapter
      }
      
      public void onListItemClick(ListView parent, View v, int position,
                      long id) {
        selection.setText(items.get(position).toString());
      }
    }
