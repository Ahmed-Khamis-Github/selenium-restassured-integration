package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utilities.CookiesUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);

    }

    public WebDriver getDriver()
    {
        return this.driver.get() ;
    }


    @BeforeMethod
    public void setupDriver()
    {

      WebDriver  driver = new DriverFactory().initializeDriver() ;
      setDriver(driver);
    }


    @AfterMethod
    public void closeDriver(ITestResult result) throws IOException {
        String testCaseName =result.getMethod().getMethodName() ;
        File destFile = new File("targets"+File.separator+"screenshots"+File.separator+testCaseName+".png");
        takeScreenShot(destFile);
        getDriver().quit();
    }

    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies)
    {
        List<org.openqa.selenium.Cookie> seleniumCookies = CookiesUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies) ;
        for (org.openqa.selenium.Cookie cookie : seleniumCookies)
        {
            getDriver().manage().addCookie(cookie);
        }
    }

    public void takeScreenShot(File destFile) throws IOException {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(file,destFile);
        InputStream is = new FileInputStream(destFile) ;
        Allure.addAttachment("Screenshot",is);


    }
}
