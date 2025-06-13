package com.abc.bdd;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_GetMethod {

	public static void main(String[] args) {
		//URL 
		//RequestSpec
		//Response
		
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.when()
				.get("/api/users?page=2")
				.prettyPeek();
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}

}
