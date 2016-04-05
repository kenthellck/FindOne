package com.example.praveen.findone;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class Mylist extends AppCompatActivity implements View.OnClickListener {
    private DbHelper dbHelper;
    private Cursor cursor;
    private Button mylistAddbtn;
    private EditText mylistName,mylistCat,mylistdes;
    private TableLayout tableLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        dbHelper = new DbHelper(getApplicationContext());
        mylistAddbtn = (Button) findViewById(R.id.mylistAddbtn);
        mylistName = (EditText) findViewById(R.id.mylistName);
        mylistCat = (EditText) findViewById(R.id.mylistCat);
        mylistdes = (EditText) findViewById(R.id.mylistdes);

//        Attaching listeners for all buttons
        mylistAddbtn.setOnClickListener(this);
        tableLayout1 =(TableLayout)findViewById(R.id.tableLayout1);

    }

    @Override
    public void onClick(View v) {
        String name=mylistName.getText().toString();
        String cat=mylistCat.getText().toString();
        String des=mylistdes.getText().toString();

        if(v.getId()==R.id.mylistAddbtn)
        {
            dbHelper.inserRecord(name,cat,"owner","021121",des);
            Toast.makeText(Mylist.this, "Record Inserted Successfully...! \n Employee Name : sachin \n Salary : 15000 Rs.", Toast.LENGTH_LONG).show();

        }

    }
}
