package SeleniumFramework;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www1.shoppersdrugmart.ca/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	/*	WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Shop']")).click();
		//driver.findElement(By.linkText("Personal Care")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Beauty?nav=/shop/beauty']")));
		//driver.findElement(By.partialLinkText("Beauty")).click();
		driver.findElement(By.xpath("//a[@href='/Beauty?nav=/shop/beauty']")).click();*/
		
		driver.findElement(By.xpath("//a[@title='Community']")).click();
		
		//Wait<WebDriver> wait = new FluentWait <WebDriver>(driver)
			//	.withTimeout(Duration.ofSeconds(20))
				//.pollingEvery(Duration.ofSeconds(5))
			//	.ignoring(NoSuchElementException.class);
		
	
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='carousel-inner']/div[4]/div[1]/div[1]/div[1]/a/div"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='carousel-inner']/div[4]/div[1]/div[1]/div[1]/a/div")));
		System.out.println(driver.findElement(By.xpath("//div[@class='carousel-inner']/div[4]/div[1]/div[1]/div[1]/a/div")).getText());
		
		driver.findElement(By.xpath("//div[@class='carousel-inner']/div[4]/div[1]/div[1]/div[1]/a/div")).click();
		
		
		//System.out.println(driver.findElement(By.xpath("//div[@class='cta']")).isDisplayed());
	}

}


