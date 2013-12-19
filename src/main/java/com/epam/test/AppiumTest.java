package com.epam.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yauheni_Patotski.
 * Date: 18.12.13
 * Time: 22:42
 * e-mail: hathi.blr@gmail.com
 * Skype: hathi.blr
 */
public class AppiumTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //For Android
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("app", "chrome");
        //For iOs
//        capabilities.setCapability("device", "iPhone Simulator");
//        capabilities.setCapability("app", "safari");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test(description = "Positive Test", priority = 1)
    public void simpleTestPositive() throws Exception {
        driver.get("http://tut.by");
        WebElement search = driver.findElement(By.xpath("//input[@name='str']"));
        search.sendKeys("EPAM");
        WebElement searchBtn = driver.findElement(By.xpath("//button[@name='search']"));
        searchBtn.click();
        Assert.assertTrue(driver.findElements(By.partialLinkText("epam.by")).size()>0,"Link doesn't present");
    }

    @Test(description = "Negativetest",  priority = 2)
    public void simpleTestNegative() throws Exception {
        driver.get("http://tut.by");
        WebElement search = driver.findElement(By.xpath("//input[@name='str']"));
        search.sendKeys("EPAM");
        WebElement searchBtn = driver.findElement(By.xpath("//button[@name='search']"));
        searchBtn.click();
        Assert.assertTrue(driver.findElements(By.partialLinkText("dte.by")).size()>0,"Link doesn't present");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
