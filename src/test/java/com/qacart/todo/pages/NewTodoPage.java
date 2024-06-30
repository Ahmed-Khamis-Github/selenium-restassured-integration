package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewTodoPage extends BasePage {

    private final By todoTxt = By.cssSelector("[data-testid='new-todo']");
    private final By submitBtn = By.cssSelector("[data-testid='submit-newTask']");


    public NewTodoPage(WebDriver driver) {
        super(driver);
    }


    @Step

    public TodoPage addNewTodo(String todoTask) {

        driver.findElement(todoTxt).sendKeys(todoTask);
        driver.findElement(submitBtn).click();
        return new TodoPage(driver) ;
    }
}
