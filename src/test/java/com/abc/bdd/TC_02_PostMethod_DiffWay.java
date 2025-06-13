package com.abc.bdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
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
	
		void testPostUsingPOJO() {
			
			Pojo_PostReq data = new Pojo_PostReq();//create obj of our pojo class
			data.setName("Chumki");
			data.setName("India");
			data.setPhone("895214752");
			
			String courseArr [] = {"java", "C"};
			data.setCourses(courseArr);
			
			RestAssured
					.given()
					.contentType("Application/json")
					.body(data) //converting json obj to tostring , 
											//because if data in the string formnat it will be covert into json format
					.when()
					.post("http://localhost:3000/students")
					.then()
					.statusCode(201)
					.header("contentType", "Application/json; charset=uft-8")
					//.body("Name",equalTo("Siliguri"));//for verify
					.log().all();
		}
	
		//USING EXTARNAL JSON FILE
		void testPostUsingExtarnalJsonFile() throws FileNotFoundException {
			
			File f=new File(".\\body.json");
			FileReader fr=new FileReader(f); //OENING THE FILE
			
			JSONTokener jt =new JSONTokener(fr);//use to extract the data in json format
			JSONObject data = new JSONObject(jt);
			
			
			RestAssured
					.given()
					.contentType("Application/json")
					.body(data) //converting json obj to tostring , 
											//because if data in the string formnat it will be covert into json format
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
	
}