package com.project.egesha;


import com.project.egesha.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class Splash extends Activity {
	private int displayTime = 1000;
	ProgressBar spinner;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);//FEATURE_NO_TITLE used to remove header
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        spinner = (ProgressBar) findViewById(R.id.progressBar2);
        //spinner.getIndeterminateDrawable().setColorFilter(0xFF000000,android.graphics.PorterDuff.Mode.MULTIPLY);
        
        Thread splashThread = new Thread(){
			int wait = 0;
			
			@Override
			public void run(){
				try{
					super.run();
					
					while(wait<displayTime){
						sleep(100);
						wait += 100;
					}
				}//end of try
				catch(Exception e){
					
				}
				finally{
					Intent intent = new Intent(Splash.this,MainActivity.class);
					startActivity(intent);
					finish();//Killing the activity
			
				}
				
			}//end of run
		};//end of thread declaration
		splashThread.start();
    
    }//end of onCreate

}//end of class
