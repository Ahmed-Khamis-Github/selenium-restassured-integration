package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setupDriver()
    {
        driver = new DriverFactory().initializeDriver() ;
    }


    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
