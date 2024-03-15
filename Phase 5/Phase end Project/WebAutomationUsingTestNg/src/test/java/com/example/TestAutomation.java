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
import org.openqa.selenium.interactions.Actions;
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
	public void flipkartLoadHomePage() throws IOException, InterruptedException {
		try {
			driver.get("https://www.flipkart.com");
			Thread.sleep(2000);
			System.out.println("Homepage loaded successfully.");
			takeScreenshot(driver, "HomePageLoaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void flipkartLoadTime() throws InterruptedException {
		try {
			long startTime = System.currentTimeMillis();
			driver.get("https://www.flipkart.com");
			long endTime = System.currentTimeMillis();
			long pageLoadTime = endTime - startTime;
			System.out.println("Page load time: " + pageLoadTime / 1000 + " seconds");
			takeScreenshot(driver, "LoadTime");
			if (pageLoadTime / 1000 > 2) {
				throw new AssertionError("Not loaded within 2 seconds.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void flipkartSearch() throws IOException, InterruptedException {

		try {
			driver.get("https://www.google.com");
			WebElement queryField = driver.findElement(By.name("q"));

			queryField.sendKeys("flipkart");
			queryField.submit();

			// Wait for the Flipkart link to appear and click on it
			driver.findElement(By.partialLinkText("Flipkart")).click();
			Thread.sleep(1000);

			// Search for "iPhone 13" on Flipkart
			driver.findElement(By.name("q")).sendKeys("iPhone 13");
			driver.findElement(By.name("q")).submit();
			System.out.println("Searched successfully!");

			takeScreenshot(driver, "FlipkartSearch");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void flipkartImageHeight() throws IOException, InterruptedException {

		try {
			driver.get("https://www.google.com");
			WebElement queryField = driver.findElement(By.name("q"));

			queryField.sendKeys("flipkart");
			queryField.submit();

			// Wait for the Flipkart link to appear and click on it
			driver.findElement(By.partialLinkText("Flipkart")).click();
			Thread.sleep(1000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			long windowHeight = (long) js.executeScript("return window.innerHeight;");
			java.util.List<WebElement> images = driver.findElements(By.tagName("img"));
			for (WebElement image : images) {
				double imageBottom = ((Number) js.executeScript("return arguments[0].getBoundingClientRect().bottom;",
						image)).doubleValue();
				if (imageBottom > windowHeight) {
					throw new AssertionError("Image extends beyond screen height");
				}
			}

			takeScreenshot(driver, "FlipkartImage");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void flipkartScrollCheck() throws IOException, InterruptedException {

		try {
			driver.get("https://www.google.com");
			WebElement queryField = driver.findElement(By.name("q"));

			queryField.sendKeys("flipkart");
			queryField.submit();

			// Wait for the Flipkart link to appear and click on it
			driver.findElement(By.partialLinkText("Flipkart")).click();
			Thread.sleep(1000);

			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.END).build().perform();
			Thread.sleep(3000); // Wait for scrolling

			System.out.println("Tests passed successfully!");
			takeScreenshot(driver, "FlipkartScroll");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void flipkartBottomNavigate() throws IOException, InterruptedException {

		try {
			driver.get("https://www.google.com");
			WebElement queryField = driver.findElement(By.name("q"));

			queryField.sendKeys("flipkart");
			queryField.submit();

			// Wait for the Flipkart link to appear and click on it
			driver.findElement(By.partialLinkText("Flipkart")).click();
			Thread.sleep(1000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			long scrollY = (long) js.executeScript("return window.scrollY;");
			Thread.sleep(4000);
			if (scrollY <= 0) {
				throw new AssertionError("Failed to navigate to the bottom of the page");
			}
			System.out.println("Tests passed successfully!");
			takeScreenshot(driver, "FlipkartBottomNavigate");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void flipkartImageCheck() throws IOException, InterruptedException {

		try {
			driver.get("https://www.google.com");
			WebElement queryField = driver.findElement(By.name("q"));

			queryField.sendKeys("flipkart");
			queryField.submit();

			// Wait for the Flipkart link to appear and click on it
			driver.findElement(By.partialLinkText("Flipkart")).click();
			Thread.sleep(1000);

			java.util.List<WebElement> images = driver.findElements(By.tagName("img"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement lastImage = images.get(images.size() - 1);
			js.executeScript("arguments[0].scrollIntoView(true);", lastImage); // Scroll to the last image
			long imageLoadTimestamp = System.currentTimeMillis();
			// Wait for the image to load
			while (((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
					lastImage) != null) {
				Thread.sleep(100);
			}
			long scrollTimestamp = System.currentTimeMillis();
			long timeDifference = scrollTimestamp - imageLoadTimestamp;
			if (timeDifference > 1000) { // Adjust the threshold as needed
				throw new AssertionError("Image was not downloaded just before scrolling");
			}
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
