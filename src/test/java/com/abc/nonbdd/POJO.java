package com.abc.nonbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POJO {

	public static void main(String[] args) {
		
		Map<String, Object> jsonBody = new HashMap<String, Object>();
		jsonBody.put("name", "Chumki");
		jsonBody.put("mobile", "1292892");
		
		Map<String,Object> childJson = new HashMap<String, Object>();
		childJson.put("city", "pune");
		childJson.put("street", "sample st");

				
		List<String> skills = new ArrayList<String>();
		skills.add("API");
		skills.add("Selenium");
		skills.add("java");
		
		jsonBody.put("address", childJson);
		
		jsonBody.put("skills", skills);
		
		System.out.println(jsonBody);
		
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.header("Content-Type", "application/json")
				.when()
				.body(jsonBody)
				.post("/api/users")
				.prettyPeek();
		
		JsonPath abc = new JsonPath(response.asString());
		System.out.println(response.getStatusCode());  //201
		System.out.println("This is name = " + abc.getString("name"));  //directly parent
		System.out.println("This is city = " + abc.getJsonObject("address"));  //josn child object
		System.out.println("This is city = " + abc.getJsonObject("address.city"));
		System.out.println("This is Skills = " +abc.getJsonObject("skills"));
		System.out.println("This is Skills = " +abc.getJsonObject("skills[1]"));
		

	}

	//jackson or gson
}
