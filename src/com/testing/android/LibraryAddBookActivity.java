package com.testing.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LibraryAddBookActivity extends Activity {

	private EditText lbBookName;
	private EditText lbBookAuthor;
	private Button lbBookSave;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.add_book);
	
	lbBookName = (EditText) findViewById(R.id.fld_book_name);
	lbBookAuthor = (EditText) findViewById(R.id.fld_book_author);
	lbBookSave = (Button) findViewById(R.id.save_book);
	
	registerButtonListeners();
	}
	
	private void registerButtonListeners() {
		// TODO Auto-generated method stub
		
		lbBookSave.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				saveBook();
			}

		});
		
	}
	
	private void saveBook() {
		// TODO Auto-generated method stub
		
		String name = lbBookName.getText().toString();
		String author = lbBookAuthor.getText().toString();
		Log.i("name data:", name);
		Log.i("author data", author);
			
		
		Intent tempIntent = new Intent(this, LibraryHomeActivity.class);
		Bundle extras = new Bundle();
		
		extras.putString("name_data", name);
		extras.putString("author_data", author);
		tempIntent.putExtras(extras);
		
		setResult(LibraryAddBookActivity.RESULT_OK,tempIntent);
		Toast.makeText(LibraryAddBookActivity.this, getString(R.string.save_book_note), Toast.LENGTH_SHORT).show();
		finish();
		
	}
	
	
	
}
