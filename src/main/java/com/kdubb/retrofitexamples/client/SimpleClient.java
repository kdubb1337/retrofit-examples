package com.kdubb.retrofitexamples.client;

import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RestAdapter;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import com.kdubb.retrofitexamples.api.SimpleApi;

public class SimpleClient {
	private static final String API_URL = "http://localhost:8080/";
	private static final Logger LOG = LoggerFactory.getLogger(SimpleClient.class);
	
	public static void main(String[] args) {
		RestAdapter restAdapter = new RestAdapter.Builder()
	        .setServer(API_URL)
	        .build();
	
	    // Create an instance of our SimpleApi interface.
		SimpleApi simpleApi = restAdapter.create(SimpleApi.class);
	
		LOG.info("simpleApi.simpleGet()=<<" + simpleApi.simpleGet() + ">>");
		LOG.info("simpleApi.simplePost()=<<" + simpleApi.simplePost() + ">>");
		LOG.info("simpleApi.simpleDelete()=<<" + simpleApi.simpleDelete() + ">>");
		LOG.info("simpleApi.simplePut()=<<" + simpleApi.simplePut() + ">>");
		LOG.info("simpleApi.simpleHead()=<<" + simpleApi.simpleHead() + ">>");
		LOG.info("simpleApi.simpleBoolean()=<<" + simpleApi.simpleBoolean() + ">>");
		LOG.info("simpleApi.simpleInteger()=<<" + simpleApi.simpleInteger() + ">>");
		LOG.info("simpleApi.simpleCustom()=<<" + simpleApi.simpleCustom() + ">>");
		LOG.info("simpleApi.simpleChild()=<<" + simpleApi.simpleChild() + ">>");
		LOG.info("simpleApi.simpleCollection()=<<" + simpleApi.simpleCollection() + ">>");
	}
}