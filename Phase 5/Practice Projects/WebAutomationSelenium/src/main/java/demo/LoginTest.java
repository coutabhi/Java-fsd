package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\abhis\\Desktop\\Phase5 Learning\\Automate_Web_App\\login.html");
		System.out.println("Login page opened.");
		driver.manage().window().maximize();
		
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys("iabhi_yadav");
		Thread.sleep(3000);
		System.out.println("username filled.");
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("password");
		Thread.sleep(3000);
		System.out.println("password filled.");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		Thread.sleep(3000);
		System.out.println("login button clicked filled.");
		
		driver.quit();
	}

}
