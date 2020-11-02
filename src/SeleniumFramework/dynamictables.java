package SeleniumFramework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamictables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();                      /*This is to disbale/enable notification pop ups*/ 
		Map<String, Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		//1-Allow, 2-Block, 0-default
		options.setExperimentalOption("prefs",prefs);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.espncricinfo.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//div[@class='scorecard-container scorecard-without-separator']")).click();
		WebElement footer= driver.findElement(By.xpath("//a[text()='Full Table']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].scrollIntoView(true);", footer);
		
		List<WebElement> table = driver.findElements(By.xpath("(//div[@class='table-responsive'])[5] //table/tbody/tr/td[5]"));
		List<WebElement> table1 = driver.findElements(By.xpath("(//div[@class='table-responsive'])[5] //table/tbody/tr/td[6]"));
		
		for(int i=0;i<table.size();i++)
		{
			System.out.println(table.get(i).getText());
			System.out.println(table1.get(i).getText());
			
		}
	
		
		
		
	}

}
