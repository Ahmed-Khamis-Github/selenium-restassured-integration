package com.qacart.todo.factory;

import com.qacart.todo.utilities.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver;
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.get( ConfigUtils.getInstance().getBaseUrl() );
        return driver;
    }
}
