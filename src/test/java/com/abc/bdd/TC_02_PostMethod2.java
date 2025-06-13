package com.abc.bdd;

import java.io.File;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_PostMethod2 {

	public static void main(String[] args) {
		//URL 
		//RequestSpec
		//Response
		
			File jsonFile = new File("src\\test\\resources\\InputFiles\\jsonInput.json");	
		
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.header("Content-Type", "application/json")
				.when()
				.body(jsonFile)
				.post("/api/users")
				.prettyPeek();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
	
}
