package com.kdubb.retrofitexamples.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.kdubb.retrofitexamples.api.AsynchronousApi;
import com.kdubb.retrofitexamples.api.InterestingApi;
import com.kdubb.retrofitexamples.api.SimpleApi;

public class AsynchronousClient {
	private static final String API_URL = "http://localhost:8080/";
	private static final Logger LOG = LoggerFactory.getLogger(AsynchronousClient.class);
	
	public static void main(String[] args) {
		// Build the Retrofit REST adaptor pointing to the URL specified, with the Converter.
		// Note: The Converter must be set before the .build() command
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setRequestInterceptor(new ThrottlingInterceptor(2000L))
	        .setServer(API_URL)
	        .build();
	
		// Create an instance of our InterestingApi interface.
		InterestingApi synchronousApi = restAdapter.create(InterestingApi.class);
		
	    // Create an instance of our AsynchronousApi interface.
		AsynchronousApi asyncApi = restAdapter.create(AsynchronousApi.class);
		
		for(int i = 0; i < 10; i++)
			LOG.info("synchronousApi " + synchronousApi.getWithPath(Integer.toString(i)));
		
		for(int i = 0; i < 10; i++)
			asyncApi.getWithQuery(Integer.toString(i), new Callback<String>() {

				@Override
				public void success(String t, Response response) {
					LOG.info("asynchronousApi (" + t + ")");
				}
				@Override
				public void failure(RetrofitError error) {
					LOG.info("Epic fail!");
				}
			});
	}
}