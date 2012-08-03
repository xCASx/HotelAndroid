package ss.hotel.android;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class HelloAndroidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView springmessage = (TextView) findViewById(R.id.springmessage);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application","json"));
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
        String url = "http://85.198.176.13:8080/hotel/api";
        RestTemplate restTemplate = new RestTemplate(true);
    	ResponseEntity<String> responseEntity =
    			restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String result = responseEntity.getBody();
        springmessage.setText(result);

    }
}

