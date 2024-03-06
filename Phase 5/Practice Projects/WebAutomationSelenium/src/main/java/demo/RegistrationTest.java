package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("web.chrome.driver",
				"C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("C:\\Users\\abhis\\Desktop\\Phase5 Learning\\Automate_Web_App\\registration.html");
		System.out.println("Registration page opened.");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys("admin");
		System.out.println("username filled.");
		Thread.sleep(3000);

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("testuser@example.com");
		System.out.println("email filled.");
		Thread.sleep(3000);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("password");
		System.out.println("password filled.");
		Thread.sleep(3000);

		WebElement confirmPasswordField = driver.findElement(By.name("confirmPassword"));
		confirmPasswordField.sendKeys("password");
		System.out.println("confirm password filled.");
		Thread.sleep(3000);

		WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
		registerButton.click();
		System.out.println("Registration button clicked");
		Thread.sleep(3000);

		driver.quit();
	}

}
