package com.project.egesha;

import com.project.egesha.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyLocationActivity extends Activity implements android.content.DialogInterface.OnClickListener {//OnClickListener, android.content.DialogInterface.OnClickListener

	//private Button buttonGetLocation;
	private TextView textVw;
	private ProgressBar progress;
	GoogleMap map;

	private LocationManager locManager;
	private LocationListener locListener = new MyLocationListener();

	private boolean gps_enabled = false;
	private boolean network_enabled = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		
		//Get a handle to the Map Fragment
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.locimap)).getMap();
        //Changing map type
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        
		progress = (ProgressBar) findViewById(R.id.progressBar1);
		progress.setVisibility(View.GONE);//set to GONE since progressbar is activated by a control e.g button

		textVw = (TextView) findViewById(R.id.tvlatlong);
		
		//buttonGetLocation = (Button) findViewById(R.id.buttonGetLocation);
		//buttonGetLocation.setOnClickListener(this);

		locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		getCoordsLoc();
		
	}//end of onCreate
	
	//@Override
	public void  getCoordsLoc(){//onClick(View v)
		progress.setVisibility(View.VISIBLE);//display progressbar on click
		// exceptions will be thrown if provider is not permitted.
		try {
			gps_enabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		} catch (Exception ex) {
		}
		try {
			network_enabled = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		} catch (Exception ex) {
		}

		// don't start listeners if no provider is enabled
		if (!gps_enabled && !network_enabled) {
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("Attention!");
			builder.setMessage("Sorry, location is not determined. Please enable location providers");
			builder.setPositiveButton("OK", this);
			builder.setNeutralButton("Cancel", this);
			builder.create().show();
			progress.setVisibility(View.GONE);
		}

		if (gps_enabled) {
			locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
		}
		if (network_enabled) {
			locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);
		}
	}//end of onclick for the view

	class MyLocationListener implements LocationListener {//this class observes change in location
		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				// This needs to stop getting the location data and save the battery power.
				locManager.removeUpdates(locListener); 

				//Create latlng object
		        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());

		        //map.setMyLocationEnabled(true);
		        map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 16));//Set camera to the latlng object in zoom 19

		        map.addMarker(new MarkerOptions()
		                .title("My Location")
		                .snippet("You are here")
		                .position(loc));
				
		        textVw.setText(loc.latitude + ", " + loc.longitude);
		       
				progress.setVisibility(View.GONE);
			} 
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}
	}//end of listener

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if(which == DialogInterface.BUTTON_NEUTRAL){
			Toast.makeText(getApplicationContext(), "Sorry, location is not determined. To fix this please enable location providers", Toast.LENGTH_SHORT).show();
			
		}else if (which == DialogInterface.BUTTON_POSITIVE) {
			startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
		}
	}//end of onclick for dialog
	
}//end of class
