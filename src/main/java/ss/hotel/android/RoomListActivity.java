package ss.hotel.android;

import java.util.List;

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

public class RoomListActivity extends ListActivity {
	public static Object item;
	private List<Room> items;
	
	@Override
	protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
		setContentView(R.layout.roomlist);
		
		items = getRooms();
		String[] values = new String[items.size()];
		for(int i = 0; i < items.size(); ++i) {
			values[i] = "Room " + ((Room)items.get(i)).getNumber();
		}
		
        ArrayAdapter<String> adapter =
        		new ArrayAdapter<String>(this, R.layout.roomlist, R.id.roomslist, values);
        setListAdapter(adapter);
    }
	
	private List<Room> getRooms() {
		String resp = Connector.send("/hotel07/api/room/list");
		return new Gson().fromJson(resp, new TypeToken<List<Room>>(){}.getType());
	}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	item = items.get(position);
    	
		Intent intent = new Intent(this, ServiceListActivity.class);
		startActivity(intent);
    }
}
