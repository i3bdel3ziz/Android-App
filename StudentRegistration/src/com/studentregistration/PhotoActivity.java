package com.studentregistration;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class PhotoActivity extends Activity{
	//int REQUEST_IMAGE_CAPTURE = 1;
	Button takephoto, viewphotos;
	int REQUEST_CODE =1;
	ImageView image;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoactivity);
        image = (ImageView)findViewById(R.id.imageView1);
        takephoto = (Button)findViewById(R.id.btnTakePhoto);
        takephoto.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				if(i.resolveActivity(getPackageManager())!=null){
					startActivityForResult(i,REQUEST_CODE);
				}
			}
        	
        });
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_CODE)
	    {
	    	if(resultCode == RESULT_OK) {
	    		
	        Bundle xx = data.getExtras();
	        Bitmap imageBitmap = (Bitmap) xx.get("data");
	        image.setImageBitmap(imageBitmap);
	    }
	}
	}

}
