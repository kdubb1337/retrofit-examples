package com.kdubb.retrofitexamples.api;

import java.util.Collection;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.HEAD;
import retrofit.http.POST;
import retrofit.http.PUT;

import com.kdubb.retrofitexamples.Constants;
import com.kdubb.retrofitexamples.domain.CustomChild;
import com.kdubb.retrofitexamples.domain.CustomObject;

public interface SimpleApi {
	@GET(Constants.URL_SIMPLE)
	public String simpleGet();
	
	@POST(Constants.URL_SIMPLE)
	public String simplePost();
	
	@DELETE(Constants.URL_SIMPLE)
	public String simpleDelete();
	
	@PUT(Constants.URL_SIMPLE)
	public String simplePut();
	
	@HEAD(Constants.URL_SIMPLE)
	public String simpleHead();
	
	@GET(Constants.URL_SIMPLE_BOOLEAN)
	public boolean simpleBoolean();
	
	@GET(Constants.URL_SIMPLE_INTEGER)
	public int simpleInteger();
	
	@GET(Constants.URL_SIMPLE_DATE)
	public Date simpleDate();
	
	@GET(Constants.URL_SIMPLE_CUSTOM)
	public CustomObject simpleCustom();
	
	@GET(Constants.URL_SIMPLE_CHILD)
	public CustomChild simpleChild();
	
	@GET(Constants.URL_SIMPLE_COLLECTION)
	public Collection<String> simpleCollection();
}