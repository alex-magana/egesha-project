package com.project.egesha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.egesha.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends Activity {

	ListView lv;
	ProgressBar progress2;
	public String typeOption,chosenLat,chosenLng;
	public int radiusOption;
	public double latitude, longitude;
	public HttpClient client;
	
	public GlobalClass glbclass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);
		
		glbclass  = ((GlobalClass)getApplicationContext());
		
		lv = (ListView) findViewById(R.id.lvresult);
		progress2 = (ProgressBar) findViewById(R.id.progressBar3);
		
		
		new RequestTask().execute();
		
		getParametersR();

	}
	
	public void getParametersR() {
		// TODO Auto-generated method stub
		
		// modifying the list view
		OnItemClickListener listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				TextView tvLatCh = (TextView) arg1.findViewById(R.id.tvlat);
				TextView tvLngCh = (TextView) arg1.findViewById(R.id.tvlng);
				chosenLat = tvLatCh.getText().toString();
				chosenLng = tvLngCh.getText().toString();
				
				//set chosen latitude and longitude
				glbclass.setChlat(Double.parseDouble(chosenLat));
				glbclass.setChlng(Double.parseDouble(chosenLng));
				
				//Toast.makeText(getApplicationContext(), 
						//"Your coordinates: "+ glbclass.getUserlat() + "," + glbclass.getUserlng(), Toast.LENGTH_SHORT).show();
				//Toast.makeText(getApplicationContext(),
						//"You clicked:  "+ glbclass.getChlat() + "," + glbclass.getChlng(), Toast.LENGTH_SHORT).show();
				sendParametersR(arg1);
			}
		};
		lv.setOnItemClickListener(listener);
		
	}
	
	public void sendParametersR(View v)
	{	
		
		//Creating a new intent
		Intent intent=new Intent(this, TabHostActivity.class);
		//Starting new activity
		startActivity(intent);
		
	}
	
	public String readJSONFeed(String URL) {
		StringBuilder stringBuilder = new StringBuilder();
		client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}
			} else {
				Log.e("JSON", "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	private class RequestTask extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			//progress2.getIndeterminateDrawable().setColorFilter(0xFF000000,android.graphics.PorterDuff.Mode.MULTIPLY);
			progress2.setVisibility(View.VISIBLE);
			
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub

			//set request parameters
			typeOption = glbclass.getType();
			radiusOption = glbclass.getRad();
			latitude = glbclass.getUserlat();
			longitude = glbclass.getUserlng();
			
			/*Wamp test
			 * String url = "http://10.0.2.2/PROJECT/Exercises/WorkingScripts/informationquery_mobi.php" +
								"?lat="+latitude+"&lng="+longitude+"&owner="+typeOption+"&radius="+radiusOption;
			
			   String url = "http://paknav.zxq.net/mobi/informationquery_mobi.php" +
								"?lat="+latitude+"&lng="+longitude+"&owner="+typeOption+"&radius="+radiusOption;
			*/
			String url = "http://paknav.net63.net/mobi/informationquery_mobi.php" +
					"?lat="+latitude+"&lng="+longitude+"&owner="+typeOption+"&radius="+radiusOption;
			
			String result = readJSONFeed(url);
			Log.d("RESULT JSON", result);

			return result;

		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			progress2.setVisibility(View.GONE);
			displayList(result);
		}

	}
	
	private void displayList(String response) {
		if(response.length() > 0){
			try {

			JSONArray resultArr = new JSONArray(response);
			
			List<GetSet> parkList=new ArrayList<GetSet>();
			for (int i = 0; i < resultArr.length(); i++) {
				
				JSONObject resultObj = resultArr.getJSONObject(i);

				GetSet getSet=new GetSet();
				getSet.setName(resultObj.getString("name"));
				getSet.setRate(resultObj.getString("rate"));
				getSet.setOphr(resultObj.getString("openinghour"));
				getSet.setClhr(resultObj.getString("closinghour"));
				getSet.setLat(resultObj.getString("lat"));
				getSet.setLng(resultObj.getString("lng"));
				parkList.add(getSet);
				//lat,lng,rate,openinghour,closinghour,distance
			}
			
			ListAdapter adapter = new ListAdapter(this, parkList);
			lv.setAdapter(adapter);

			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		else{
			Toast.makeText(getApplicationContext(), "No parking lots found", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	private class ListAdapter extends BaseAdapter{
		
		private Activity activity;
		private List<GetSet> listgs;
		private LayoutInflater inflater = null;
		
		public ListAdapter(Activity a, List<GetSet> b){
			activity = a;
			listgs = b;
			inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listgs.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;
			if(convertView == null)
					view = inflater.inflate(R.layout.list_plan, null);
			
			TextView tvName = (TextView) view.findViewById(R.id.tvname);
			TextView tvRate = (TextView) view.findViewById(R.id.tvrate);		
			TextView tvOphr = (TextView) view.findViewById(R.id.tvophr);
			TextView tvClhr = (TextView) view.findViewById(R.id.tvclhr);
			TextView tvLat = (TextView) view.findViewById(R.id.tvlat);
			TextView tvLng = (TextView) view.findViewById(R.id.tvlng);
			
			GetSet item = new GetSet();
			item = listgs.get(position);
			tvName.setText(item.getName());
			tvRate.setText(item.getRate());
			tvOphr.setText(item.getOphr());
			tvClhr.setText(item.getClhr());
			tvLat.setText(item.getLat());
			tvLng.setText(item.getLng());
			
			return view;
		}
		
	}
	

}