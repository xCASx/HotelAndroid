package ss.hotel.android;

import ss.hotel.android.pojo.Roles;
import ss.hotel.android.pojo.User;
import ss.hotel.android.rest.Connector;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;


public class HelloAndroidActivity extends Activity implements OnClickListener {
	public static User usr;
	Button loginBtn;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        loginBtn.setText(R.string.loginBtnStr);
        
        TextView loginView = (TextView) findViewById(R.id.loginView);
        loginView.setText(R.string.loginStr);
        
        TextView passwdView = (TextView) findViewById(R.id.passwdView);
        passwdView.setText(R.string.passwdStr);
        
        TextView hotelView = (TextView) findViewById(R.id.hotelView);
        hotelView.setText(R.string.loginStr);
    }
    
    @Override
    public void onClick(View v) {
    	switch (v.getId()) {
        	case R.id.loginBtn: {
        		EditText loginTxt = (EditText) findViewById(R.id.loginTxt);
        		EditText passwdTxt = (EditText) findViewById(R.id.passwdTxt);
        		String login = loginTxt.getText().toString();
        		String pass = passwdTxt.getText().toString();
        		
        		// Check login/pass
        		String resp = Connector.send("/hotel07/api/login/" + login + "/" + pass);
        		
        		if(resp.equals("false")) {
        			// Incorrect login
        			loginTxt.setText("");
        			passwdTxt.setText("");
        			Toast.makeText(this, "Error! Incorrect login or password", Toast.LENGTH_LONG).show();
        		} else {
        			usr = new Gson().fromJson(resp, User.class);
        			
        			boolean correctRole = false;
        			for (Roles role : Roles.values()) {
        		        if (String.valueOf(role).equals(usr.getRole().getName())) {
        		        	correctRole = true;
        		        	break;
        		        }
        		    }
        			
        			if(correctRole) {
		        		// Go to the next activity
		        		Intent intent = new Intent(this, LoggedInActivity.class);
		        		startActivity(intent);
	        		} else {
	        			loginTxt.setText("");
	        			passwdTxt.setText("");
	        			Toast.makeText(this, "Error! Sorry, you have no permissions", Toast.LENGTH_LONG).show();
	        		}
        		}
        		
				break;
        	}
	        default: {
	        	break;
	        }
        }
    }
}

