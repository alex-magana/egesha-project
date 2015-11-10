package com.project.egesha;

import com.project.egesha.R;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Parameters extends Activity implements android.content.DialogInterface.OnClickListener{

	private Spinner spintype;
	private Spinner spinrad;
	String[] types = { "ALL", "PUBLIC", "PRIVATE" };
	Integer[] radius = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
	public String selectedTypeR;
	public int selectedRadR;
	public double latitude, longitude;
	public GlobalClass glbclass;
	private LocationManager locManager;
	private LocationListener locListener = new MyLocationListener();

	private boolean gps_enabled = false;
	private boolean network_enabled = false;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setparameters);
		
		glbclass  = ((GlobalClass)getApplicationContext());
		
		spintype = (Spinner) findViewById(R.id.spinnertype);
		spinrad = (Spinner) findViewById(R.id.spinnerradius);
		
		locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		getParameters();
		
	}//end of onCreate
	
	public void getParameters() {
		// TODO Auto-generated method stub
		// USER SELECTS type and radius
		// USER REQUESTS AVAILABLE PARKING SPACES
		// RESULTS ARE RETURNED IN THE SUBSEQUENT ACTIVITY
		
		// the type arrayadapter
		ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, types);
		spintype.setAdapter(adapterType);

		// the radius arrayadapter
		ArrayAdapter<Integer> adapterRad = new ArrayAdapter<Integer>(this,
				android.R.layout.simple_spinner_item, radius);
		spinrad.setAdapter(adapterRad);

		OnItemSelectedListener listenerType = new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(),
						//"You clicked" + types[arg2], Toast.LENGTH_SHORT).show();
				selectedTypeR = types[arg2];
				
				//set type
				glbclass.setType(selectedTypeR);
			}// item selected

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}// nothing selected

		};// end of type listener
		spintype.setOnItemSelectedListener(listenerType);
		
		OnItemSelectedListener listenerRadius = new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(),
						//"You clicked" + radius[arg2], Toast.LENGTH_SHORT).show();
				selectedRadR = radius[arg2];

				//set radius
				glbclass.setRad(selectedRadR);
			}// item selected

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}// nothing selected

		};// end of radius listener
		spinrad.setOnItemSelectedListener(listenerRadius);

		getCoords();
	}

	public void getCoords()
	{
		// Exceptions will be thrown if provider is not permitted.
		try {
			gps_enabled = locManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);
		} catch (Exception ex) {
		}
		try {
			network_enabled = locManager
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		} catch (Exception ex) {
		}

		// Don't start listeners if no provider is enabled
		if (!gps_enabled && !network_enabled) {
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("Attention!");
			builder.setMessage("Sorry, location is not determined. Please enable location providers");
			builder.setPositiveButton("OK", this);
			builder.setNeutralButton("Cancel", this);
			builder.create().show();
		}

		if (gps_enabled) {
			locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 
					0, 0, locListener);
		}
		if (network_enabled) {
			locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
					0, 0, locListener);
		}
	}
	
	public void sendParameters(View v)
	{	
		//latitude=-1.2919856798690028;
		//longitude=36.82445526123047;
		//glbclass.setUserlat(-1.2919856798690028);
		//glbclass.setUserlng(36.82445526123047);
		
		//Creating a new intent
		Intent intent=new Intent(this, Results.class);
		//Starting new activity
		startActivity(intent);
		
	}
	
	class MyLocationListener implements LocationListener {//this class observes change in location
		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				// This needs to stop getting the location data and save the battery power.
				locManager.removeUpdates(locListener); 
				
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				
				//set user latitude and longitude
				glbclass.setUserlat(latitude);
				glbclass.setUserlng(longitude);
				
				//Toast.makeText(getApplicationContext(), 
						//"Your coordinates: "+ glbclass.getUserlat() + "," + glbclass.getUserlng(), Toast.LENGTH_SHORT).show();
				
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
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {//onClick(DialogInterface dialog, int which)
		if(which == DialogInterface.BUTTON_NEUTRAL){
			Toast.makeText(getApplicationContext(), "Sorry, location is not determined. To fix this please enable location providers", Toast.LENGTH_SHORT).show();
			
		}else if (which == DialogInterface.BUTTON_POSITIVE) {
			startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
		}
	}//end of onclick for dialog
	
}
