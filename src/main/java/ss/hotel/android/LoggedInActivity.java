package ss.hotel.android;

import java.util.List;

import ss.hotel.android.pojo.AddServiceHistory;
import ss.hotel.android.pojo.Roles;
import ss.hotel.android.pojo.Room;
import ss.hotel.android.rest.Connector;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoggedInActivity extends ListActivity {
	public static Object item;
	private List<?> items;
	
	@Override
	protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
		setContentView(R.layout.loggedin);
		
		String[] values = null;
		String role = HelloAndroidActivity.usr.getRole().getName();
		
		if (String.valueOf(Roles.ROLE_CLEANER).equals(role)) {
			
			items = getRooms();
			values = new String[items.size()];
			for(int i = 0; i < items.size(); ++i) {
				values[i] = "Room " + ((Room)items.get(i)).getNumber();
			}
			
		} else if (String.valueOf(Roles.ROLE_TECHNICIST).equals(role)) {
			
			items = getItemsToFix();
			values = new String[items.size()];
			for(int i = 0; i < items.size(); ++i) {
				values[i] = "Room " + ((AddServiceHistory)items.get(i)).getAddService().getName();
			}
			
		}
		
        ArrayAdapter<String> adapter =
        		new ArrayAdapter<String>(this, R.layout.loggedin, R.id.itemslist, values);
        setListAdapter(adapter);
    }
	
	private List<AddServiceHistory> getItemsToFix() {
		String resp = Connector.send("/hotel07/api/service/history");
		return new Gson().fromJson(resp, new TypeToken<List<AddServiceHistory>>(){}.getType());
	}
	
	private List<Room> getRooms() {
		String resp = Connector.send("/hotel07/api/room/list");
		return new Gson().fromJson(resp, new TypeToken<List<Room>>(){}.getType());
	}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	item = items.get(position);
    	
    	String role = HelloAndroidActivity.usr.getRole().getName();
    	if (String.valueOf(Roles.ROLE_CLEANER).equals(role)) {
//	        String item = (String) getListAdapter().getItem(position);
	        
    		Intent intent = new Intent(this, ServiceListActivity.class);
    		startActivity(intent);
	        
    	} else if (String.valueOf(Roles.ROLE_TECHNICIST).equals(role)) {
			// TODO go to the next activity
		}
    }
}
