package com.project.egesha;

import android.app.Application;

public class GlobalClass extends Application{

	public String selectedType;
	public int selectedRad;
	public double userlatitude, userlongitude, chosenlatitude, chosenlongitude;
	
	public String getType(){
		
		return selectedType;
	}
	
	public void setType(String sType){
		
		this.selectedType = sType;
	}
	
	public int getRad(){
		
		return selectedRad;
	}
	
	public void setRad(int sRad){
		
		this.selectedRad = sRad;
	}
	
	public double getUserlat(){
		
		return userlatitude;
	}
	
	public void setUserlat(double Userlat){
		
		this.userlatitude = Userlat;
	}
	
	public double getUserlng(){
		
		return userlongitude;
	}
	
	public void setUserlng(double Userlng){
		
		this.userlongitude = Userlng;
	}
	
	public double getChlat(){
		
		return chosenlatitude;
	}
	
	public void setChlat(double Chlat){
		
		this.chosenlatitude = Chlat;
	}
	
	public double getChlng(){
		
		return chosenlongitude;
	}
	
	public void setChlng(double Chlng){
		
		this.chosenlongitude = Chlng;
	}
	
	public void clearValues(){
		
	/*selectedType = null;
	selectedRad = null;
	userlatitude = null;
	userlongitude = null;*/
	
		
	}
	
}
