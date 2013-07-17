package com.kdubb.retrofitexamples.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RestAdapter;

import com.kdubb.retrofitexamples.api.SimpleApi;

public class JacksonClient {
	private static final String API_URL = "http://localhost:8080/";
	private static final Logger LOG = LoggerFactory.getLogger(SimpleClient.class);
	
	public static void main(String[] args) {
		// Set custom converter here
		
		// Build the Retrofit REST adaptor pointing to the URL specified
		RestAdapter restAdapter = new RestAdapter.Builder()
	        .setServer(API_URL)
	        .build();
	
	    // Create an instance of our SimpleApi interface.
		SimpleApi simpleApi = restAdapter.create(SimpleApi.class);
	}
}