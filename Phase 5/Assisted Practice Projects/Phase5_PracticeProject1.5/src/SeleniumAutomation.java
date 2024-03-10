import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelAuto {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhis\\Desktop\\Phase5 Learning\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Handling Alerts
        driver.get("http://127.0.0.1:5500/index.html"); // Replace with the website URL you want to test

        // Click on a button that triggers an alert
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        // Switch to the alert and click on the 'OK' button
        driver.switchTo().alert().accept();

        Thread.sleep(2000); // Delay for 2 seconds

        // Handling Confirm Pop-ups
        driver.get("http://127.0.0.1:5500/index.html"); // Replace with the website URL you want to test

        // Click on a button that triggers a confirm pop-up
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        // Switch to the alert and click on the 'Cancel' button
        driver.switchTo().alert().dismiss();

        Thread.sleep(2000); // Delay for 2 seconds

        // Click on the confirm button again to re-trigger the confirm pop-up
        confirmButton.click();

        // Switch to the alert and click on the 'OK' button
        driver.switchTo().alert().accept();

        Thread.sleep(2000); // Delay for 2 seconds

        // Handling Prompt Pop-ups
        driver.get("http://127.0.0.1:5500/index.html"); // Replace with the website URL you want to test

        // Click on a button that triggers a prompt pop-up
        WebElement promptButton = driver.findElement(By.id("promptButton"));
        promptButton.click();

        // Switch to the alert, enter some text, and click on the 'OK' button
        driver.switchTo().alert().sendKeys("Hello, Selenium!");
        driver.switchTo().alert().accept();

        Thread.sleep(2000); // Delay for 2 seconds

        // Handling New Tabs and Windows
        driver.get("http://127.0.0.1:5500/index.html"); // Replace with the website URL you want to test

        // Open a new tab
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

        Thread.sleep(2000); // Delay for 2 seconds

        // Switch to the new tab and navigate to a different URL (e.g., "about:blank")
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.get("about:blank");

        Thread.sleep(2000); // Delay for 2 seconds

        // Open a new window
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");

        Thread.sleep(2000); // Delay for 2 seconds

        // Switch to the new window and navigate to a different URL (e.g., "about:blank")
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        driver.get("about:blank");

        Thread.sleep(2000); // Delay for 2 seconds

        // Close the current window (optional)
        driver.close();

        // Switch back to the original tab or window
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        Thread.sleep(2000); // Delay for 2 seconds

        // Close the browser
        driver.quit();
    }
}
