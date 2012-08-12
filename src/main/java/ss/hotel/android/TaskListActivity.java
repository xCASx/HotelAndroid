package ss.hotel.android;

import java.util.List;

import ss.hotel.android.pojo.AddServiceHistory;
import ss.hotel.android.pojo.Roles;
import ss.hotel.android.rest.Connector;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TaskListActivity extends ListActivity {
	public static Object item;
	private List<AddServiceHistory> items;
	
	@Override
	protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
		setContentView(R.layout.tasklist);
		
		items = getItemsToFix();
		String[] values = new String[items.size()];
		for(int i = 0; i < items.size(); ++i) {
			values[i] = "Room " + ((AddServiceHistory)items.get(i)).getAddService().getName();
		}
		
        ArrayAdapter<String> adapter =
        		new ArrayAdapter<String>(this, R.layout.tasklist, R.id.taskslist, values);
        setListAdapter(adapter);
    }
	
	private List<AddServiceHistory> getItemsToFix() {
		String resp = Connector.send("/hotel07/api/service/history/" + Roles.ROLE_TECHNICIST);
		return new Gson().fromJson(resp, new TypeToken<List<AddServiceHistory>>(){}.getType());
	}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	item = items.get(position);
        
//    	Intent intent = new Intent(this, WhoPaysActivity.class);
//		startActivity(intent);
		// TODO process item
    }
}
