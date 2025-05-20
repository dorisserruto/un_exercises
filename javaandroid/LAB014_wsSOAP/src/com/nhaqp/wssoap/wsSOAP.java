package com.nhaqp.wssoap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class wsSOAP extends Activity {

	//pag 481 : cap 34
	private final String NAMESPACE = "http://www.webserviceX.NET/"; //almacena la ruta del servico web
	private final String URL = "http://www.webservicex.net/ConvertWeight.asmx";
	private final String SOAP_ACTION = "http://www.webserviceX.NET/ConvertWeight";
	private final String METHOD_NAME = "ConvertWeight";
	
	TextView tv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //generando una politica
        //vamos a evitar la politica de Android que obliga a usar un thread para lo que es ws
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        
        //Valores de parametros
        String weight = "3700";
        String fromUnit = "Grams";
        String toUnit = "Kilograms";
        
        // Anhadiendo valores al objeto SOAP
        //Propiedad ToUnit
        PropertyInfo toProp = new PropertyInfo();
        toProp.setName("ToUnit");
        toProp.setValue(toUnit);
        toProp.setType(String.class);
        request.addProperty(toProp);
        
      //Propiedad FromUnit
        PropertyInfo fromProp = new PropertyInfo();
        fromProp.setName("FromUnit");
        fromProp.setValue(fromUnit);
        fromProp.setType(String.class);
        request.addProperty(fromProp);
        
      //Propiedad Weight
        PropertyInfo weightProp = new PropertyInfo();
        weightProp.setName("Weight");
        weightProp.setValue(weight);
        weightProp.setType(double.class);
        request.addProperty(weightProp);
        
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true; //indica que el servicio esta en .net        
        envelope.setOutputSoapObject(request);
        
        //hace el nexo con la url
        HttpTransportSE transporte = new HttpTransportSE(URL);
        
        try{
        	transporte.call(SOAP_ACTION, envelope);
        	SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
        	
        	tv = (TextView) this.findViewById(R.id.tvResultado);
        	tv.setText("El resultado es:" + response.toString());
        	
        } catch (Exception e){
        	e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
