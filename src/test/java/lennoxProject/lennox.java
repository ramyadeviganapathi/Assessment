package lennoxProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class lennox extends baseClass {

	ExtentTest testCase;
	ExtentReports reports;
	ExtentSparkReporter spark;

	@BeforeClass
	private void browserLaunch() {
		browerLaunch();
		launchUrl("https://www.liidaveqa.com/");
		reports = new ExtentReports();
		spark = new ExtentSparkReporter("report.html");
		reports.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		testCase = reports.createTest("Verify Head");
	}

	@Test
	private void tc1() throws IOException, InterruptedException {
		lennoxPojo l = new lennoxPojo();
		clickbtn(l.getMenu());
		String text = l.getProduct().getText();
		System.out.println(text);
		String data = excelRead("Details", 1, 6);
		Assert.assertEquals(text, data);
		clickbtn(l.getProduct());
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(l.getScroll()));
		scrolldown(l.getScroll());
		clickbtn(l.getParts());
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.elementToBeClickable(l.getScrollcom()));
		scrolldown(l.getScrollcom());

		clickbtn(l.getCompressor());

		String data1 = l.getComhead().getText();
		System.out.println(data1);
		Assert.assertEquals(data1, "Compressors");
		String data2 = l.getComText().getText();
		System.out.println(data2);
		Assert.assertEquals(data2, "Shop for HVAC compressors on LennoxPros.com.");
		passtext(l.getSearchbox(), excelRead("Details", 1, 10));
		clickbtn(l.getSearch());
		String head1 = l.getHead().getText();
		System.out.println(head1);

		String head2 = l.getHead1().getText();
		System.out.println(head2);
		String substring = head2.substring(15, 25);
		System.out.println(substring);
		String data3 = excelRead("Details", 1, 11);
		Assert.assertEquals(data3, substring);

		if (head2.equals("Bristol")) {
			System.out.println("Passed");
		} else {

			TakesScreenshot t = (TakesScreenshot) driver;
			File source = t.getScreenshotAs(OutputType.FILE);
			File destination = new File("F:\\Java_Programs\\BikeInformation\\lennoxProject\\images\\pass.png");
			FileUtils.copyFile(source, destination);
			testCase.addScreenCaptureFromPath("F:\\Java_Programs\\BikeInformation\\lennoxProject\\images\\pass.png");
		}
		clickbtn(l.getCart());
	}

	@AfterClass
	public void closeBrowser() {
		reports.flush();
	}

}
