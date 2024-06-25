package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TodoPage extends BasePage {

    private final By addTaskBtn = By.cssSelector("[data-testid='add']");
    private final By itemDisplayed = By.cssSelector("[data-testid='todo-text']");
    private final By deleteItemBtn = By.cssSelector("[data-testid='delete']");
    private final By noItemDisplayedMsg = By.cssSelector("[data-testid='no-todos']");

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    public NewTodoPage clickAddNewTodo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addTaskBtn)).click();

        return new NewTodoPage(driver) ;

    }

    public TodoPage deleteTodoItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteItemBtn)).click();
        return this ;
    }

    public String itemDisplayedTxtAssertion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemDisplayed));
        return driver.findElement(itemDisplayed).getText();
    }

    public boolean noItemDisplayedTxtAssertion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noItemDisplayedMsg)).isDisplayed();
    }
}
