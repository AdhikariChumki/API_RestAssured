package com.abc.nonbdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class ReqSpec2 {
	
	RequestSpecification requestSpec;
	File jsonFile = new File("src\\test\\resources\\InputFiles\\jsonInput.json");
	
	@BeforeMethod
	public void reqSpec() {
		 requestSpec = RestAssured.given()
				//baseurl header baspth body
						.baseUri("https://reqres.in")
						.basePath("/api/users")
						.contentType(ContentType.JSON)
						.log()
						.all();
	}
	
	
	public static JSONObject getJSONObject() throws FileNotFoundException, ParseException   {
		File file = new File("src\\test\\resources\\InputFiles\\jsonInput.json");
		FileReader reader = new FileReader(file);
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}

	
	@Test(priority = 1)
	public void post() throws FileNotFoundException, ParseException {
		
		JSONObject pyload = getJSONObject();
		pyload.replace("name", "abcxzy");
		JSONArray skills = (JSONArray) pyload.get("skills");
		skills.remove(0);
				
		RestAssured
				.given()
				.spec(requestSpec)
				.body(pyload)
				.when()
				.post()
				.then()
				.log().all().extract()
				.asString();
	}
	
	@Test(priority = 2)
	public void get() {
		 RestAssured
				.given()
				.spec(requestSpec)
				.when()
				.get()
				.then()
				.log().all().extract()
				.asString();
	}

}
