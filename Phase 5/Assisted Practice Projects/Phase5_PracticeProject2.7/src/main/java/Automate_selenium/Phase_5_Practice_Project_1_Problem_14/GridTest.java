package Automate_selenium.Phase_5_Practice_Project_1_Problem_14;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GridTest {
    public static void main(String[] args) {
        try {
            // Define the hub URL and desired capabilities
            URL hubUrl = new URL("http://localhost:4444/wd/hub");
            DesiredCapabilities capabilities = DesiredCapabilities.edge(); // You can use other browsers as well

            // Create a RemoteWebDriver instance
            WebDriver driver = new RemoteWebDriver(hubUrl, capabilities);

            // Navigate to a web page (e.g., Google)
            driver.get("https://www.google.com");

            // Perform your tests here...

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
