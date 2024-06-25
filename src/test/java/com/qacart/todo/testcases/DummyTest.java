package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import io.restassured.response.Response;
import com.qacart.todo.objects.User;

import static io.restassured.RestAssured.given;

public class DummyTest {
    public static void main(String[] args) {

        RegisterApi registerApi = new RegisterApi() ;
        registerApi.register();
        System.out.println(registerApi.getAccessToken());
        System.out.println(registerApi.getRestAssuredCookies());

    }
}
