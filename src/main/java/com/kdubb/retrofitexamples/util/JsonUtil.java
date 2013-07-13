package com.kdubb.retrofitexamples.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
	
	public String writeValueAsString(String value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (IOException e) {
			LOG.error("Failed to writeValueAsString", e);
			return null;
		}
	}
}