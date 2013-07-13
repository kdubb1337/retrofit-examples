package com.kdubb.retrofitexamples.api;

import java.util.Collection;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.HEAD;
import retrofit.http.POST;
import retrofit.http.PUT;

import com.kdubb.retrofitexamples.domain.CustomChild;
import com.kdubb.retrofitexamples.domain.CustomObject;

public interface SimpleApi {
	@GET("/simple.json")
	public String simpleGet();
	
	@POST("/simple")
	public String simplePost();
	
	@DELETE("/simple")
	public String simpleDelete();
	
	@PUT("/simple")
	public String simplePut();
	
	@HEAD("/simple")
	public String simpleHead();
	
	@GET("/simple/boolean")
	public boolean simpleBoolean();
	
	@GET("/simple/integer")
	public int simpleInteger();
	
	@GET("/simple/custom")
	public CustomObject simpleCustom();
	
	@GET("/simple/child")
	public CustomChild simpleChild();
	
	@GET("/simple/collection")
	public Collection<String> simpleCollection();
}