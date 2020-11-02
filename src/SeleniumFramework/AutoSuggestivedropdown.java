package SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestivedropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("qf-0q-destination")).sendKeys("Mon");
	//	Thread.sleep(4000);
		String myText = "Old Montreal, Montreal, Quebec, Canada";
		Thread.sleep(4000);
		WebElement table = driver.findElement(By.xpath("//tbody[@class='autosuggest-city']"));
		
		List<WebElement> option = table.findElements(By.xpath("//tr/td/div[2]"));
		
		
		for(int j=0;j<option.size();j++)
		{
		
			String mytextfromWebsite = option.get(j).getText();
			
			if(mytextfromWebsite.equalsIgnoreCase(myText))
			{
				option.get(j).click();
				break;
			}
			
		}
		
		
		

	}

}
