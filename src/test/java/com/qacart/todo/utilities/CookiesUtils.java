package com.qacart.todo.utilities;

import org.openqa.selenium.Cookie;
import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {


    public static List<Cookie> convertRestAssuredCookiesToSeleniumCookies(List<io.restassured.http.Cookie> restAssuredCookies) {
        List<Cookie> seleniumCookies = new ArrayList<>();

         for (io.restassured.http.Cookie restAssuredCookie : restAssuredCookies) {
            Cookie seleniumCookie = new Cookie(restAssuredCookie.getName(), restAssuredCookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }

        return seleniumCookies;
    }
}
