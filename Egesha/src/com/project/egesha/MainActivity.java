package com.project.egesha;

import com.project.egesha.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void getspace(View v){
		Intent toSpace = new Intent(this,Parameters.class);
		startActivity(toSpace);
	}
	
	public void myloci(View v){
		Intent toLoci = new Intent(this,MyLocationActivity.class);
		startActivity(toLoci);
	}
	
	public void about(View v){
		Intent toAbout = new Intent(this,AboutActivity.class);
		startActivity(toAbout);
	}
	
	public void help(View v){
		Intent toHelp = new Intent(this,HelpActivity.class);
		startActivity(toHelp);
	}
	
}
