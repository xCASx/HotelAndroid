package ss.hotel.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WhoPaysActivity extends Activity implements OnClickListener {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newservise);
        
        Button whoPaysBtn = (Button) findViewById(R.id.whoPaysBtn);
        whoPaysBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
	    	case R.id.loginBtn: {
	    		Intent intent = new Intent(this, TaskListActivity.class);
	    		startActivity(intent);
				break;
	    	}
	        default: {
	        	break;
	        }
	    }
	}
	
}
