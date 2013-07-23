package com.kdubb.retrofitexamples.api;

import java.util.Date;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import com.kdubb.retrofitexamples.Constants;

public interface InterestingApi {
	@GET(Constants.URL_INTERESTING_DATE)
	public Date getDate();

	@GET(Constants.URL_INTERESTING_PATH)
	public String getWithPath(@Path(Constants.PATH_ID) String id);
	
	@POST(Constants.URL_INTERESTING_BODY)
	public String getWithBody(@Body String id);
	
	@GET(Constants.URL_INTERESTING_QUERY)
	public String getWithQuery(@Query(Constants.PATH_ID) String id);
	
	@GET(Constants.URL_INTERESTING_HEADER)
	public String getWithDynamicHeader(@Header(Constants.HEADER_CACHE_CONTROL) String cacheControlValue);
	
	@Headers("Cache-Control: max-age=640000")
	@GET(Constants.URL_INTERESTING_HEADER)
	public String getWithFixedHeaders();
}