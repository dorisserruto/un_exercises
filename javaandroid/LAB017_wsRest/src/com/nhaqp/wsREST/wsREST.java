package com.nhaqp.wsREST;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class wsREST extends Activity implements OnClickListener {

	Button btnLogin;
	TextView result;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        btnLogin = (Button) this.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        
        result = (TextView) this.findViewById(R.id.lbl_result);
    }

	public void onClick(View v) {
		if ( v == btnLogin){ //si se presiono
			postLoginData();
		}
	}

	public void postLoginData() {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://www.consultores-epm.com/login.php");
		
		try{
			EditText uname = (EditText) this.findViewById(R.id.txt_username);
			String username = uname.getText().toString();
			
			EditText pword = (EditText) this.findViewById(R.id.txt_password);
			String password = pword.getText().toString();
			
			//Parametros
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			
			nameValuePairs.add(new BasicNameValuePair("username", username));
			nameValuePairs.add(new BasicNameValuePair("password", password));
			
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			//Ejecucion del http post request
			HttpResponse response = httpclient.execute(httppost);
			
			String str = inputStreamToString(response.getEntity().getContent()).toString();
			
			if (str.toString().equalsIgnoreCase("true")){
				result.setText("Autenticacion exitosa");
			} else {
				result.setText("No autenticado");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private StringBuilder inputStreamToString(InputStream is) {
		String line = "";
		StringBuilder total = new StringBuilder();
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		
		try{
			while ((line = rd.readLine()) != null){
				total.append(line);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return total;
	}
}
