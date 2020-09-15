package com.example.demoProject;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class DemoProjectApplicationTests {

    @Test
    public void addingNewLocationWithValidBody() {
        // validate if Add Place API is working as expected

        //given - all input details
        //when - Submit the API -resource,http method
        //then - validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"location\": {\n" +
                        "        \"latitude\": \"-38.383494\",\n" +
                        "        \"longitude\": \"33.427362\"\n" +
                        "    },\n" +
                        "    \"accuracy\": \"50\",\n" +
                        "    \"name\": \"Frontline house\",\n" +
                        "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "    \"address\": \"70 Summer Walk, USA\",\n" +
                        "    \"types\": \"shoe park,shop\",\n" +
                        "    \"website\": \"http://google.com\",\n" +
                        "    \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200);
    }
}
