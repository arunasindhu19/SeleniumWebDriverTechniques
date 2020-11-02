package SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test-T460\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();
		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".widget-query-autosuggest.clearable.autosuggest-enabled")).sendKeys("Paris");
	
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//tbody[@class='autosuggest-landmark']/tr"));
		
		for(WebElement option : options)
		{
			System.out.println(option.getText());
			if(option.getText().equals("Eiffel Tower, Paris, France"))
			{
				Assert.assertEquals(option.getText(), "Eiffel Tower, Paris, France");
				option.click();
			}
		}
		
		
			
		driver.findElement(By.id("hdr-customer-bookings")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='sign-in-persistant']")).click();
		Thread.sleep(4000);
		System.out.println(driver.findElement(By.xpath("//div[@class='input-wrapper']")).isSelected());
		//driver.close();
		
		
		

	}

}
