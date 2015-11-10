package com.project.egesha;

import java.util.ArrayList;

import org.w3c.dom.Document;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.project.egesha.R;
import com.google.android.gms.maps.model.LatLng;

public class SpacesTextActivity extends Fragment {

	ListView directionsReturn;
	ProgressBar progress3;
	public LatLng fromPositionDir,toPositionDir;
	public double fromLatDir,fromLngDir,toLatitudeDir,toLongitudeDir;
	public GlobalClass glbclass;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.directions_text, container, false);
		
		glbclass  = ((GlobalClass)getActivity().getApplicationContext());
		
		directionsReturn = (ListView) rootView.findViewById(R.id.lvdirection);
		progress3 = (ProgressBar) rootView.findViewById(R.id.progressBar4);
		
		new RequestTask().execute();

		
		return rootView;
	}
	
	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.directions_text);
		
		glbclass  = ((GlobalClass)getApplicationContext());
		
		directionsReturn = (ListView) findViewById(R.id.lvdirection);
		progress3 = (ProgressBar) findViewById(R.id.progressBar3);
		
		new RequestTask().execute();

        
     }//end of onCreate
*/	
private class RequestTask extends AsyncTask<Void,Void,ArrayList<String>> {//<Param,Progress,Result> -->The values  passed in the 3 methods

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			//progress3.getIndeterminateDrawable().setColorFilter(0xFF000000, android.graphics.PorterDuff.Mode.MULTIPLY);
			progress3.setVisibility(View.VISIBLE);
		}

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			//fromPosition = new LatLng(-1.2919856798690028, 36.82445526123047);
	        //toPosition = new LatLng(-1.3420975581429992, 36.76634788513184);
			
			fromLatDir = glbclass.getUserlat();
			fromLngDir = glbclass.getUserlng();
			toLatitudeDir = glbclass.getChlat();
			toLongitudeDir = glbclass.getChlng();
	        fromPositionDir = new LatLng(fromLatDir,fromLngDir);
	        toPositionDir = new LatLng(toLatitudeDir, toLongitudeDir);
			
			GMapV2Direction md = new GMapV2Direction();

	        Document doc = md.getDocument(fromPositionDir, toPositionDir, GMapV2Direction.MODE_DRIVING);
	        ArrayList<String> directionPoint = md.getDirectionText(doc);
	        
	        return directionPoint;
		}
		
		@Override
		protected void onPostExecute(ArrayList<String> directionPoint) {
			// TODO Auto-generated method stub
			super.onPostExecute(directionPoint);
			
			ArrayAdapter<String> directionAdap = new ArrayAdapter<String>
			(getActivity(), android.R.layout.simple_list_item_1, directionPoint);
			directionsReturn.setAdapter(directionAdap);
			
			progress3.setVisibility(View.GONE);
			
		}

	}

	
}
