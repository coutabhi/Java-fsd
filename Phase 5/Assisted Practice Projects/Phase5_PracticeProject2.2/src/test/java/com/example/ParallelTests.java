package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTests {

    WebDriver driver;
    @Test(groups="Edge")
    public void LaunchChrome() {
		 WebDriverManager.edgedriver().setup();	  
		//  System.setProperty("webdriver.chrome.driver","F:\\seleniumjars\\chromedriver.exe");
		  WebDriver wd=new EdgeDriver();
        wd.get("https://www.facebook.com");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(groups="Edge", dependsOnMethods="LaunchChrome")
    public void TryFacebook1() {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.id("email")).sendKeys("ravi10thstudent@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.id("loginbutton")).click();
    }
    
    @Test(groups="Firefox")
    public void LaunchFirefox() {
		 WebDriverManager.edgedriver().setup();	  
		//  System.setProperty("webdriver.chrome.driver","F:\\seleniumjars\\chromedriver.exe");
		  WebDriver wd=new EdgeDriver();
        wd.get("https://www.facebook.com");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Test(groups="Firefox", dependsOnMethods="LaunchFirefox")
    public void TryFacebook2() {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.id("email")).sendKeys("ravi10thstudent@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("ravi28394");
        driver.findElement(By.id("loginbutton")).click();
        System.out.println(Thread.currentThread().getId());
    }

}