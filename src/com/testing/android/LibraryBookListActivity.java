package com.testing.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class LibraryBookListActivity extends ListActivity {
    private String[] myBookList;
    private int book_no;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	Log.i("LibraryBookListActivity","Inside Oncreate");
	setContentView(R.layout.book_list);
	
	Bundle extras = getIntent().getExtras();
	if (extras!=null)
	{
		Log.i("LibraryBookListActivity","Extras available");
		myBookList = extras.getStringArray("tempBookList");
		book_no = extras.getInt("book_no");
		
		if (book_no > 0)
		{
			setListAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, myBookList));
		}
	}
	
	}
	
}
