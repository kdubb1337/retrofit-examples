package com.kdubb.retrofitexamples.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

import com.kdubb.retrofitexamples.Constants;

public interface AsynchronousApi {
	@GET(Constants.URL_SIMPLE)
	public void simpleGet(Callback<String> callback);
	
	@GET(Constants.URL_INTERESTING_QUERY)
	public void getWithQuery(@Query(Constants.PATH_ID) String id, Callback<String> callback);
}