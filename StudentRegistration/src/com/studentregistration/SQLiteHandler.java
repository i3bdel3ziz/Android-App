package com.studentregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLiteHandler extends SQLiteOpenHelper {
	 private static final String MYDATABASE = "studDb";
	 private static final int VERSION = 1;
		private final String SAMPLE_TABLE_NAME = "students";
		protected Context context;
	  public SQLiteHandler(final Context connection) {
			
	  super(connection, MYDATABASE, null, VERSION);
	  this.context = connection;
	  
	 }
	 
	 @Override
	 public void onCreate(SQLiteDatabase db) {
		 	db.execSQL("CREATE TABLE IF NOT EXISTS " +
	    			SAMPLE_TABLE_NAME +" (UserName VARCHAR, " +
	    					"UniName VARCHAR, " +
	    					"StudidNumber VARCHAR, " +
	    					"Gender VARCHAR, " +
	    					"DOB VARCHAR, " +
	    					"EntryYr VARCHAR, " +
	    					"Level VARCHAR, " +
	    					"Country VARCHAR, " +
	    					"Degree VARCHAR, " +
	    					"DegCode VARCHAR, " +
	    					"Haddress VARCHAR, " +
	    					"LocalPh VARCHAR, " +
	    					"LocalAddress VARCHAR, " +
	    					"Mobile VARCHAR);");
	 }
	 
	 @Override
	 public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
	   //db.execSQL("DROP TABLE IF EXIST o");
	   //  onCreate(db);
	 }
	 public void InsertData(String getusername, String getuniname, String getstudidnumber, String getgender, String getdob, String getentryyr, 
			 String getlevel, String getcountry, String getdegree, String getdegcode, String gethaddress, String getlocalph, String getlocaladdress,
			 String getmobile){
		 try{
	     	SQLiteDatabase db = this.getWritableDatabase();
	     	
	     	ContentValues row = new ContentValues();
	     	row.put("UserName",getusername);
	        row.put("UniName", getuniname);
	        row.put("StudidNumber",getstudidnumber);
	        row.put("Gender",getgender);
	        row.put("DOB",getdob);
	        row.put("EntryYr",getentryyr);
	        row.put("Level",getlevel);
	        row.put("Country",getcountry);
	        row.put("Degree",getdegree);
	        row.put("DegCode",getdegcode);
	        row.put("Haddress",gethaddress);
	        row.put("LocalPh",getlocalph);
	        row.put("LocalAddress",getlocaladdress);
	        row.put("Mobile",getmobile);
	      
	        long chk = db.insert("students",null, row);

	        if(chk!=0){
	            Toast.makeText(context, "Record added successfully",Toast.LENGTH_LONG).show(); 
	        }else{
	            Toast.makeText(context, "Record add failed...! ",Toast.LENGTH_LONG).show();
	        }

	     	}catch (Exception e) {
					// TODO: handle exception
				}
	 }

	 public String getData(String id) {
	     
		 SQLiteDatabase db = this.getReadableDatabase();

		 final Cursor c = db.rawQuery("SELECT UserName, UniName,StudidNumber, Gender, DOB, EntryYr, Level, Country, Degree, DegCode, Haddress,LocalPh, LocalAddress, Mobile  FROM " +
		 			SAMPLE_TABLE_NAME +
		 			" where StudidNumber =  '"+id+"'", null);
		 
		 int count = c.getCount();
		 
		 
	    if(count == 0){
	 	
	 		Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
	 		c.close();
	 	}
	    
	     String result = "";
	     
	     int usrname = c.getColumnIndex("UserName");
	     int uniName = c.getColumnIndex("UniName");
	     int regid = c.getColumnIndex("StudidNumber");
	     int gend = c.getColumnIndex("Gender");
	     int dob = c.getColumnIndex("DOB");
	     int entyr = c.getColumnIndex("EntryYr");
	     int LevelA = c.getColumnIndex("Level");
	     int county = c.getColumnIndex("Country");
	     int degre = c.getColumnIndex("Degree");
	     int degreecode = c.getColumnIndex("DegCode");
	     int homeadd = c.getColumnIndex("Haddress");
         int localphone = c.getColumnIndex("LocalPh");
	     int localAdd = c.getColumnIndex("LocalAddress");
	     int mobil = c.getColumnIndex("Mobile");
	    
	     
	     for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	         result = result + "User Name: "+c.getString(usrname) + 
	        		 "\n\nUniv Name: " + c.getString(uniName) + 
	        		 "\n\nStudent No: " + c.getString(regid) +
	        		 "\n\nGender: " + c.getString(gend) +
	        		 "\n\nDate of Birth: " + c.getString(dob) +
	        		 "\n\nEntry year: " + c.getString(entyr) +
	        		 "\n\nLevel: " + c.getString(LevelA) +
	        		 "\n\nCountry: " + c.getString(county) +
	        		 "\n\nDegree: " + c.getString(degre) +
	        		 "\n\nDegree Code: " + c.getString(degreecode) +
	        		 "\n\nHome Address: " + c.getString(homeadd) +
	        		 "\n\nLocal Phone: " + c.getString(localphone) +
	        		 "\n\nLocal Address: " + c.getString(localAdd) +
	        		 "\n\nMobile Phone: " + c.getString(mobil) +
	        		 "\n";
	         
	     }
	     return result;

	 }
	 
	 public String[] getDataB(String id) {
	     
		 SQLiteDatabase db = this.getReadableDatabase();

		 final Cursor c = db.rawQuery("SELECT UserName, UniName,StudidNumber, Gender, DOB, EntryYr, Level, Country, Degree, DegCode, Haddress,LocalPh, LocalAddress, Mobile  FROM " +
		 			SAMPLE_TABLE_NAME +
		 			" where StudidNumber =  '"+id+"'", null);
		 
		 int count = c.getCount();
		 
		 
	    if(count == 0){
	 	
	 		Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
	 		c.close();
	 	}
	    
	     String[] result = {"","","","","","","","","","","","","",""};
	     
	     int usrname = c.getColumnIndex("UserName");
	     int uniName = c.getColumnIndex("UniName");
	     int regid = c.getColumnIndex("StudidNumber");
	     int gend = c.getColumnIndex("Gender");
	     int dob = c.getColumnIndex("DOB");
	     int entyr = c.getColumnIndex("EntryYr");
	     int LevelA = c.getColumnIndex("Level");
	     int county = c.getColumnIndex("Country");
	     int degre = c.getColumnIndex("Degree");
	     int degreecode = c.getColumnIndex("DegCode");
	     int homeadd = c.getColumnIndex("Haddress");
         int localphone = c.getColumnIndex("LocalPh");
	     int localAdd = c.getColumnIndex("LocalAddress");
	     int mobil = c.getColumnIndex("Mobile");
	    
	     
	     for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	         result[0] = c.getString(usrname);
	         result[1] = c.getString(uniName); 
	         result[2] = c.getString(regid);
	         result[3] =c.getString(gend);
	         result[4] = c.getString(dob);
	         result[5] = c.getString(entyr);
	         result[6] = c.getString(LevelA);
	         result[7] = c.getString(county);
	         result[8] = c.getString(degre);
	         result[9] = c.getString(degreecode);
	         result[10] = c.getString(homeadd);
	         result[11] = c.getString(localphone);
	         result[12] = c.getString(localAdd);
	         result[13] = c.getString(mobil);
	        		 
	         
	     }
	     return result;

	 }
	 
	public void UpdateData(String getusername, String getuniname,
			String getstudidnumber, String getgender, String getdob,
			String getentryyr, String getlevel, String getcountry,
			String getdegree, String getdegcode, String gethaddress,
			String getlocalph, String getlocaladdress, String getmobile) {
		// TODO Auto-generated method stub
		try{
	     	SQLiteDatabase db = this.getWritableDatabase();
	     	
	     	ContentValues row = new ContentValues();
	     	row.put("UserName",getusername);
	        row.put("UniName", getuniname);
	        row.put("StudidNumber",getstudidnumber);
	        row.put("Gender",getgender);
	        row.put("DOB",getdob);
	        row.put("EntryYr",getentryyr);
	        row.put("Level",getlevel);
	        row.put("Country",getcountry);
	        row.put("Degree",getdegree);
	        row.put("DegCode",getdegcode);
	        row.put("Haddress",gethaddress);
	        row.put("LocalPh",getlocalph);
	        row.put("LocalAddress",getlocaladdress);
	        row.put("Mobile",getmobile);
	        
	        long cck = db.update("students", row, "StudidNumber "+"="+getstudidnumber, null);
	      
	        if(cck!=0){
	            Toast.makeText(context, "Record updated successfully",Toast.LENGTH_LONG).show(); 
	        }else{
	            Toast.makeText(context, "Record update failed...! ",Toast.LENGTH_LONG).show();
	        }

	     	}catch (Exception e) {
					// TODO: handle exception
				}
		
	}

	public void DeleteData(String getstudidnumber) {
		try{
			SQLiteDatabase db = this.getWritableDatabase();
			long cck = db.delete("students", "StudidNumber "+"="+getstudidnumber, null);
			if(cck!=0){
	            Toast.makeText(context, "Record deleted successfully",Toast.LENGTH_LONG).show(); 
	        }else{
	            Toast.makeText(context, "Record delete failed...! ",Toast.LENGTH_LONG).show();
	        }
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	}
