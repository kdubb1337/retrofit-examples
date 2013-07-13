package com.kdubb.retrofitexamples.server;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdubb.retrofitexamples.api.SimpleApi;
import com.kdubb.retrofitexamples.domain.CustomChild;
import com.kdubb.retrofitexamples.domain.CustomObject;
import com.kdubb.retrofitexamples.factory.CustomFactory;
import com.kdubb.retrofitexamples.util.JsonUtil;

@Controller
@RequestMapping
public class SimpleController implements SimpleApi {
	@Inject
	private CustomFactory customFactory;

	private final JsonUtil jsonUtil = new JsonUtil();
	
	@Override @ResponseBody
	@RequestMapping(value="/simple", method=RequestMethod.GET)
	public String simpleGet() {
		return jsonUtil.writeValueAsString("You called simpleGet");
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple", method=RequestMethod.POST)
	public String simplePost() {
		return jsonUtil.writeValueAsString("You called simplePost");
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple", method=RequestMethod.DELETE)
	public String simpleDelete() {
		return jsonUtil.writeValueAsString("You called simpleDelete");
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple", method=RequestMethod.PUT)
	public String simplePut() {
		return jsonUtil.writeValueAsString("You called simplePut");
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple", method=RequestMethod.HEAD)
	public String simpleHead() {
		return jsonUtil.writeValueAsString("You called simpleHead");
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple/boolean", method=RequestMethod.GET)
	public boolean simpleBoolean() {
		return true;
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple/integer", method=RequestMethod.GET)
	public int simpleInteger() {
		return 123456;
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple/custom", method=RequestMethod.GET)
	public CustomObject simpleCustom() {
		return customFactory.buildCustomObject();
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple/child", method=RequestMethod.GET)
	public CustomChild simpleChild() {
		return customFactory.buildCustomChild();
	}

	@Override @ResponseBody
	@RequestMapping(value="/simple/collection", method=RequestMethod.GET)
	public Collection<String> simpleCollection() {
		Collection<String> strings = new ArrayList<String>();
		
		for(int i = 1; i < 4; i++)
			strings.add("string #" + i);
		
		return strings;
	}
}