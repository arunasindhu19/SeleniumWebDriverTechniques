package SeleniumFramework;

import java.util.Set;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelBooking {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ca.hotels.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.id("qf-0q-destination")).sendKeys("Montreal");
		//driver.findElement(By.linkText("Things to do")).click();
		
		driver.findElement(By.xpath("//*[@id=\'hdr-customer-bookings\']")).click();
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/div/div[2]/form/div[2]/div/label")).getText());
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\'hdr-create\']")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector("#header-sign-in")).click();
		driver.navigate().back();
		
		driver.findElement(By.linkText("Things to do")).click();
		
		System.out.println(driver.getCurrentUrl());
			//Child Window Handling
		
		/*Set<String> handles = driver.getWindowHandles();

	     System.out.println("no of windows" +handles.size());

	     String firstWinHandle = driver.getWindowHandle(); 
	     System.out.println("FirstWindowHandle is:-> " + firstWinHandle);
	     System.out.println("My FirstWindow Current URL IS:-> " + driver.getCurrentUrl());

	     String window1=handles.iterator().next(); //Parent Window
	     String window2=handles.iterator().next(); //Parent Window

	     
	          driver.switchTo().window(window2);
	          System.out.println("After Switching:-> "+ driver.getCurrentUrl());*/
		
		String mainWindow=driver.getWindowHandle();
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr= set.iterator();
		while(itr.hasNext())
		{
		String childWindow=itr.next();
		// Compare whether the main windows is not equal to child window. If not equal, we will close.
		if(!mainWindow.equals(childWindow)){
		driver.switchTo().window(childWindow);
		System.out.println(driver.switchTo().window(childWindow).getCurrentUrl());
		//Xpath Regular Expression
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//CSS Selector Regular Expression
		driver.findElement(By.cssSelector("a[href*='destination']")).click();
		driver.findElement(By.xpath("//input[@name='location']")).sendKeys("Vancouver");
		
		driver.switchTo().window(mainWindow);
		
		System.out.println("No of Nights" + driver.findElement(By.xpath("//div[@class='widget-query-group widget-query-dates']/span")).getText());
		
		int count = driver.findElements(By.xpath("//div[@class='fixed-width']/ul/li")).size();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fixed-width']/ul/li"));
		
		for(int i=0; i<count;i++)
		{
			String childTags = list.get(i).getText();
			System.out.println(childTags);
			if(childTags.equalsIgnoreCase("Gift Cards"))
			{
				list.get(i).click();
				
			}
			
		}
		
		driver.switchTo().window(mainWindow);
		Select sel = new Select(driver.findElement(By.name("q-rooms")));
		sel.selectByValue("3");
		Select sel1 = new Select(driver.findElement(By.name("q-room-0-adults")));
		sel1.selectByIndex(8);
		Select sel2 = new Select(driver.findElement(By.name("q-room-0-children")));
		sel2.selectByVisibleText("5");
		
		for(int i=0; i<count;i++)
		{
			String childTags = list.get(i).getText();
			System.out.println(childTags);
			if(childTags.equalsIgnoreCase("Groups & Meetings"))
			{
				list.get(i).click();
			
			}
			
		}
		
		String mainWindow1=driver.getWindowHandle();
		Set<String> set1 =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr1= set1.iterator();
		while(itr1.hasNext())
		{
			String childWindow1=itr1.next();
			if(!mainWindow1.equals(childWindow1)){
				driver.switchTo().window(childWindow1);
				System.out.println(driver.getCurrentUrl());
				String url = "https://groups.hotels.com/Group-Rate/?locale=en_CA&intlid=HOME+%3A%3A+header_main_section&kw=header";
				if(driver.getCurrentUrl().equals(url))
				{
				//	driver.switchTo().window(childWindow1);
					driver.findElement(By.xpath("//input[@id='rooms']")).sendKeys("10");
				}

		}
		
	
		}
		

	}

		}
	}}
