

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CricketDB {
	WebDriver driver = null;


	// before class
	// before
	// test
	// after
	// before
	// test
	// after
	// After class

	@BeforeClass
	public void setup1() {
		String driverPath = System.getProperty("user.dir")+"\\drivers\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
	}

	@AfterClass
	public void after() {

	}

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://localhost:8000/");
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void test1() throws Exception {

		By addPlayer = By.linkText("Add New Player");
		WebElement link = driver.findElement(addPlayer);
		link.click();
		takeSS(driver, "before");
		driver.findElement(By.id("playername")).sendKeys("kunal7");
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select s1 = new Select(countryDropdown);
		s1.selectByVisibleText("Pakistan");
		takeSS(driver, "after");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@id='playerYear']")).sendKeys("1996");
		WebElement AddPlayer = driver.findElement(By.xpath("//button[text()='Add Player']"));
		AddPlayer.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert popup = driver.switchTo().alert();
		String popupMsg = popup.getText();
		System.out.println(popupMsg);

		popup.accept();
	}

	@Test
	public void test2() throws Exception {

		By addPlayer = By.linkText("Add New Player");
		WebElement link = driver.findElement(addPlayer);
		link.click();
		takeSS(driver, "before");
		driver.findElement(By.id("playername")).sendKeys("kunal8");
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select s1 = new Select(countryDropdown);
		s1.selectByVisibleText("Pakistan");
		takeSS(driver, "after");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@id='playerYear']")).sendKeys("1996");
		WebElement AddPlayer = driver.findElement(By.xpath("//button[text()='Add Player']"));
		AddPlayer.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert popup = driver.switchTo().alert();
		String popupMsg = popup.getText();
		System.out.println(popupMsg);

		popup.accept();
	}

	public static void takeSS(WebDriver driver, String screenshotName) throws Exception {
		Date date = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy-HH:mm:ss-z"); => if I have written this line for time then it gives me error

		String todayDate = dateFormat.format(date);

		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,
				new File(System.getProperty("user.dir")+"\\screenshot\\"+screenshotName+" "+todayDate+".png"));
	}

}
