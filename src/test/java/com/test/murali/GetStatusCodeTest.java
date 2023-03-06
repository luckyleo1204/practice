package com.test.murali;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class GetStatusCodeTest {

    public static String token="";
    @BeforeClass
    public void setBaseUrl() {
        String uname= UUID.randomUUID().toString();
        RestAssured.baseURI = "https://simple-books-api.glitch.me/";
//        String input="{\n" +
//                "   \"clientName\": \"Postman121\",\n" +
//                "   \"clientEmail\": \""+ uname +"\"@gmail.com\"\n" +
//                "}";
//        RequestSpecification r = RestAssured.given()
//                .header("Accept", "*/*")
//                .header("Content-Type", "application/json")
//                .header("Connection", "keep-alive");
//        Response  response= r.body(input).post("api-clients");
//           token=response.getBody().jsonPath().get("accessToken");
    }

    @Test
    public void testStatusCode() {
        Response res = given()
                .get("Books?type=fiction&limit=3");

        Assert.assertEquals(res.statusCode(), 200);

        given()
                .get("Books?type=fiction&limit=3")
                .then().log().all();

    }

    @Test
    public void testStatusCodeRestAssured() {

        given()
                .get("Books?type=fiction&limit=3")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void testBookStatus() {
        given()
                .get("status")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getSingleBook() {
        Response res = given()
                .get("Books?type=fiction&limit=3");
        System.out.println(res.asString());

        int bookId = res.body().jsonPath().get("[0].id");
        given().get("books/" + bookId)
                .then()
                .log().all();
    }

    @Test
    public void postOrderBook() {
        String input = "{\"bookId\": 1,"
                 +"\"customerName\": \"Murali\"}";
        RequestSpecification r = RestAssured.given()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Authorization",getAuth());
        r.body(input).post("/orders").then().log().all();

        //By JsonValue
        Object obj= JSONValue.parse(input);
        JSONObject jsonObject = (JSONObject) obj;

        RequestSpecification r1 = RestAssured.given()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Authorization",getAuth());
        r1.body(jsonObject).post("/orders").then().log().all();

        //By JsonObject
        JSONObject object=new JSONObject();
        object.put("bookId",getRandomNumber());
        object.put("customerName",getRandomName());
        RequestSpecification r2 = RestAssured.given()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Authorization",getAuth());
        r2.body(object).post("/orders").then().log().all();

        //using Map's:
        Map map=new HashMap();
        map.put("bookId",getRandomNumber());
        map.put("customerName",getRandomName());
        //JSONObject jsonObject = JSONObject.toJSONString(map);

        RequestSpecification r3 = RestAssured.given()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Authorization",getAuth());
        r3.body(jsonObject).post("/orders").then().log().all();

    }

    public static String getAuth(){
        String uname= UUID.randomUUID().toString();
        RestAssured.baseURI = "https://simple-books-api.glitch.me/";
        String input="{\n" +
                "   \"clientName\": \"Postman121\",\n" +
                "   \"clientEmail\": \""+uname+"@gmail.com\"\n" +
                "}";
        RequestSpecification r = RestAssured.given()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive");
        Response rs= r.body(input).post("api-clients");
        return rs.body().jsonPath().get("accessToken");
    }

    public static String getRandomName(){
        return UUID.randomUUID().toString();
    }

    public static String getRandomNumber(){
        Random r=new Random();
       return String.valueOf( r.nextInt(1,5));
    }
}