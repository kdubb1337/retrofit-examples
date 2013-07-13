package com.kdubb.retrofitexamples.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.kdubb.retrofitexamples.domain.CustomChild;
import com.kdubb.retrofitexamples.domain.CustomObject;

@Service
public class CustomFactory {
	public CustomObject buildCustomObject() {
		CustomObject customObject = new CustomObject();
		customObject.setA("a string thing");
		customObject.setB(123456);
		customObject.setC(true);
		customObject.setD(1.23456);
		
		Collection<String> strings = new ArrayList<String>();
		
		for(int i = 1; i < 4; i++)
			strings.add("string #" + i);
			
		customObject.setE(strings);
		
		return customObject;
	}
	
	public CustomChild buildCustomChild() {
		CustomChild customChild = new CustomChild();
		customChild.setA("a string thing");
		customChild.setB(123456);
		customChild.setC(true);
		customChild.setD(1.23456);
		
		Collection<String> strings = new ArrayList<String>();
		
		for(int i = 1; i < 4; i++)
			strings.add("string #" + i);
			
		customChild.setE(strings);
		customChild.setChildOnly("Only the child has this field");
		
		return customChild;
	}
}