package com.kdubb.retrofitexamples.domain;

import java.util.Collection;

public class CustomObject {
	private String a;
	private int b;
	private boolean c;
	private double d;
	private Collection<String> e;
	
	public String getA() {
		return a;
	}
	
	public void setA(String a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public boolean isC() {
		return c;
	}
	
	public void setC(boolean c) {
		this.c = c;
	}
	
	public double getD() {
		return d;
	}
	
	public void setD(double d) {
		this.d = d;
	}
	
	public Collection<String> getE() {
		return e;
	}

	public void setE(Collection<String> e) {
		this.e = e;
	}
}