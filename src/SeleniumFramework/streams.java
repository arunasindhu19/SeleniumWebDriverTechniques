package SeleniumFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test-T460\\Downloads\\LatestChrome85\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www1.shoppersdrugmart.ca/en/home");
		driver.manage().window().maximize();
		
		 WebElement footer= driver.findElement(By.xpath("//div[@class='footer__grid-col footer__grid-column--2']"));
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
	     
	     WebElement boxLink = driver.findElement(By.xpath("//div[@class='footer__grid-col footer__grid-column--2']"));
		 List<WebElement> links = boxLink.findElements(By.tagName("a"));
		 
		 ArrayList<String> names = new ArrayList<String>();
		 
		 
		 for(int i=0;i<links.size();i++)
		 {
			String name = boxLink.findElements(By.tagName("a")).get(i).getText();
			names.add(name);
			 
		 } 
		 System.out.println(names);
		 
		 //Q1. Give the count of names that starts with "C"
		 Long c = names.stream().filter(s->s.startsWith("C")).count();
		 System.out.println(c);
		 
		 //Q2. Print the names that have length more than 7
		 names.stream().filter(s->s.length()>7).forEach(s->System.out.println(s));
		 
		 //Q3. Print only 2 Result
		 names.parallelStream().filter(s->s.length()>7).limit(2).forEach(s->System.out.println(s));
		 
		 //Q4. Prrnt the names that ends with "s" and print to uppercase
		 names.stream().filter(s->s.endsWith("s")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		 
		
		 //Q5. Sort the names Alphabetically
		 
		 names.stream().sorted().forEach(s->System.out.println(s));
		 
		 //Q6. Print Unique Values
		 Integer[] numbers = {5,1,2,3,4,5,1,2,3,4}; //Array
		 
		 //Convert Array to ArrayList
		 
		 List<Integer> num = Arrays.asList(numbers);
		 ArrayList<Integer>num1 = (ArrayList<Integer>) num.stream().distinct().sorted().collect(Collectors.toList());
		 
		 System.out.println("These are the distcinct numbers " + num1);
		 System.out.println("This is the 4th Index number " + num1.get(4));
		 
		 
		 
		 
	}

}
