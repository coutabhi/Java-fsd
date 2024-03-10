package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.stream.events.StartElement;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAutomation {
	private WebDriver driver;
	private Workbook workbook;
	private Sheet sheet;
	private int rowNumber;

	@BeforeTest
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testRegistration() throws InterruptedException, IOException {
		driver.get("http://127.0.0.1:5500/registration.html");

		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("Abhisheh Yadav");

		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("iabhiyadav");

		WebElement userEmailField = driver.findElement(By.id("email"));
		userEmailField.sendKeys("abhiyadav@example.com");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("password123");

		WebElement cnfPasswordField = driver.findElement(By.id("confirmPassword"));
		cnfPasswordField.sendKeys("password123");

		WebElement registerButton = driver.findElement(By.xpath("//button[text()='Click to Register']"));
		registerButton.click();

		Thread.sleep(1000);

		// takescreenshot
		takeScreenshot(driver, "Registration");

		// Wait for registration success message (you can add some delays here if
		// needed)
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerSuccess")));

		// Assert the success message content
		Assert.assertEquals(successMessage.getText(), "Registration successful.");

//        Thread.sleep(000);
	}

	@Test(priority = 2)
	public void testLoginSuccess() throws InterruptedException, IOException {
		driver.get("http://127.0.0.1:5500/login.html");

		// Login form elements
		WebElement emailFieldLogin = driver.findElement(By.id("username"));
		WebElement passwordFieldLogin = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Click to Login']"));

		// Enter valid login credentials
		emailFieldLogin.sendKeys("admin");
		passwordFieldLogin.sendKeys("password");

		// Click the login button
		loginButton.click();

		// takescreenshot
		takeScreenshot(driver, "LoginSuccess");
		Thread.sleep(1000);

		// Wait for the success message (you can add some delays here if needed)
		WebElement successMessage = driver.findElement(By.id("loginCnf"));
		Assert.assertEquals(successMessage.getText(), "This is the home page after login");
	}

	@Test(priority = 3)
	public void flipkartSearch() throws IOException, InterruptedException {
		driver.get("https://www.google.com");
		WebElement queryField = driver.findElement(By.name("q"));

		queryField.sendKeys("flipkart");
		queryField.submit();

		// Wait for the Flipkart link to appear and click on it
		driver.findElement(By.partialLinkText("Flipkart")).click();
		Thread.sleep(1000);

		// Search for "Macbook pro" on Flipkart
		driver.findElement(By.name("q")).sendKeys("Macbook pro");
		driver.findElement(By.name("q")).submit();

		takeScreenshot(driver, "FlipkartSearch");

		// Add some delay to observe the search result
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// addToCart
	@Test(priority = 4)
	public void addToCart() throws InterruptedException, IOException {
		driver.get("https://www.flipkart.com");

		// Search for "football" on Flipkart
		driver.findElement(By.name("q")).sendKeys("football");
		driver.findElement(By.name("q")).submit();

		// Wait for the search results to appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement footballCard = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@title, 'NIVIA Storm Football - Size: 5')]")));
		System.out.println("Football card found");
		footballCard.click();
//		Thread.sleep(10000);
//
//		WebElement starElement = driver.findElement(By.id("productRating_LSTBALDM4Q59MU5ZHNSOQHNLC_BALDM4Q59MU5ZHNS_"));
//		System.out.println("Star element found");
////		starElement.click();
//
//		WebElement addToCartButton = driver.findElement(By.xpath(
//				"//li[@class='col col-6-12']//button[text()='Add to cart' and @class='_2KpZ6l _2U9uOA _3v1-ww']"));
//
//		// Click the button
//		addToCartButton.click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
//
//		driver.findElement(By.xpath("//*[@id=\'sw-gtc\']/span/a")).click();
//
//		takeScreenshot(driver, "addToCart");

		// Add some delay to observe the search result
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// takescreenshots
	public static void takeScreenshot(WebDriver wd, String fileName) throws IOException {
		// take the screenshot and store it as a file format
		File file = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		// now copy the screen shot to the specified location
		FileUtils.copyFile(file, new File("C:\\Users\\abhis\\Desktop\\Projects\\" + fileName + ".png"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		// Capture test results and write to the Excel file
		String testName = result.getMethod().getMethodName();
		String status = result.isSuccess() ? "Passed" : "Failed";

		Row row = sheet.createRow(rowNumber++);
		row.createCell(0).setCellValue(testName);
		row.createCell(1).setCellValue(status);
	}

	@AfterTest
	public void tearDown() throws IOException {
		// Save the test results to an Excel file
		FileOutputStream fileOut = new FileOutputStream("TestResults.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		// Create an Excel workbook and sheet to store test results
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Test Results");
		rowNumber = 0;

		// Create the header row
		Row headerRow = sheet.createRow(rowNumber++);
		headerRow.createCell(0).setCellValue("Test Name");
		headerRow.createCell(1).setCellValue("Status");
	}

	@AfterSuite
	public void afterSuite() {
		// Close the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
