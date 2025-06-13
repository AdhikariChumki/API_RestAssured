package com.abc.nonbdd;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_GetMethod {

	public static void main(String[] args) {
		//URL 
		//RequestSpec
		//Response
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.request(Method.GET,"/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}

}
