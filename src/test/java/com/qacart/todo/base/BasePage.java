package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected  WebDriver driver ;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
