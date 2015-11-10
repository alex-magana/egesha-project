package com.project.egesha;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.project.egesha.R;

public class HelpActivity extends Activity {

	ListView list;
	
	String a = "1.Click 'Get Parking Space' button.The preferences page is subsequently open";
	String b = "2.Set the owner type.";
	String c = "3.Set the radius to which you wish to limit the search.";
	String d = "4.Click 'Get Parking Spots' button. A list of vailable parking spots is returned.";
	String e = "4.Select a preferred parking spot.";
	String f = "5.A map with the route is returned on the MAP tab.";
	String g = "6.Swipe to view turn by tun directions on the DIRECTIONS tab.";
	
	String [] countries={a,b,c,d,e,f,g};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);//Focus this activity on help.xml
		
		//My additions to this method are as from statement below
			//setting up the list
		list=(ListView) findViewById(R.id.lvhelp);
		ArrayAdapter <String> adapter = new ArrayAdapter<String>
					(this, android.R.layout.simple_list_item_1,countries);
		list.setAdapter(adapter);
	}
}
