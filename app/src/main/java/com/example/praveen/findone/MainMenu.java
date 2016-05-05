package com.example.praveen.findone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    ImageButton bProfile;
    ImageButton bAbout;
    ImageButton bMsg;
    ImageButton bLogout;
    ImageButton bList;
    ImageButton bSearch;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent = getIntent();
         userId = intent.getStringExtra("ID");
        bProfile=(ImageButton)findViewById(R.id.icoprof);
        bProfile.setOnClickListener(this);
        bAbout=(ImageButton)findViewById(R.id.icoinfo);
        bAbout.setOnClickListener(this);
        bMsg=(ImageButton)findViewById(R.id.icomes);
        bMsg.setOnClickListener(this);
        bLogout=(ImageButton)findViewById(R.id.icologout);
        bLogout.setOnClickListener(this);
        bList=(ImageButton)findViewById(R.id.icomylist);
        bList.setOnClickListener(this);
        bSearch=(ImageButton)findViewById(R.id.icosearch);
        bSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if(v.getId()==R.id.icoprof)
{
    startActivity(new Intent(this,Account.class));
}
        else if(v.getId()==R.id.icoinfo)
        {
            startActivity(new Intent(this,About.class));
        }
else if(v.getId()==R.id.icomes)
{
    startActivity(new Intent(this,Inbox.class));
}
else if(v.getId()==R.id.icosearch)
{
    startActivity(new Intent(this,Search.class));
}
else if(v.getId()==R.id.icomylist)
{

    Intent myIntent = new Intent(getApplicationContext(), Mylist.class);
    myIntent.putExtra("ID",userId);
    startActivity(myIntent);
}
else if(v.getId()==R.id.icologout)
{
    finish();

}

    }
}
