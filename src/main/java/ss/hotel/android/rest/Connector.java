package ss.hotel.android.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Connector {
	private static final int port = 8080;
	private static final String ip = "192.168.107.129";
	
	public static String send(String query) {
		String resp;
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application","json"));
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
		String url = "http://" + ip + ":" + port + query;
		RestTemplate restTemplate = new RestTemplate(true);
		ResponseEntity<String> responseEntity =
			restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		resp = responseEntity.getBody();
		
		return resp;
	}
	
	public static String sendPOST(String query, Object body) {
		String resp;
		
		String url = "http://" + ip + ":" + port + query;
		
		// Set the Content-Type header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application","json"));
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(body, requestHeaders);

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the Jackson and String message converters
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		
		// Make the HTTP POST request, marshaling the request to JSON, and the response to a String
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		resp = responseEntity.getBody();
		
		return resp;
	}
}
