import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelAuto {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
 
    	driver.get("https://www.amazon.in/");
    	driver.findElement(By.linkText("Start here.")).click();
    	driver.findElement(By.id("ap_customer_name")).sendKeys("abhishek");
    	driver.findElement(By.id("ap_phone_number")).sendKeys("8985948876");
    	driver.findElement(By.id("ap_email")).sendKeys("abhi@gmail.com");
    	driver.findElement(By.id("ap_password")).sendKeys("123456789");//continue
    	driver.findElement(By.id("continue")).click();

    	Thread.sleep(20000);

    	driver.close();

	}

}