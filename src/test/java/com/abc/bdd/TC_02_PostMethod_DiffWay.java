package com.abc.bdd;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_PostMethod_DiffWay {
		
	//USING HASHMAP	
	
		@Test(priority=1)
		void testPostusingHashMap() {
			
		HashMap data = new HashMap();
		
		data.put("Name", "Chumki");
		data.put("Location", "Siliguri");
		data.put("Phone", "91258742555");
		
		String coursearr [] = {"java", "python"};
		data.put("courses", coursearr);
		
	
		
		RestAssured
				.given()
				.contentType("Application/json")
				.body(data)
				.when()
				.post("http://localhost:3000/students")
				.then()
				.statusCode(201)
				.header("contentType", "Application/json; charset=uft-8")
				//.body("Name",equalTo("Siliguri"));//for verify
				.log().all();
	}

	//Delete student record
		@Test(priority=2)
	  void testDelete() {
		  
		  RestAssured.
		  given()
		  .when()
		  .delete("http://localhost:3000/students/4")
		  .then()
		  .statusCode(200); 
		  
	  }
		
		//USING JsON
		void testPostusingjSON() {
			
			JSONObject data = new JSONObject();
			
			data.put("Name", "Chumki");
			data.put("Location", "Siliguri");
			data.put("Phone", "91258742555");
		
			
			String coursearr [] = {"java", "python"};
			data.put("courses", coursearr);
			
			RestAssured
					.given()
					.contentType("Application/json")
					.body(data.toString()) //converting json obj to tostring , 
											//because if data in the string formnat it will be covert into json format
					.when()
					.post("http://localhost:3000/students")
					.then()
					.statusCode(201)
					.header("contentType", "Application/json; charset=uft-8")
					//.body("Name",equalTo("Siliguri"));//for verify
					.log().all();
		}

		//USING POJO CLASS
		
		//test
	
	
	
	
}