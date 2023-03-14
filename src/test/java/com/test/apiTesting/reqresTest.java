package com.test.apiTesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class reqresTest {
    @BeforeClass
    public void setBaseUrl() {
        String uname= UUID.randomUUID().toString();
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void getCall(){
        Response res=
                given()
                . when()
                . get("api/users?page=2");

        ArrayList<Map<String, Object>> list=res.body().jsonPath().get("data");

        list.stream().forEach(mapData->{
            mapData.entrySet().stream().forEach(mdata->{
                if(mapData.get("first_name").equals("Byron"))
                System.out.println(mdata.getKey()+":"+mdata.getValue());
            });
        });

    }

    @Test
    public void getUser(){
        Response res=
                given()
                        . when()
                        . get("/api/users/2");

        Assert.assertEquals(res.body().jsonPath().get("data.first_name"),"Janet");

        Response res1=
                given()
                        . when()
                        . get("/api/users/235");
        Assert.assertEquals(res.statusCode(),404);
    }

    @Test
    public void postUsers(){
        String body="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response res=
                given()
                        . when()
                        .body(body)
                        . post("api/users");
        Assert.assertEquals(res.statusCode(),201);


        //approach 2:
        JSONObject object=new JSONObject();
        object.put("name","Murali");
        object.put("job","leader");
        Response res1=
                given()
                        . when()
                        .body(body)
                        . post("api/users");
        Assert.assertEquals(res1.statusCode(),201);

        //approach 3:
        Map<String, Object> map=new HashMap();
        map.put("name","Murali");
        map.put("job","leader");
       // JSONObject jsonObject =new JSONObject().put("name","Murali");
    }


}


