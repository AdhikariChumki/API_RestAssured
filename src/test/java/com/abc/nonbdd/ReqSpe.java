package com.abc.nonbdd;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqSpe {

	public static void main(String[] args) {
		
		RequestSpecification requestSpec = RestAssured.given()
		//baseurl header baspth body
				.baseUri("https://reqres.in")
				.basePath("/api/users")
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"chumki\",\r\n"
						+ "    \"job\": \"qa\"\r\n"
						+ "}")
				.log()
				.all();
		

		String resposne = RestAssured
				.given()
				.spec(requestSpec)
				.when()
				.post()
				.then()
				.log().all().extract()
				.asString()
				//.body()
				
				//.statusCode(201)
				//.time(Matchers.lessThan(6000L))
				;  //how much it taken get the response
		
		System.out.println(resposne);

	}

}
