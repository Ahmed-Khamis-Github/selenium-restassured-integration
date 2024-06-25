package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
 import com.qacart.todo.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginobj ;
    @Test
    public  void  shouldBeAbleToLoginWithEmailAndPassword()
    {
       loginobj = new LoginPage(driver) ;

       loginobj.enterValidLoginCredentials("b@g.com","0100100100");

         Assert.assertTrue(loginobj.logoutIsDisplayedAssertion());



    }
}
