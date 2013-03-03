package com.testing.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class LibraryHomeActivity extends Activity {
    private Button libAddMember;
    private Button libAddBook;
    private Button libBookList;
    private Button libCheckOut;
    private Button libCheckIn;
    
    private String[] tempBookArray;
    
    private static final int CREATE_MEMBER=0;
    private static final int CREATE_BOOK=1;
    public LibraryHandler myLibrary;
    
    
    /** Called when the activity is first created. */
   
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        libAddMember = (Button)findViewById(R.id.add_member);
        libAddBook = (Button)findViewById(R.id.add_book);
        libBookList = (Button) findViewById(R.id.book_list);
        libCheckOut = (Button)findViewById(R.id.check_out);
        libCheckIn = (Button)findViewById(R.id.check_in);
        
        myLibrary = new LibraryHandler();
        registerButtonListeners();
            
        
    }
    private void registerButtonListeners() {
        libAddMember.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                // TODO Auto-generated method stub 
                createMember();
                
            }
        });
        
        libAddBook.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                createBook();
                
            }
        });
        
        libBookList.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("LibraryHome","ButtonClicked");
                showBookList();
            }
        });
    }
    
    private void createMember()
   {
        
        Intent i = new Intent(this, LibraryAddMemberActivity.class);
        startActivityForResult(i, CREATE_MEMBER);
    }
    
    private void createBook()
       {
        Intent i = new Intent(this, LibraryAddBookActivity.class);
        startActivityForResult(i, CREATE_BOOK);
        }
        
    private void showBookList(){
        Log.i("LibraryHome","Inside ShowBookList");
        
        int m = myLibrary.getBooks().size();
        int counter = 0;
        if(m>0)
        {
            //ArrayList<LibraryBook> tempBooks = new ArrayList<LibraryBook>();
            //tempBooks = myLibrary.getBooks();
            tempBookArray = new String[m];
            for (LibraryBook aBook: myLibrary.Books)
            {
                tempBookArray[counter]= ('"'+ aBook.getBookName() + '"'+" by: "+aBook.getAuthor());
                //tempBookArray[counter]= aBook.getBookName();
                counter ++;
            }
        }
        
        Intent i = new Intent(this, LibraryBookListActivity.class);
        
        Bundle extras = new Bundle();
        extras.putStringArray("tempBookList", tempBookArray);
        extras.putInt("book_no", m);
        i.putExtras(extras);
        startActivity(i);
        
    }
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    super.onActivityResult(requestCode, resultCode, data);
    
    switch(requestCode)
    {
    case CREATE_MEMBER: if(resultCode==RESULT_OK)
       {
         String tempName, tempNum;
         Bundle extras = data.getExtras();
         tempName = extras.getString("name_data");
         tempNum = extras.getString("num_data");
         
         LibraryMember tempMember = new LibraryMember();
         tempMember.setName(tempName);
         tempMember.setNumber(Integer.parseInt(tempNum));
         
         //Log.i("Library member object created","Number"+tempMember.getNumber());
         //Log.i("Initial Library object", "Number"+myLibrary.getMembers().size());
         myLibrary.addMember(tempMember);
         
        }
    break;
    
    case CREATE_BOOK: if(resultCode==RESULT_OK)
    {
        String tempBName, tempAName;
         Bundle extras = data.getExtras();
         tempBName = extras.getString("name_data");
         tempAName = extras.getString("author_data");
         
         LibraryBook tempBook = new LibraryBook(tempBName,tempAName);
         myLibrary.addBook(tempBook);
         
         
    }
    
    break;
    
    }
    // Reload the list here
}
    
    
}
