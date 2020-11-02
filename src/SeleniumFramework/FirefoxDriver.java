package SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FirefoxDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test-T460\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();
		driver.get("https://ca.hotels.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.id("qf-0q-destination")).sendKeys("Montreal");
		//driver.findElement(By.linkText("Things to do")).click();
		
		driver.findElement(By.xpath("//*[@id=\'hdr-customer-bookings\']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\'hdr-create\']")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector("#header-sign-in")).click();
		driver.navigate().back();
		driver.close();
		

	}

}
