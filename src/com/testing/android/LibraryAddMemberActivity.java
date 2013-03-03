package com.testing.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LibraryAddMemberActivity extends Activity {
	private EditText lbMemberName;
	private EditText lbMemberPhone;
	private Button lbMemberSave;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.add_member);
	
	lbMemberName = (EditText) findViewById(R.id.fld_member_name);
	lbMemberPhone = (EditText) findViewById(R.id.fld_member_num);
	lbMemberSave =  (Button) findViewById(R.id.save_member);
	
	 registerButtonListeners();
	
	}

	private void registerButtonListeners() {
		// TODO Auto-generated method stub
		
		lbMemberSave.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				saveMember();
			}

		});
		
	}
	
	private void saveMember() {
		// TODO Auto-generated method stub
		
		String name = lbMemberName.getText().toString();
		String number = lbMemberPhone.getText().toString();
		//Log.i("name data:", name);
		//Log.i("number data", number);
			
		
		Intent tempIntent = new Intent(this, LibraryHomeActivity.class);
		Bundle extras = new Bundle();
		
		extras.putString("name_data", name);
		extras.putString("num_data", number);
		tempIntent.putExtras(extras);
		
		setResult(LibraryAddMemberActivity.RESULT_OK,tempIntent);
		Toast.makeText(LibraryAddMemberActivity.this, getString(R.string.save_member_note), Toast.LENGTH_SHORT).show();
		finish();
		
	}
	
	
	
}
