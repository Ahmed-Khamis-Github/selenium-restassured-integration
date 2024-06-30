package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utilities.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private Cookies restAssuredCookies ;
    private String accessToken ;

    public Cookies getRestAssuredCookies() {
        return restAssuredCookies;
    }
    public List<Cookie> getCookiesAsList() {
        return restAssuredCookies.asList();
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
                        .post(EndPoint.API_REGISTER_ENDPOINT)
                        .then()
                        .extract()
                        .response() ;

        restAssuredCookies = res.getDetailedCookies() ;
        accessToken = res.path("access_token") ;

     }




}
