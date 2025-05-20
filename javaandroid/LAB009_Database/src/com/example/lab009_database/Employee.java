package com.example.lab009_database;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Employee extends ListActivity implements OnItemSelectedListener{

	private EmployeeHelper db = null;
	private Cursor employeeCursor = null;
	private Cursor categoryCursor = null;
	private Spinner spin = (Spinner) this.findViewById(R.id.spinner1);
	private ListView lv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_main);
        
        TextView tv = (TextView) this.findViewById(R.id.textView1);
        tv.setText("");
        
        db = new EmployeeHelper(this);
        
        employeeCursor = db.getReadableDatabase().rawQuery("SELECT * FROM employees ORDER BY LastName", null);
        
        @SuppressWarnings("deprecation")
        //param: contexto,vista que permite mostrar los items, donde estan los datos (crearlo en un arreglo), en que componentes visuales iran los valores (necesita crearlo con arreglo)
		ListAdapter adapter = new SimpleCursorAdapter(this,R.layout.e_row,employeeCursor, new String[] {EmployeeHelper.FIRST_NAME,EmployeeHelper.LAST_NAME,EmployeeHelper.EMAIL},new int[] {R.id.firstname,R.id.lastname,R.id.email});
        setListAdapter(adapter);
        
        categoryCursor = db.getReadableDatabase().rawQuery("SELECT * FROM category", null);
        
        @SuppressWarnings("deprecation")
        //ListAdapter adapter2 = new SimpleCursorAdapter(this,R.layout.e_row,categoryCursor, new String[] {EmployeeHelper.DESCRIPTION},new int[] {R.id.firstname,R.id.lastname,R.id.email});
        //setListAdapter(adapter2);
        SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item,categoryCursor,new String[] {EmployeeHelper.DESCRIPTION},new int[] {R.id.spinner1}); 
        //Añadimos el layout para el menú
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Le indicamos al spinner el adaptador a usar
        spin.setAdapter(adapter2);
    }
    
//    public void loadCategory(){
//    	
//        spin = (Spinner) this.findViewById(R.id.spinner1);
//		ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,adapter2);
//		spin.setAdapter(adap);
//		spin.setOnItemSelectedListener(this);
//    }

    @Override
    public void onDestroy(){
    	super.onDestroy();
    	
    	this.employeeCursor.close();
    	this.db.close();
    }
    
    public void add(View v){
    	this.add_dialog();
    }
    
    public void delete(View v) {
		 lv = getListView();
		 this.delete_dialog(lv.getSelectedItemId());
	}
    
    public void add_dialog(){
    	LayoutInflater inflater = LayoutInflater.from(this);
		View addView = inflater.inflate(R.layout.e_add_edit, null);
		final DialogWrapper wrapper = new DialogWrapper(addView);

		new AlertDialog.Builder(this)
				.setTitle(R.string.add_title)
				.setView(addView)
				.setPositiveButton(R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								processAdd(wrapper);
							}
						})
				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// ignore, just dismiss
							}
						}).show();
    }
    
    @SuppressWarnings("deprecation")
	private void processAdd(DialogWrapper wrapper) {
		ContentValues values = new ContentValues(3);

		values.put(EmployeeHelper.FIRST_NAME, wrapper.getFirstName());
		values.put(EmployeeHelper.LAST_NAME, wrapper.getLastName());
		values.put(EmployeeHelper.EMAIL, wrapper.getEmail());

		db.getWritableDatabase().insert("employees", null, values);
		employeeCursor.requery();
	}

	private void delete_dialog(final long rowId) {
	    if (rowId>0) {
	      new AlertDialog.Builder(this)
	        .setTitle(R.string.delete_title)
	        .setPositiveButton(R.string.ok,
	                            new DialogInterface.OnClickListener() {
	          public void onClick(DialogInterface dialog,
	                                int whichButton) {
	            processDelete(rowId);
	          }
	        })
	        .setNegativeButton(R.string.cancel,
	                            new DialogInterface.OnClickListener() {
	          public void onClick(DialogInterface dialog,
	                                int whichButton) {
	          // ignore, just dismiss
	          }
	        })
	        .show();
	    }
	  }
	
	@SuppressWarnings("deprecation")
	private void processDelete(long rowId) {
	    String[] args={String.valueOf(rowId)};
	    
	    db.getWritableDatabase().delete("employees", "_id=?", args);
	    employeeCursor.requery();
	  }

	//Clase Wrapper
	
	class DialogWrapper {
		EditText firstNameField = null;
		EditText lastNameField = null;
		EditText emailField = null;
		View base = null;

		DialogWrapper(View base) {
			this.base = base;
			firstNameField = (EditText) base.findViewById(R.id.txtFirstName);
			lastNameField = (EditText) base.findViewById(R.id.txtLastName);
			emailField = (EditText) base.findViewById(R.id.txtEmail);
		}

		String getFirstName() {
			return (getFirstNameField().getText().toString());
		}
		String getLastName() {
			return (getLastNameField().getText().toString());
		}
		String getEmail() {
			return (getEmailField().getText().toString());
		}

		private EditText getFirstNameField() {
			if (firstNameField == null) {
				firstNameField = (EditText) base
						.findViewById(R.id.txtFirstName);
			}

			return (firstNameField);
		}
		private EditText getLastNameField() {
			if (lastNameField == null) {
				lastNameField = (EditText) base.findViewById(R.id.txtFirstName);
			}

			return (lastNameField);
		}		
		private EditText getEmailField() {
			if (emailField == null) {
				emailField = (EditText) base.findViewById(R.id.txtEmail);
			}

			return (emailField);
		}

	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
