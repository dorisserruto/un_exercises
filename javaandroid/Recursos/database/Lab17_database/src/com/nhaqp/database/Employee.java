package com.nhaqp.database;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Employee extends ListActivity {

	private ListView lv;
	private EmployeeHelper db = null;
	private Cursor employeeCursor = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e_main);

		TextView tv = (TextView) this.findViewById(R.id.textView1);
		tv.setText("");

		db = new EmployeeHelper(this);
		employeeCursor = db.getReadableDatabase().rawQuery(
				"SELECT * FROM employees ORDER BY LastName", null);
		
		@SuppressWarnings("deprecation")
		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.e_row,
									employeeCursor, new String[] {
										EmployeeHelper.FIRSTNAME, 
										EmployeeHelper.LASTTNAME,
										EmployeeHelper.EMAIL },
										new int[] { R.id.firstname,
											R.id.lastname, R.id.email});
		
		setListAdapter(adapter);		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		this.employeeCursor.close();
		db.close();
		
	}
	
	public void add(View v) {
		this.add_dialog();
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
	
	private void processAdd(DialogWrapper wrapper) {
		ContentValues values = new ContentValues(3);

		values.put(EmployeeHelper.FIRSTNAME, wrapper.getFirstName());
		values.put(EmployeeHelper.LASTTNAME, wrapper.getLastName());
		values.put(EmployeeHelper.EMAIL, wrapper.getEmail());

		db.getWritableDatabase().insert("employees", null, values);
		employeeCursor.requery();
	}
	
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
	
}