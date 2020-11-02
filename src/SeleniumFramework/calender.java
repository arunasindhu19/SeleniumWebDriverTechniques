package SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
			
		WebElement Checkin = driver.findElement(By.xpath("//div[@class='widget-query-group widget-query-dates']/div[1]"));
		Checkin.click();
		
		System.out.println(driver.findElement(By.className("widget-datepicker-label")).getText());
		
		String monthName = driver.findElement(By.className("widget-datepicker-label")).getText();
		
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='widget-datepicker-hd'] //div[@class='widget-datepicker-label']"));
	//	System.out.println(names.size());
		
		
		
		
		while(!(driver.findElement(By.xpath("//div[@class='widget-datepicker-hd'] //div[@class='widget-datepicker-label']")).getText().contains("February")))
		{
			
		
			driver.findElement(By.xpath("(//div[@class='widget-daterange-cont'] //button[@class='widget-datepicker-next'])[2]")).click();
			
			
		}
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Test-T460\\Documents\\ScreenshotsSelenium\\screenshot.jpg"));
		
		
		
		
		
	
		
	
	/*	if(!(monthName.contains("January")))
		{
			driver.findElement(By.className("widget-datepicker-next")).click();
		}*/
		
		//January 1st
		
		
	}

}
