package com.nhaqp.wsSOAP;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class wsSOAPActivity extends Activity {
   
	private final String NAMESPACE = "http://www.webserviceX.NET/";
	private final String URL = "http://www.webservicex.net/ConvertWeight.asmx";
	private final String SOAP_ACTION = "http://www.webserviceX.NET/ConvertWeight";
	private final String METHOD_NAME = "ConvertWeight";
	
	TextView tv;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        										.permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        
        //Valores de Parametros
        String peso = "3700";
        String fromUnit = "Grams";
        String toUnit = "Kilograms";
        
        //Propidad Weight
        PropertyInfo weightProp = new PropertyInfo();
        weightProp.setName("Weight");
        weightProp.setValue(peso);
        weightProp.setType(double.class);
        request.addProperty(weightProp);        
        
        //Propidad fromUnit
        PropertyInfo fromProp = new PropertyInfo();
        fromProp.setName("FromUnit");
        fromProp.setValue(fromUnit);
        fromProp.setType(String.class);
        request.addProperty(fromProp);
        
        //Propidad toUnit
        PropertyInfo toProp = new PropertyInfo();
        toProp.setName("ToUnit");
        toProp.setValue(toUnit);
        toProp.setType(String.class);
        request.addProperty(toProp);
        
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        
        HttpTransportSE transporte = new HttpTransportSE(URL);
        
        try {
        	transporte.call(SOAP_ACTION, envelope);
        	SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
        	
        	tv = (TextView) this.findViewById(R.id.tvResultado);
        	tv.setText("El resultado es: " +  response.toString());
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        
        
        
    }
}