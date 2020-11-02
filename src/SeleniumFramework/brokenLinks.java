package SeleniumFramework;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
		
		
		
		 WebElement footer= driver.findElement(By.xpath("//h2[text()='Top Countries & Regions']"));
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		
		driver.findElement(By.xpath("//h2[text()='Top destinations']")).click();
		
		WebElement boxLink = driver.findElement(By.id("widget-toggle-i0-e0"));
		List<WebElement> links = boxLink.findElements(By.tagName("a"));
		for(WebElement link: links)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection connec = (HttpURLConnection) new URL(url).openConnection();
			connec.setRequestMethod("HEAD");
			connec.connect();
			int statusCode = connec.getResponseCode();
			System.out.println(statusCode);
			
		}

	}

}
