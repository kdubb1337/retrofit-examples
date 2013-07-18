package com.kdubb.retrofitexamples.server;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdubb.retrofitexamples.Constants;
import com.kdubb.retrofitexamples.api.InterestingApi;

@Controller
public class InterestingController implements InterestingApi {

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_INTERESTING_DATE, method=RequestMethod.GET)
	public Date getDate() {
		return new Date();
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_INTERESTING_PATH, method=RequestMethod.GET)
	public String getWithPath(@PathVariable(Constants.PATH_ID) String id) {
		// Strings aren't auto-converted to JSON
		return "\"getWithPath(" + id + ")\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_INTERESTING_BODY, method=RequestMethod.POST)
	public String getWithBody(@RequestBody String id) {
		// Strings aren't auto-converted to JSON
		// Body is wrapped in double quotes by default. Want to remove that.
		return "\"getWithBody(" + id.substring(1, id.length() - 1) + ")\"";
	}
	
	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_INTERESTING_QUERY, method=RequestMethod.GET)
	public String getWithQuery(@RequestParam(Constants.PATH_ID) String id) {
		// Strings aren't auto-converted to JSON
		return "\"getWithQuery(" + id + ")\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_INTERESTING_HEADER, method=RequestMethod.GET)
	public String getWithDynamicHeader(@RequestHeader(Constants.HEADER_CACHE_CONTROL) String cacheControlValue) {
		// Strings aren't auto-converted to JSON
		return "\"getWithDynamicHeader(" + cacheControlValue + ")\"";
	}

	@Override @ResponseBody
	@RequestMapping(value=Constants.URL_INTERESTING_HEADERS, method=RequestMethod.GET)
	public String getWithFixedHeaders() {
		// Strings aren't auto-converted to JSON
		// TODO implement this
		return "\"\"";
	}
}