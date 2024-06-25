package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import com.qacart.todo.utilities.UserUtils;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private Cookies restAssuredCookies ;
    private String accessToken ;

    public Cookies getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public  void  register()
    {
        User user = new UserUtils().generateRandomUsers() ;
        Response res =
                given()
                        .baseUri("https://todo.qacart.com/")
                        .contentType("application/json")
                        .body(user)
                        .when()
                        .post("api/v1/users/register")
                        .then()
                        .extract()
                        .response() ;

        restAssuredCookies = res.getDetailedCookies() ;
        accessToken = res.path("access_token") ;

     }



}
