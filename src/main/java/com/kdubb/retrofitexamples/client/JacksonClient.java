package com.kdubb.retrofitexamples.client;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RestAdapter;

import com.kdubb.retrofitexamples.api.InterestingApi;
import com.kdubb.retrofitexamples.converter.JacksonConverter;

public class JacksonClient {
	private static final String API_URL = "http://localhost:8080/";
	private static final Logger LOG = LoggerFactory.getLogger(SimpleClient.class);
	
	public static void main(String[] args) {
		// Create our Converter
		JacksonConverter converter = new JacksonConverter(new ObjectMapper());
		
		// Build the Retrofit REST adaptor pointing to the URL specified, with the Converter.
		// Note: The Converter must be set before the .build() command
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setConverter(converter)
	        .setServer(API_URL)
	        .build();
	
	    // Create an instance of our InterestingApi interface.
		InterestingApi api = restAdapter.create(InterestingApi.class);
	}
}