package com.studentregistration;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddData extends Activity{
	SQLiteDatabase sampleDB = null;
    /** Called when the activity is created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);
        Log.d("AddStudClass", "^^^AddStudClass^^^");
    }
    
public void ButtonRegister(View view){
    	
    	switch(view.getId()){
    	case R.id.btnRegister:
    	
    	final EditText uniname, username,gender,studidnumber, dob, 
    	entryyear, level, country, degree, degreecode, haddress, localph, localaddress, mobile;
		//Reference your edit texts
		uniname= (EditText) findViewById(R.id.txtuniname);
		studidnumber= (EditText) findViewById(R.id.txtregid);
		gender= (EditText) findViewById(R.id.txtgender);
		username= (EditText) findViewById(R.id.txtusertname);
		dob= (EditText) findViewById(R.id.txtdob);
		entryyear= (EditText) findViewById(R.id.txtentryyr);
		level= (EditText) findViewById(R.id.txtlevel);
		country= (EditText) findViewById(R.id.txtcountry);
		degree = (EditText) findViewById(R.id.txtdegree);
		degreecode = (EditText) findViewById(R.id.txtdegreecode);
		haddress = (EditText) findViewById(R.id.txthaddr);
		localph = (EditText) findViewById(R.id.txtlocalph);
		localaddress = (EditText) findViewById(R.id.txtphno);
		mobile = (EditText) findViewById(R.id.txtmob);
	    
		//get text from edit texts
    	String getusername = username.getText().toString();
    	String getuniname = uniname.getText().toString();
    	String getstudidnumber = studidnumber.getText().toString();
    	String getgender = gender.getText().toString();
    	String getdob = dob.getText().toString();
    	String getentryyr = entryyear.getText().toString();
    	String getlevel = level.getText().toString();
    	String getcountry = country.getText().toString();
    	String getdegree = degree.getText().toString();
    	String getdegcode = degreecode.getText().toString();
    	String gethaddress = haddress.getText().toString();
    	String getlocalph = localph.getText().toString();
    	String getlocaladdress = localaddress.getText().toString();
    	String getmobile = mobile.getText().toString();
//    	
    	Log.d(getmobile, "^^^mobilead^^^");
    	SQLiteHandler b = new SQLiteHandler(getApplicationContext());
    	
    	b.InsertData(getusername, 
    			getuniname, 
    			getstudidnumber, 
    			getgender, 
    			getdob, 
    			getentryyr, 
    			getlevel, 
    			getcountry, 
    			getdegree, 
    			getdegcode, 
    			gethaddress, 
    			getlocalph, 
    			getlocaladdress, 
    			getmobile);
    	
    	
     if(getstudidnumber.equals("")){
    	 Toast.makeText(AddData.this, "Enter Your Student Number", Toast.LENGTH_SHORT).show();
    	 
     } 
        break;
             }
    	}

}
