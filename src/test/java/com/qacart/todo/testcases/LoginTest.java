package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
 import com.qacart.todo.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Authentications")

public class LoginTest extends BaseTest {

    LoginPage loginobj ;

    @Story("user login")
    @Description("It will login using valid email and valid pass with min 8 chars")
    @Test(description = "User Should Be Able To Login Using Valid Credentials")
    public  void  shouldBeAbleToLoginWithEmailAndPassword()
    {
       loginobj = new LoginPage(getDriver()) ;

       loginobj.enterValidLoginCredentials("b@g.com","0100100100");

         Assert.assertTrue(loginobj.logoutIsDisplayedAssertion());



    }
}
