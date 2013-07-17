package com.kdubb.retrofitexamples.client;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RestAdapter;

import com.kdubb.retrofitexamples.api.SimpleApi;
import com.kdubb.retrofitexamples.domain.CustomChild;
import com.kdubb.retrofitexamples.domain.CustomObject;

public class SimpleClient {
	private static final String API_URL = "http://localhost:8080/";
	private static final Logger LOG = LoggerFactory.getLogger(SimpleClient.class);
	
	public static void main(String[] args) {
		// Build the Retrofit REST adaptor pointing to the URL specified
		RestAdapter restAdapter = new RestAdapter.Builder()
	        .setServer(API_URL)
	        .build();
	
	    // Create an instance of our SimpleApi interface.
		SimpleApi simpleApi = restAdapter.create(SimpleApi.class);
	
		// Call each of the methods and output the results
		System.out.println("simpleApi.simpleGet()=<<" + simpleApi.simpleGet() + ">>");
		System.out.println("simpleApi.simplePost()=<<" + simpleApi.simplePost() + ">>");
		System.out.println("simpleApi.simpleDelete()=<<" + simpleApi.simpleDelete() + ">>");
		System.out.println("simpleApi.simplePut()=<<" + simpleApi.simplePut() + ">>");
		System.out.println("simpleApi.simpleHead()=<<" + simpleApi.simpleHead() + ">>");
		System.out.println("simpleApi.simpleBoolean()=<<" + simpleApi.simpleBoolean() + ">>");
		System.out.println("simpleApi.simpleInteger()=<<" + simpleApi.simpleInteger() + ">>");
		System.out.println("simpleApi.simpleCollection()=<<" + simpleApi.simpleCollection() + ">>");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			// We want to take a peek to see if all the fields are set correctly
			CustomObject custom = simpleApi.simpleCustom();
			System.out.println("simpleApi.simpleCustom()=<<" + custom + ">>");
			System.out.println("simpleApi.simpleCustom() as JSON=<<" + mapper.writeValueAsString(custom) + ">>");
			
			CustomChild child = simpleApi.simpleChild();
			System.out.println("simpleApi.simpleChild()=<<" + child + ">>");
			System.out.println("simpleApi.simpleChild() as JSON=<<" + mapper.writeValueAsString(child) + ">>");
		}
		catch(IOException e) {
			LOG.error("Failed to convert objects to JSON", e);
		}
	}
}