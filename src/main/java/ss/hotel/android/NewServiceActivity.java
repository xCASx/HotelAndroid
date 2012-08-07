package ss.hotel.android;

import java.util.Date;

import ss.hotel.android.pojo.AddServiceHistory;
import ss.hotel.android.pojo.HotelOrder;
import ss.hotel.android.rest.Connector;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class NewServiceActivity extends Activity implements OnClickListener {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newservise);

        TextView serviceTxt = (TextView) findViewById(R.id.serviceTxt);
        serviceTxt.setText(ServiceListActivity.service.getName());
        
        Button createSrvBtn = (Button) findViewById(R.id.createSrvBtn);
        createSrvBtn.setOnClickListener(this);
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter =
				ArrayAdapter.createFromResource(this,
						R.array.spinnerValues, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
    }
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
	    	case R.id.createSrvBtn: {
	    		Object body = createAddService();
	    		
	    		Connector.sendPOST("/hotel07/api/service/add", body);
	    		
	    		Intent intent = new Intent(this, LoggedInActivity.class);
        		startActivity(intent);
				break;
	    	}
	        default: {
	        	break;
	        }
		}
	}
	
	private AddServiceHistory createAddService() {
		AddServiceHistory addServiceHistory = new AddServiceHistory();
		
		HotelOrder ho = new HotelOrder();
		ho.setId(1L);
		
		double amt = Double.parseDouble(((EditText) findViewById(R.id.countEdit)).getText().toString());
		
		addServiceHistory.setAddService(ServiceListActivity.service);
		addServiceHistory.setAmount(amt);
		addServiceHistory.setClientPaid(null);
		addServiceHistory.setDatePrice(ServiceListActivity.service.getPrice());
		addServiceHistory.setId(null);
		addServiceHistory.setOpperationDate(new Date());
		addServiceHistory.setOrder(ho);
		addServiceHistory.setUser(HelloAndroidActivity.usr);
		
		return addServiceHistory;
	}

}
