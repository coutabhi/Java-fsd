import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelAuto {
    public static void main(String[] args) throws InterruptedException {
        // Register the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");
        // Create an object to the driver - obj to the browser
        WebDriver driver = new ChromeDriver(); // driver is the controller object to the web browser
        // Maximize the screen
        driver.manage().window().maximize();

        // Navigate to the desired website
        driver.get("http://127.0.0.1:5501/register.html"); // Replace "https://www.example.com" with the website you want to test

        // Step 1.3.1: To find the element present on the page using CSS Selector
        // Using CSS Selectors in Selenium to find elements based on their attributes
        // Tag and ID
        WebElement elementByCssSelectorTagAndId = driver.findElement(By.cssSelector("input#studentID"));
        // Use the 'elementByCssSelectorTagAndId' as required

        // Tag and Class
        WebElement elementByCssSelectorTagAndClass = driver.findElement(By.cssSelector("input.form-control"));
        // Use the 'elementByCssSelectorTagAndClass' as required

        // Tag and Attribute
        WebElement elementByCssSelectorTagAndAttribute = driver.findElement(By.cssSelector("input[name='id']"));
        // Use the 'elementByCssSelectorTagAndAttribute' as required

        // ... Continue with other elements as needed ...

        // Run the form validation JavaScript function
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Call the form validation function by passing the 'event' object
        js.executeScript("validateForm(event);");

        // Wait for a short period of time to allow JavaScript to execute
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}
