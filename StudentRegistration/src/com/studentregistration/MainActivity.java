package com.studentregistration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity{
	
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity);
		Log.d("1", "^^^act1^^^");
	}

	public void ButtonOnClick(View view){
		switch(view.getId()){
    	case R.id.btnAddStudent:
    		Intent addstudy = new Intent(this, AddData.class);
    		startActivity(addstudy);
    		 Log.d("AddstudBtn", "^^^button^^^");
    		break;
    	case R.id.btnViewDet:
    		Intent viewD = new Intent(this, Search.class);
    		startActivity(viewD);
    		break;
		}
	}
}