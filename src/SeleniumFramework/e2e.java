package SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test-T460\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		//WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.cssSelector(".widget-query-autosuggest.clearable.autosuggest-enabled")).sendKeys("Paris");
	
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//tbody[@class='autosuggest-city']/tr/td/div[2]"));
		
		for(WebElement option : options)
		{
			System.out.println(option.getText());
			if(option.getText().equals("Paris, France"))
			{
				//Assert.assertEquals(option.getText(), "Eiffel Tower, Paris, France");
				System.out.println("I am in the for loop");
				Thread.sleep(2000);
				option.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		WebElement Checkin = driver.findElement(By.xpath("//div[@class='widget-query-group widget-query-dates']/div[1]"));
		WebElement Checkout = driver.findElement(By.xpath("//div[@class='widget-query-group widget-query-dates']/div[2]"));
		
		Checkin.click();
		
		driver.findElement(By.cssSelector(".widget-datepicker-selected.widget-datepicker-highlight")).click();
		
		Checkout.click();
		driver.findElement(By.cssSelector("td[data-date='2020-9-20']")).click();
		
		String Nights = driver.findElement(By.cssSelector(".widget-query-num-nights")).getText();
		
		System.out.println("Number of Nights is equal to - >" + Nights);
		
		
		//Assert.assertEquals(Nights, "2");
		
		Select sel = new Select(driver.findElement(By.name("q-rooms")));
		sel.selectByValue("2");
		Select sel1 = new Select(driver.findElement(By.name("q-room-0-adults")));
		sel1.selectByIndex(1);
		Select sel2 = new Select(driver.findElement(By.name("q-room-0-children")));
		sel2.selectByVisibleText("2");
		
		Select sel3 = new Select(driver.findElement(By.name("q-room-0-child-0-age")));
		sel3.selectByVisibleText("2");
		
		Select sel4 = new Select(driver.findElement(By.name("q-room-0-child-1-age")));
		sel4.selectByVisibleText("2");
		
		Select sel5 = new Select(driver.findElement(By.name("q-room-1-adults")));
		sel5.selectByVisibleText("2");
		
		Select sel6 = new Select(driver.findElement(By.name("q-room-1-children")));
		sel6.selectByVisibleText("0");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //1st page Search 
		

	    driver.findElement(By.cssSelector("span[class='name-input-wrapper'] input[type='text']")).sendKeys("Hilton");
	    
	    Actions a = new Actions(driver);
	    List<WebElement> option = driver.findElements(By.xpath("//li[@class='guided-filter-carousel-item widget-carousel-item-visible']"));
	    
	    
	    for(int i=0; i <option.size() ;i++)
	    {
	    a.moveToElement(driver.findElement(By.cssSelector(".cta.widget-carousel-cta-next"))).build().perform();
	    
	 //   driver.findElements(By.xpath("//li[@class='guided-filter-carousel-item widget-carousel-item-visible']")).get(i);
	  a.moveToElement(option.get(i)).build().perform();
	   // a.moveToElement(driver.findElements(By.xpath("//li[@class='guided-filter-carousel-item widget-carousel-item-visible']")).get(i)).build().perform();
	    System.out.println(option.get(i).getText()); 
	    a.moveToElement(driver.findElement(By.cssSelector(".cta.widget-carousel-cta-previous.widget-carousel-cta-disabled"))).build().perform();
	     
	    }
		

	    
	   WebElement move =  driver.findElement(By.xpath("//div[@class='widget-query-group widget-query-destination'] //input[@name='q-destination']"));
	    a.moveToElement(move).doubleClick().keyDown(Keys.SHIFT).sendKeys("quebec").doubleClick().contextClick().build().perform();
	}

}
