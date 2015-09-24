package com.studentregistration;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Search extends Activity{
	SQLiteDatabase sampleDB = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
    }
    
    public void ButtonDelete(View view){
    	final EditText studidnumber; 
    	studidnumber= (EditText) findViewById(R.id.txtregid);
    	String getstudidnumber = studidnumber.getText().toString();
    	
    	SQLiteHandler b = new SQLiteHandler(getApplicationContext());
    	Log.d("Delete", "^^^delete^^^");
    	b.DeleteData(getstudidnumber);
    }
    
    public void ButtonSave(View view){
    	Log.d("ButtonSave", "Button Save");
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
    	
    	SQLiteHandler b = new SQLiteHandler(getApplicationContext());
    	Log.d("IntoUpdate", "^^^update^^^");
    	b.UpdateData(getusername, 
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
    	//Toast.makeText(Search.this, "Details Updated", Toast.LENGTH_SHORT).show();
    }
    
    public void ButtonSearch(View view){
		 
		EditText idnumbersearch = (EditText) findViewById(R.id.txtsearchregid);
		
    	String a = idnumbersearch.getText().toString();
    	SQLiteHandler b = new SQLiteHandler(getApplicationContext());
    	String  items = b.getData(a);
    	final String[]  item = b.getDataB(a);
    	Log.d(item[0], "^^^String^^^");
    	Log.d(item[13], "^^^String12^^^");
    	    	
    	if(items != ""){
    		
    		final TextView viewdata = (TextView) findViewById(R.id.tvresults);
        	viewdata.append(items);
        	Button myButton = new Button(this);
            myButton.setText("Edit/Delete details");
            
            LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            ll.addView(myButton, lp);
            
            myButton.setOnClickListener(new OnClickListener(){
            	@Override
    			public void onClick(View arg0) {
            		setContentView(R.layout.edit);
            		
            		final EditText uniname, username,gender,studidnumber, dob, 
            		entryyear, level, country, degree, degreecode, haddress, localph, localaddress, mobile;
            		//Reference your edit texts
            		uniname= (EditText) findViewById(R.id.txtuniname);
            		uniname.setText(item[1], TextView.BufferType.EDITABLE);
            		studidnumber= (EditText) findViewById(R.id.txtregid);
            		studidnumber.setFocusable(false); 
            		studidnumber.setClickable(false);
            		studidnumber.setText(item[2], TextView.BufferType.EDITABLE);
            		gender= (EditText) findViewById(R.id.txtgender);
            		gender.setText(item[3], TextView.BufferType.EDITABLE);
            		username= (EditText) findViewById(R.id.txtusertname);
            		username.setText(item[0], TextView.BufferType.EDITABLE);
            		dob= (EditText) findViewById(R.id.txtdob);
            		dob.setText(item[4], TextView.BufferType.EDITABLE);
            		entryyear= (EditText) findViewById(R.id.txtentryyr);
            		entryyear.setText(item[5], TextView.BufferType.EDITABLE);
            		level= (EditText) findViewById(R.id.txtlevel);
            		level.setText(item[6], TextView.BufferType.EDITABLE);
            		country= (EditText) findViewById(R.id.txtcountry);
            		country.setText(item[7], TextView.BufferType.EDITABLE);
            		degree = (EditText) findViewById(R.id.txtdegree);
            		degree.setText(item[8], TextView.BufferType.EDITABLE);
            		degreecode = (EditText) findViewById(R.id.txtdegreecode);
            		degreecode.setText(item[9], TextView.BufferType.EDITABLE);
            		haddress = (EditText) findViewById(R.id.txthaddr);
            		haddress.setText(item[10], TextView.BufferType.EDITABLE);
            		localph = (EditText) findViewById(R.id.txtlocalph);
            		localph.setText(item[11], TextView.BufferType.EDITABLE);
            		localaddress = (EditText) findViewById(R.id.txtphno);
            		localaddress.setText(item[12], TextView.BufferType.EDITABLE);
            		mobile = (EditText) findViewById(R.id.txtmob);
            		mobile.setText(item[13], TextView.BufferType.EDITABLE);
            		
            		
            	}
            });
    	}
	 }

}
