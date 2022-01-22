package Postman;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    Gson gson = new Gson();
    final String BASE_URL = "https://api.qase.io/v1/";
    final String AUTH_TOKEN = "4f7faca87e882d98cce5f4234195ac3c24f22d51";

    public String get(String uri, int expectedCode) {
        return
                given().
                        header("Token", AUTH_TOKEN).
                        header("content-type", "application/json").
                        when().
                        get(BASE_URL + uri).
                        then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }

    public String post(String uri, String requestBody, int expectedCode) {
        return
                given().
                        header("Token", AUTH_TOKEN).
                        header("content-type", "application/json").
                        body(requestBody).
                        when().
                        log().all().
                        post(BASE_URL + uri).
                        then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }


}


