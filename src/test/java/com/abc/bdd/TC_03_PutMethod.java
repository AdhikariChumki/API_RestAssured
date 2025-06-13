package com.abc.bdd;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03_PutMethod {

	public static void main(String[] args) {
		//URL 
		//RequestSpec
		//Response
		
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.header("Content-Type", "application/json")
				.when()
				.body("{\r\n"
						+ "    \"name\": \"chumki\",\r\n"
						+ "    \"job\": \"qa\"\r\n"
						+ "}")
				.put("/api/users/2")
				.prettyPeek();
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}

}
