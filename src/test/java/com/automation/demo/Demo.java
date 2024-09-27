package com.automation.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {

    RequestSpecification requestSpecification=RestAssured.given();
    Response response;
    String endPoint;

    public Response test(){
        requestSpecification=requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification=requestSpecification.log().all();
        response=requestSpecification.get("/booking");
        response.then().log().all();
        return response;
    }
    public void response(){
        response.getStatusCode();
    }







    public static void main(String[] args) {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .log().all().when().get("/booking")
                .then().log().all().assertThat().statusCode(200);
    }
}
