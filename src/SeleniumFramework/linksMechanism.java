package SeleniumFramework;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class linksMechanism {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www1.shoppersdrugmart.ca/en/home");
		driver.manage().window().maximize();
		
		
		
		 WebElement footer= driver.findElement(By.xpath("//div[@class='footer__grid-col footer__grid-column--2']"));
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		
		
		
		WebElement boxLink = driver.findElement(By.xpath("//section[@class='footer']"));
		List<WebElement> links = boxLink.findElements(By.tagName("a"));
		
		SoftAssert soft = new SoftAssert();
		
	
		for(WebElement link: links)
		{
			String url = link.getAttribute("href");
			//System.out.println(url);
			
			
			HttpURLConnection connec = (HttpURLConnection) new URL(url).openConnection();
			connec.setRequestMethod("HEAD");
			connec.connect();
			int statusCode = connec.getResponseCode();
		//	System.out.println(statusCode);
			
			soft.assertTrue(statusCode<400, "Status Code is greater than 400 " + url + " " + statusCode);
			
		}
		soft.assertAll();

	}

}
