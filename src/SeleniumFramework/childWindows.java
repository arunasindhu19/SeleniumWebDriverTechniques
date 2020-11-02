package SeleniumFramework;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class childWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		/*driver.findElement(By.id("hdr-things-to-do")).click();
		driver.findElement(By.id("hdr-gift-card")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> id =  windows.iterator();
		String parentwindow = id.next();

		String childwindow = id.next();
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		
		String childwindow1 = id.next();
		driver.switchTo().window(childwindow1);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getTitle());*/
		
/*	WebElement element = driver.findElement(By.id("google_ads_iframe_/23171577/hotels.ca_en/home/all/CT1_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
      driver.switchTo().frame(driver.findElement(By.id("google_ads_iframe_/23171577/hotels.ca_en/home/all/CT1_0")));
      driver.findElement(By.xpath("//*[contains(@href,'adclick.g.doubleclick')]")).click();*/
     
      
     // driver.switchTo().defaultContent();
		
		 WebElement footer= driver.findElement(By.cssSelector(".section-links"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    
     int count = footer.findElements(By.tagName("a")).size();
     System.out.println(count);
     System.out.println(driver.getTitle());
     
     for(int i=49; i<count;i++)
     {
    	 System.out.println(footer.findElements(By.tagName("a")).get(i).getText());
    	 footer.findElements(By.tagName("a")).get(i).click();
     }
		

     Set<String> handles = driver.getWindowHandles();
     Iterator<String> ids = handles.iterator();
     while(ids.hasNext())
     {
    	 driver.switchTo().window(ids.next());
    	 System.out.println(driver.getTitle());
     }
	}

}
