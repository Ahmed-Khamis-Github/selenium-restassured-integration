package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;

import com.qacart.todo.utilities.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("ToDo")

public class AddTodoTest extends BaseTest {
    LoginPage loginObj;
    TodoPage todoObj;

    NewTodoPage newTodoObj;

    @Story("add todo")
    @Description("user will add the task by clicking the add button")

    @Test(description = "User Should Be Able To add new task")
    public void shouldBeAblToAddNewTodo() {


        todoObj = new TodoPage(getDriver());

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        todoObj.load();
        injectCookiesToBrowser(registerApi.getCookiesAsList());

        String actual =
                todoObj.load()

                        .clickAddNewTodo()
                        .addNewTodo("selenium")
                        .itemDisplayedTxtAssertion();


        Assert.assertEquals(actual, "selenium");


    }


    @Story("delete todo")
    @Description("user will delete the task by clicking the delete button")

    @Test(description = "User Should Be Able To Delete task")
    public void shouldBeAbleToDeleteTodo() {

        todoObj = new TodoPage(getDriver());

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        todoObj.load();

        injectCookiesToBrowser(registerApi.getCookiesAsList());

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());

        boolean noItemDisplayed = todoObj.load()


                .deleteTodoItem()
                .noItemDisplayedTxtAssertion();

        Assert.assertTrue(noItemDisplayed);

    }
}
