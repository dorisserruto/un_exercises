package com.nhaqp.database;

import java.io.IOException;

import com.nhaqp.database.ConstantsBrowser.DialogWrapper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Employees extends ListActivity {

	private ListView lv;
	private EmployeesHelper db = null;
	private Cursor employeesCursor = null;

	/** Called when the activity is first created. */
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e_main);

		TextView view = (TextView) findViewById(R.id.textView1);
		view.setText("");

		db = new EmployeesHelper(this);
		employeesCursor = db.getReadableDatabase().rawQuery(
				"SELECT _ID, FirstName, LastName, Email "
						+ "FROM employees ORDER BY LastName", null);

		@SuppressWarnings("deprecation")
		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.e_row,
				employeesCursor, new String[] { EmployeesHelper.FIRSTNAME,
						EmployeesHelper.LASTNAME, EmployeesHelper.EMAIL },
				new int[] { R.id.firstname, R.id.lastname, R.id.email });

		setListAdapter(adapter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		employeesCursor.close();
		db.close();
	}

	public void add(View v) {
		this.add_dialog();
	}

	public void delete(View v) {
		 lv = getListView();
		 this.delete_dialog(lv.getSelectedItemId());
	}

	private void add_dialog() {
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

		values.put(EmployeesHelper.FIRSTNAME, wrapper.getFirstName());
		values.put(EmployeesHelper.LASTNAME, wrapper.getLastName());
		values.put(EmployeesHelper.EMAIL, wrapper.getEmail());

		db.getWritableDatabase().insert("employees", null, values);
		employeesCursor.requery();
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
	
	private void processDelete(long rowId) {
	    String[] args={String.valueOf(rowId)};
	    
	    db.getWritableDatabase().delete("employees", "_id=?", args);
	    employeesCursor.requery();
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
}