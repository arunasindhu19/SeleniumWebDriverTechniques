package SeleniumFramework;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;


public class AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Test-T460\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String[] vegetablesList = { "Mushroom", "Potato", "Banana", "Mango", "Brinjal", "Grapes", "Pears" };

		WebElement products = driver.findElement(By.xpath("//div[@class='products']"));

		addItems(driver, vegetablesList);
		addtoCart(driver);
		placeOrder(driver);

	}
	public static void addItems(WebDriver driver, String[] vegetablesList) throws InterruptedException {


		List<WebElement> list = driver.findElements(By.xpath("//div[@class='product']"));
		Thread.sleep(3000);
		for (int i = 0; i < list.size(); i++) {
			String names = driver.findElements(By.xpath("//h4[@class='product-name']")).get(i).getText();
			// System.out.println(names);

			String[] item = names.split("-");
			String itemName = item[0].trim();
			System.out.println(itemName);

			List veggies = Arrays.asList(vegetablesList);
			int j = 0;
			if (veggies.contains(itemName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

				if (j == vegetablesList.length) {
					break;
				}

			}

		}
	}
	public static void addtoCart(WebDriver driver)

	{
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.cssSelector("button[type='button']")).click();
		
	}
    public static void placeOrder(WebDriver driver)
    {
    	driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
    	driver.findElement(By.cssSelector(".promoBtn")).click();
    	String actualText = driver.findElement(By.cssSelector(".promoInfo")).getText();
    	Assert.assertEquals(actualText, "Code applied ..!");
    	
    }
}

