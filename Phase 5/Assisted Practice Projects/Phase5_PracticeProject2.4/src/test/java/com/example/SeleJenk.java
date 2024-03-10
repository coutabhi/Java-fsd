package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleJenk {
	public class NewTest {
		
		 WebDriver wd=null;
	  @Test
	  public void test1() {
		  SoftAssert as=new SoftAssert();
		  wd.get("https://www.google.com/");
		  	String title=wd.getTitle();
		  	String url=wd.getCurrentUrl();
		  	as.assertEquals("Googl",title);
		  	as.assertEquals("https://www.google.com/", url);
		  	System.out.println("after google");
		  	as.assertAll(); //provide all the assert failures at the last
	  }
	  
	  @Test
	  public void test2() {
		  System.out.println("in test2");
			  wd.get("https://www.amazon.in/");
			  

	  }
	  
      SoftAssert soft=new SoftAssert();
      @Test               
      public void testEasy() {    

          wd.get("https://www.facebook.com");  
          String title = wd.getTitle();                
          soft.assertEquals("FB Login",title);        
      }   

	  
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("in beforetest");
		    WebDriverManager.edgedriver().setup();    
		    wd = new EdgeDriver();
		  wd.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("in aftertest");
		  wd.close();
	  }

	}
}