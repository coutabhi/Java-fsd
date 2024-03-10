import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

	public static void main(String[] args) throws InterruptedException, IOException {
		//register the chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
		//create an obj to the driver -obj to the browser
		WebDriver wd=new ChromeDriver();//wd is the controller obj to web browser
		//maxmize the screen
		wd.manage().window().maximize();
	             wd.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		//web url 
		wd.get("https://www.ilovepdf.com/pdf_to_word");
		wd.findElement(By.id("pickfiles")).click();
		Runtime.getRuntime().exec("B:\\Phase 5 - Selenium\\fileupload.exe");
		//processTask
		wd.findElement(By.xpath("//*[@id=\'processTask\']")).click();
	}
	
	}