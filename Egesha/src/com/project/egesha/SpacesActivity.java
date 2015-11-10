package com.project.egesha;

import java.util.ArrayList;

import org.w3c.dom.Document;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.egesha.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class SpacesActivity extends Fragment{

	public GoogleMap mapView;
	public LatLng fromPosition,toPosition;
	public double fromLat,fromLng,toLatitude,toLongitude;
	public GlobalClass glbclass;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.getparking, container, false);
		
		glbclass  = ((GlobalClass)getActivity().getApplicationContext());
		
		fromLat = glbclass.getUserlat();
		fromLng = glbclass.getUserlng();
		fromPosition = new LatLng(fromLat,fromLng);
	    
	    // Get a handle to the Map Fragment
        mapView = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        //Changing map type
        mapView.setMapType(GoogleMap.MAP_TYPE_NORMAL);
     
        mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(fromPosition,15));
		
		new RequestTask().execute();
		
		return rootView;
	}
	
	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getparking);
		
		glbclass  = ((GlobalClass)getApplicationContext());
		
		fromLat = glbclass.getUserlat();
		fromLng = glbclass.getUserlng();
		fromPosition = new LatLng(fromLat,fromLng);
	    
	    // Get a handle to the Map Fragment
        mapView = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        //Changing map type
        mapView.setMapType(GoogleMap.MAP_TYPE_NORMAL);
     
        mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(fromPosition,15));
		
		new RequestTask().execute();
        
     }//end of onCreate
*/
	private class RequestTask extends AsyncTask<Void,Void,PolylineOptions> {//<Param,Progress,Result> -->The values  passed in the 3 methods

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		}

		@Override
		protected  PolylineOptions doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			//fromPosition = new LatLng(-1.2919856798690028, 36.82445526123047);
	        //toPosition = new LatLng(-1.3420975581429992, 36.76634788513184);
			
	        //set parameters for directions 
	        fromLat = glbclass.getUserlat();
			fromLng = glbclass.getUserlng();
			toLatitude = glbclass.getChlat();
			toLongitude = glbclass.getChlng();
	        fromPosition = new LatLng(fromLat,fromLng);
	        toPosition = new LatLng(toLatitude, toLongitude);
	        
			GMapV2Direction md = new GMapV2Direction();

	        Document doc = md.getDocument(fromPosition, toPosition, GMapV2Direction.MODE_DRIVING);
	        ArrayList<LatLng> directionPoint = md.getDirection(doc);
	        PolylineOptions rectLine = new PolylineOptions().width(10).color(Color.RED);

	        for(int i = 0 ; i < directionPoint.size() ; i++) {          
	        rectLine.add(directionPoint.get(i));
	        }

			return rectLine;
		}
		
		@Override
		protected void onPostExecute(PolylineOptions rectLine) {
			// TODO Auto-generated method stub
			super.onPostExecute(rectLine);
			
			mapView.addMarker(new MarkerOptions()
						.title("Start")
						.position(fromPosition));
			
			mapView.addMarker(new MarkerOptions()
			.title("End")
			.position(toPosition)
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher2)));
			
			mapView.addPolyline(rectLine);
			
		}

	}
    
	
}
