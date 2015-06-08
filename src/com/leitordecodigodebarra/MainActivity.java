package com.leitordecodigodebarra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static final int REQUEST_CODE = 0;
	private Button bt_consult;
	private TextView txt_result;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_consult = (Button) findViewById(R.id.bt_consult);
		
		bt_consult.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent it = new Intent(MainActivity.this, com.google.zxing.client.android.CaptureActivity.class);
				startActivityForResult(it, REQUEST_CODE);
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(REQUEST_CODE == requestCode && RESULT_OK == resultCode){
			String result = data.getStringExtra("SCAN_RESULT");
			txt_result = (TextView) findViewById(R.id.txt_Result);
			txt_result.setText(result);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
