package com.kdubb.retrofitexamples.converter;

import java.lang.reflect.Type;

import org.codehaus.jackson.map.ObjectMapper;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class JacksonConverter implements Converter {
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Object fromBody(TypedInput body, Type type)
			throws ConversionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypedOutput toBody(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}