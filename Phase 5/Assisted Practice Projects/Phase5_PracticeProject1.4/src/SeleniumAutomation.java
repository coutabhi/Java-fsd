import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelAuto {
public static void main(String[] args) throws InterruptedException {
	//register the chrome driver
	System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
	//create an obj to the driver -obj to the browser
	WebDriver driver=new ChromeDriver();//driver is the controller obj to web browser
	//maxmize the screen
	driver.manage().window().maximize();
	//web url 
	driver.manage().timeouts().pageLoadTimeout(2000,TimeUnit.MILLISECONDS);
	driver.get("http://127.0.0.1:5501/register.html");
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.NANOSECONDS);
	WebElement we1=driver.findElement(By.name("id"));
	WebElement we2=driver.findElement(By.name("op"));
	explicit(driver,we1,200,"1");
	explicitSelect(driver,we2,300);
}


public static void explicit(WebDriver driver,WebElement we,int timeout,String value) {
	new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(we));
	we.sendKeys(value);
}

public static void explicitSelect(WebDriver driver, WebElement we, int timeout) {
	new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(we));
	Select sc=new Select(we);
	sc.selectByVisibleText("JAVA");
}


}
