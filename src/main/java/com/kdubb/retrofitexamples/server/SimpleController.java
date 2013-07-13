package com.kdubb.retrofitexamples.server;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdubb.retrofitexamples.Constants;
import com.kdubb.retrofitexamples.api.SimpleApi;
import com.kdubb.retrofitexamples.domain.CustomChild;
import com.kdubb.retrofitexamples.domain.CustomObject;
import com.kdubb.retrofitexamples.factory.CustomFactory;

@Controller
@RequestMapping
public class SimpleController implements SimpleApi {
	@Inject
	private CustomFactory customFactory;

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE, method=RequestMethod.GET)
	public String simpleGet() {
		// Strings aren't auto-converted to JSON
		return "\"You called simpleGet\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE, method=RequestMethod.POST)
	public String simplePost() {
		// Strings aren't auto-converted to JSON
		return "\"You called simplePost\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE, method=RequestMethod.DELETE)
	public String simpleDelete() {
		// Strings aren't auto-converted to JSON
		return "\"You called simpleDelete\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE, method=RequestMethod.PUT)
	public String simplePut() {
		// Strings aren't auto-converted to JSON
		return "\"You called simplePut\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE, method=RequestMethod.HEAD)
	public String simpleHead() {
		// Strings aren't auto-converted to JSON
		return "\"You called simpleHead\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE_BOOLEAN, method=RequestMethod.GET)
	public boolean simpleBoolean() {
		return true;
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE_INTEGER, method=RequestMethod.GET)
	public int simpleInteger() {
		return 123456;
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE_CUSTOM, method=RequestMethod.GET)
	public CustomObject simpleCustom() {
		return customFactory.buildCustomObject();
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE_CHILD, method=RequestMethod.GET)
	public CustomChild simpleChild() {
		return customFactory.buildCustomChild();
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_SIMPLE_COLLECTION, method=RequestMethod.GET)
	public Collection<String> simpleCollection() {
		Collection<String> strings = new ArrayList<String>();
		
		// Results in [string #1, string #2, string #3]
		for(int i = 1; i < 4; i++)
			strings.add("String #" + i);
		
		return strings;
	}
}