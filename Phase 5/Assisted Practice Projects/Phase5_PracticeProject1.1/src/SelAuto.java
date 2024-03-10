import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelAuto {
	public static void main(String[] args) throws Exception {
	//register the Chrome driver
	System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.get("https://www.amazon.com/");
	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("ap_email")).sendKeys("abhi@gmail.com");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("ap_password")).sendKeys("password");
	driver.findElement(By.id("signInSubmit")).click();

	
	Thread.sleep(2000);

	driver.quit();

}


}
