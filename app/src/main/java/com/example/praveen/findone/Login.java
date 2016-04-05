package com.example.praveen.findone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.StringTokenizer;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername,etPassword;
    Button bLogin;
    TextView tvregisterlink,uiUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
         uiUpdate = (TextView) findViewById(R.id.output);
        bLogin=(Button)findViewById(R.id.bLogin);
        tvregisterlink=(TextView)findViewById(R.id.tvregisterlink);
        bLogin.setOnClickListener(this);
tvregisterlink.setOnClickListener(this);
        bLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // WebServer Request URL
                String serverURL = "http://hoola2.bugs3.com/UserLogin.php";

                // Use AsyncTask execute Method To Prevent ANR Problem
                new LongOperation().execute(serverURL);
            }
        });
        
    }
    public class LongOperation  extends AsyncTask<String, Void, Void> {

        // Required initialization

        private final HttpClient Client = new DefaultHttpClient();
        private String Content;
        private String Error = null;
        private ProgressDialog Dialog = new ProgressDialog(Login.this);
        String email ="";
        String password ="";
        String age ="";
        String name ="";
        TextView uiUpdate = (TextView) findViewById(R.id.output);
        TextView jsonParsed = (TextView) findViewById(R.id.jsonParsed);
        int sizeData = 0;
       
        EditText epass=(EditText)findViewById(R.id.etPassword);
        EditText eemail=(EditText)findViewById(R.id.etUsername);



        protected void onPreExecute() {
            // NOTE: You can call UI Element here.

            //Start Progress Dialog (Message)

            Dialog.setMessage("Please wait..");
            Dialog.show();

            try{
                // Set Request parameter
                email +="&" + URLEncoder.encode("data", "UTF-8") + "="+eemail.getText();
                password=epass.getText().toString();
                
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {

            /************ Make Post Call To Web Server ***********/
            BufferedReader reader=null;

            // Send data
            try
            {

                // Defined URL  where to send data
                URL url = new URL(urls[0]);
                //  URL url2 = new URL(urls[1]);

                // Send POST data request

                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write( email +'#');
                wr.write( password );
                wr.flush();


                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();

                // Read Server Response

                sb.append(reader.readLine()+" ");

                // Append Server Response To Content String
                Content = sb.toString();
                StringTokenizer token=new StringTokenizer(Content,"<");
                while (token.hasMoreTokens())
                {
                    Content=token.nextToken();
                    token.nextToken();
                }

            }
            catch(Exception ex)
            {
                Error = ex.getMessage();
            }
            finally
            {
                try
                {

                    reader.close();
                }

                catch(Exception ex) {}
            }

            /*****************************************************/
            return null;
        }

        protected void onPostExecute(Void unused) {
            // NOTE: You can call UI Element here.

            // Close progress dialog
            Dialog.dismiss();

            if (Error != null) {

                uiUpdate.setText("Output : "+Error);

            }
            else {

                // Show Response Json On Screen (activity)
                if (Content.equals("1"))
                {

                    Toast.makeText(Login.this,
                            "Welcome", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, MainMenu.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Login.this,
                            "Error Login", Toast.LENGTH_LONG).show();


                }
                uiUpdate.setText(Content);


            }
        }

    }

    @Override
    public void onClick(View v) {

        String uname=etUsername.getText().toString();
        String pass=etPassword.getText().toString();


if((uiUpdate.getText().toString().equals("1")) &&(v.getId()==R.id.bLogin))
{
    // WebServer Request URL
    Toast.makeText(Login.this,
            "koko", Toast.LENGTH_LONG).show();
   // startActivity(new Intent(this, MainMenu.class));

       /* if((uname.equals("ck"))&&(pass.equals("123123")))
        {

            Toast.makeText(Login.this,
                    "Welcome", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,MainMenu.class));
        }*/

    }
   else  if(v.getId()==R.id.tvregisterlink)
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
