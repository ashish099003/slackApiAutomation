package channeltests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.slack.apirequest.RequestTemplate;
import com.slack.apirequest.Validate;

import net.minidev.json.JSONObject;

public class RenameChannelTest {
	

	@Test
	public void EditChannelName() {
		 Gson gsonObj = new Gson();
		String token = "xoxp-739215973174-725582839410-736567319012-4e2ac79ed5e71bd0882d00b3177f6d31";
		String apiName= "Join-Channel" ;
		String RequestType = "POST";
		String uri = "https://slack.com/api/channels.rename";
		HashMap<String, String> headers = new HashMap<String,String>();
		HashMap<String, String> params = new HashMap<String,String>();
		headers.put("Authorization", "Bearer "+token);
	//	headers.put("token","Ashish");
		headers.put("Content-Type","application/json");
		params.put("channel", "CMR7VSCS2");	
		params.put("name", "newName");
		RequestTemplate reqTemp = new RequestTemplate(apiName, uri,RequestType,headers,params);
		
		String jsonStr1 = gsonObj.toJson(params);
		System.out.print(jsonStr1);
		Response  response= RestAssured
				.given()
				.headers(new JSONObject(headers))
				.body(jsonStr1)

				.when()
				.post(uri)
				.then()
				.extract()
				.response();
		
		Validate val= new Validate();
		Validate.setResponse(response);
		Validate.validateResponseCode(200);
		System.out.print(response.getBody().asString());

}
}
