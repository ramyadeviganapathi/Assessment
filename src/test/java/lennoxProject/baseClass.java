package lennoxProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver;

	public static void browerLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String excelRead(String Sheet, int rn, int cellNum) throws IOException {

		File f = new File(System.getProperty("user.dir")+"\\Excel\\lennoxPros.xlsx");

		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(Sheet);
		Row row = sheet.getRow(rn);
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		String value = "";

		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			value = sdf.format(dateCellValue);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}
		return value;

	}

	public static void passData(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void clickbtn(WebElement element) {
		element.click();
	}

	public static void passtext(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void scrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static String getAttributereturn(WebElement element) {
		String enteredTxt = element.getAttribute("value");
		System.out.println(enteredTxt);
		return enteredTxt;

}
}