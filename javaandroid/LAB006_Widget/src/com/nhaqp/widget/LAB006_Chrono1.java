package com.nhaqp.widget;

import java.util.Calendar;

import android.app.Activity; 
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class LAB006_Chrono1 extends Activity{

	private TextView dateAndTimeLabel;
	Calendar dateAndTime = Calendar.getInstance();
	
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.main_chrono1);
		
		dateAndTimeLabel = (TextView) this.findViewById(R.id.txtChrono);
		
		updateLabel();
	}
	
	private void updateLabel(){
		this.dateAndTimeLabel.setText(DateUtils.formatDateTime(this, dateAndTime.getTimeInMillis(),DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_SHOW_TIME));
	}
	
	//Ref Pag 173
	public void chooseDate(View v){
		//d: callback
		new DatePickerDialog(this, d, dateAndTime.get(Calendar.YEAR),dateAndTime.get(Calendar.MONTH),dateAndTime.get(Calendar.DAY_OF_MONTH)).show();

	}
	
	public void chooseTime(View v){
		new TimePickerDialog(this, t, dateAndTime.get(Calendar.HOUR_OF_DAY),dateAndTime.get(Calendar.MINUTE),true).show();
	}
	
	//d: callback implementacion
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			dateAndTime.set(Calendar.YEAR, year);
			dateAndTime.set(Calendar.MONTH, monthOfYear);
			dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
		}
	};
	
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
		
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
			dateAndTime.set(Calendar.MINUTE, minute);
			updateLabel();
		}
	};
}
