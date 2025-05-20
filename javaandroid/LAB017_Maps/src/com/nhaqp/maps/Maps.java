package com.nhaqp.maps;

import android.os.Bundle;
import com.google.android.maps.MapActivity; //AGREGAR
import com.google.android.maps.MapView;

import android.view.KeyEvent;
import com.google.android.maps.MapController;

import com.google.android.maps.GeoPoint;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import com.google.android.maps.Overlay;

import java.util.List;

import android.view.MotionEvent;
import android.widget.Toast;


public class Maps extends MapActivity { //CLASE MAPACTIVITY

	MapView mapView;
	MapController mc2;
	GeoPoint p;
	
	class MapOverlay extends com.google.android.maps.Overlay{
		
		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when){
			
			super.draw(canvas, mapView, shadow);
			Point screenPts = new Point(); //libreria grafica
			mapView.getProjection().toPixels(p, screenPts);
			
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.push_pin);
			canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50,null); //resta 50 por la imagen (el alto si es dif)
			return true;
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent event, MapView mapView){
			if (event.getAction() == 1){ //tocar pantalla
				GeoPoint p = mapView.getProjection().fromPixels((int) event.getX(), (int) event.getY());
				Toast.makeText(getBaseContext(), 
						"Ubicacion:"+ 
						p.getLatitudeE6()/1E6+","+
						p.getLongitudeE6()/1E6, 
						Toast.LENGTH_SHORT).show();
			}
			return false;
		}
	}
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) this.findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(true);
        //mapView.setStreetView(true);
        //mapView.setTraffic(true);
        
        mc2 = mapView.getController();
        
        String coordinates[] = {"-16.405419899318158","-71.54024094343185"};
        double latitud = Double.parseDouble(coordinates[0]);
        double longitud = Double.parseDouble(coordinates[1]);
        
        p = new GeoPoint((int) (latitud * 1E6), (int) (longitud * 1E6));
        
        mc2.animateTo(p);
        mc2.setZoom(13);
        
        //Agregar marcador
        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.clear();
        
        listOfOverlays.add(mapOverlay);
        
        mapView.invalidate(); //refresh
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event){
    	MapController mc = mapView.getController();
    	
    	switch(keyCode){
    	
    	case KeyEvent.KEYCODE_1:
    		mc.zoomOut();
    		break;
    	
    	case KeyEvent.KEYCODE_3:
    		mc.zoomIn();
    		break;
    	}
    	
    	return super.onKeyDown(keyCode, event);
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	 
}
