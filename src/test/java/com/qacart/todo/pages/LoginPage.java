package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By emailTxt = By.id("email") ;
    private final By passwordTxt = By.id("password") ;

    private final By submitBtn = By.id("submit") ;

    private final By logoutBtn = By.xpath("//button[.//span[text()='Logout']]") ;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step

    public TodoPage enterValidLoginCredentials(String email , String password)
    {
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(submitBtn).click();
        return new TodoPage(driver) ;



    }
    @Step

    public boolean logoutIsDisplayedAssertion()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[.//span[text()='Logout']]")
        ));

        return    driver.findElement(logoutBtn).isDisplayed();
    }

}
