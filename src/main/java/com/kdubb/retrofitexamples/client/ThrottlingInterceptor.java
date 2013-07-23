
package com.kdubb.retrofitexamples.client;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RequestInterceptor;

public class ThrottlingInterceptor implements RequestInterceptor {
	private long lastRequest = 0L;
	private final long maxRequestSpeed;
	private final Lock requestLock = new ReentrantLock();
	private static final Logger LOG = LoggerFactory.getLogger(ThrottlingInterceptor.class);
	
	public ThrottlingInterceptor(long maxRequestSpeed) {
		this.maxRequestSpeed = maxRequestSpeed;
	}

	@Override
	public void intercept(RequestFacade request) {
		requestLock.lock();
		
		try {
			long curTime = System.currentTimeMillis();
			long diff = curTime - lastRequest;

			// sleep if request came too quickly
			if (diff < maxRequestSpeed)
				try {
					Thread.sleep(maxRequestSpeed - diff);
				}
				catch (InterruptedException e) {
					LOG.error("Failed to intercept", e);
				}

			lastRequest = System.currentTimeMillis();
		}
		finally {
			requestLock.unlock();
		}
	}
}