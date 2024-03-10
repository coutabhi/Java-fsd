import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateScreenShots {

	public static void main(String[] args) throws InterruptedException, IOException {
		//register the chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
		//create an obj to the driver -obj to the browser
		WebDriver driver=new ChromeDriver();//driver is the controller obj to web browser
		//maxmize the screen
		driver.manage().window().maximize();
		//web url 
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	//no of pixels
	//js.executeScript("window.scrollBy(0,1000)");
		
		
	   
		WebElement we=driver.findElement(By.linkText("Help"));
		js.executeScript("arguments[0].scrollIntoView();",we);
		if(we!=null) {
			takeScreenshot(driver,"amazon");
		}
		we.click();
		
	//scroll down to the last
	//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public static void takeScreenshot(WebDriver driver,String fileName) throws IOException {
		//take the screenshot and store it as a file format
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screen shot to the specified location 
		FileUtils.copyFile(file,new File("B:\\"+fileName+".png"));
	}
	
	
}
