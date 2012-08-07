package ss.hotel.android;

import java.util.List;

import ss.hotel.android.pojo.AddService;
import ss.hotel.android.rest.Connector;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServiceListActivity extends ListActivity {
	
	public static AddService service;
	private List<AddService> services;

	@Override
	protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
		setContentView(R.layout.services);
		
		services = getServices();
		String[] values = new String[services.size()];
		for(int i = 0; i < services.size(); ++i) {
			values[i] = ((AddService)services.get(i)).getName();
		}
		
        ArrayAdapter<String> adapter =
        		new ArrayAdapter<String>(this, R.layout.services, R.id.serviceslist, values);
        setListAdapter(adapter);
	}
	
	private List<AddService> getServices() {
		String resp = Connector.send("/hotel07/api/service/list");
		return new Gson().fromJson(resp, new TypeToken<List<AddService>>(){}.getType());
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
		service = services.get(position);
		
		Intent intent = new Intent(this, NewServiceActivity.class);
		startActivity(intent);
	}
}
