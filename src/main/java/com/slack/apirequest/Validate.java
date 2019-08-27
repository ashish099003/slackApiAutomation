package com.slack.apirequest;

import org.testng.Assert;

import com.jayway.restassured.response.Response;
import com.treebo.apicommons.helpers.CustomAssert;

public class Validate {
	
	public static Response response ;
	public static void setResponse(Response res) {
		response= res;
	}

	public static Response getResponse() {
		return response;
	}
	
	public static void validateResponseCode(int code) {
		Assert.assertEquals(getResponse().getStatusCode(),code);
	}
	
	public static void validateData(String infodata) {
		Assert.assertTrue(getResponse().getBody().asString().contains(infodata));
	}

}
