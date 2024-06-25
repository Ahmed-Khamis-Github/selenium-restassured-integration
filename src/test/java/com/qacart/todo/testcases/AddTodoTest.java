package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;

import com.qacart.todo.utilities.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddTodoTest extends BaseTest {
    LoginPage loginObj;
    TodoPage todoObj;

    NewTodoPage newTodoObj;


    @Test
    public void shouldBeAblToAddNewTodo() {

        loginObj = new LoginPage(driver);


        String actual=
                loginObj
                  .enterValidLoginCredentials(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                  .clickAddNewTodo()
                  .addNewTodo("selenium")
                        .itemDisplayedTxtAssertion();


         Assert.assertEquals(actual, "selenium");



    }


    @Test
    public void shouldBeAbleToDeleteTodo() {

        loginObj = new LoginPage(driver);

      boolean noItemDisplayed =  loginObj
                .enterValidLoginCredentials("b@g.com", "0100100100")
                .deleteTodoItem()
              .noItemDisplayedTxtAssertion();

        Assert.assertTrue(noItemDisplayed);

    }
}
