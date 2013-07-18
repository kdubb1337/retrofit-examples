package com.kdubb.retrofitexamples.client;

import org.codehaus.jackson.map.ObjectMapper;

import retrofit.RestAdapter;

import com.kdubb.retrofitexamples.api.InterestingApi;
import com.kdubb.retrofitexamples.converter.JacksonConverter;

public class InterestingClient {
	private static final String API_URL = "http://localhost:8080/";

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
		
		// Call each of the methods and output the results
		System.out.println("api.getDate()={" + api.getDate() + "}");
		System.out.println("api.getWithPath()={" + api.getWithPath("my String 1234") + "}");
		System.out.println("api.getWithQuery()={" + api.getWithQuery("my String 1234") + "}");
		System.out.println("api.getWithBody()={" + api.getWithBody("my String 1234") + "}");
		System.out.println("api.getWithDynamicHeader()={" + api.getWithDynamicHeader("max-age=26000") + "}");
	}
}