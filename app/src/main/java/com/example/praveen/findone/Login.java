package com.example.praveen.findone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername,etPassword;
    Button bLogin;
    TextView tvregisterlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bLogin=(Button)findViewById(R.id.bLogin);
        tvregisterlink=(TextView)findViewById(R.id.tvregisterlink);
        bLogin.setOnClickListener(this);
tvregisterlink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String uname=etUsername.getText().toString();
        String pass=etPassword.getText().toString();


if(v.getId()==R.id.bLogin)
{
        if((uname.equals("ck"))&&(pass.equals("123123")))
        {

            Toast.makeText(Login.this,
                    "Welcome", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,MainMenu.class));
        }
    }
    else if(v.getId()==R.id.tvregisterlink)
{

    startActivity(new Intent(this,Register.class));
}
    }


/* public void onClick() {

            Toast.makeText(Login.this,
                    "Welcome", Toast.LENGTH_LONG).show();
            String uname=etUsername.getText().toString();
            String pass=etPassword.getText().toString();

           /* User user=new User(null,null);
            userLocalStore.storeUserData(user);
            userLocalStore.setUserLoggedIn(true);

            if((uname.equals("ck"))&&(pass.equals("123123")))
            {

                Toast.makeText(Login.this,
                        "Welcome", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainMenu.class));
            }



    }*/

}
