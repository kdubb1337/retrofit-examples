package com.kdubb.retrofitexamples.domain;

import java.util.Collection;
import java.util.Date;

public class CustomObject {
	private String a;
	private int b;
	private boolean c;
	private double d;
	private Date e;
	private Collection<String> f;
	
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
	
	public Date getE() {
		return e;
	}
	
	public void setE(Date e) {
		this.e = e;
	}

	public Collection<String> getF() {
		return f;
	}

	public void setF(Collection<String> f) {
		this.f = f;
	}
}