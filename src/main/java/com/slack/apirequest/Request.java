package com.slack.apirequest;

import java.util.HashMap;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class Request extends RequestTemplate{
	public Request(String apiName, String uri, String requestType, HashMap<String, String> header,
			HashMap<String, String> params) {
		super(apiName, uri, requestType, header, params);
		// TODO Auto-generated constructor stub
	}

	Response response=null;
	
	public Response createChannel(RequestTemplate reqtemp) {
				
		if(reqtemp.getrequestType()=="POST") {
			response= RestAssured
					.given()
					.headers(reqtemp.getHeaders())
					.parameters(reqtemp.getParameters())

					.when()
					.post(reqtemp.geturi())
					.then()
					.extract()
					.response();
			
		}				
		return response;
		
	}

	

}
