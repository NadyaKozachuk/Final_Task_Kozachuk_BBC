package com.cucumber.junit.hooks;

import com.cucumber.junit.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHook {
    @Before
    public void setupDriver() {
        DriverManager.getDriver(DriverManager.Browser.CHROME);
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
