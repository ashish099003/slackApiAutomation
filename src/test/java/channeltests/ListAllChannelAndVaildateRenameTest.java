package channeltests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.slack.apirequest.Validate;

import net.minidev.json.JSONObject;

public class ListAllChannelAndVaildateRenameTest {

	@Test
	public void ListAllChannel() {
		 Gson gsonObj = new Gson();
		String token = "xoxp-739215973174-725582839410-736567319012-4e2ac79ed5e71bd0882d00b3177f6d31";
		String apiName= "List-Channel" ;
		String RequestType = "GET";
		String uri = "https://slack.com/api/channels.list";
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("Authorization", "Bearer "+token);
		headers.put("Content-Type","application/json");		
	//	RequestTemplate reqTemp = new RequestTemplate(apiName, uri,RequestType,headers,params);
				
		Response  response= RestAssured
				.given()
				.headers(new JSONObject(headers))				
				.when()
				.get(uri)
				.then()
				.extract()
				.response();
		
		Validate val= new Validate();
		Validate.setResponse(response);
		Validate.validateResponseCode(200);
		

}
}
