package orange_hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainClass {

	public WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(10000);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	@Test
	public void verify_login() throws InterruptedException {
		Thread.sleep(10000);
		this.driver.findElement(By.xpath(".//input[@name='username']")).sendKeys("Admin");
		this.driver.findElement(By.xpath(".//input[@name='password']")).sendKeys("admin123");
		this.driver.findElement(By.xpath(".//button[@type='submit']")).click();
		Thread.sleep(10000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement ele = this.driver
				.findElement(By.xpath(".//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
		ele.click();
		Thread.sleep(10000);
		ele.findElement(By.xpath(".//..//..//ul//li[4]/a")).click();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}

}
