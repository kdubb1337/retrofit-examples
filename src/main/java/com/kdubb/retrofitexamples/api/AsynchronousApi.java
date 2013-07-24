package com.kdubb.retrofitexamples.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import com.kdubb.retrofitexamples.Constants;

public interface AsynchronousApi {
	@GET(Constants.URL_SIMPLE)
	public void simpleGet(Callback<String> callback);

	@GET(Constants.URL_INTERESTING_PATH)
	public void getWithPath(@Path(Constants.PATH_ID) String id, Callback<String> callback);
}