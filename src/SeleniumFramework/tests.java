package SeleniumFramework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class tests {

	public static void main(String[] args) {
		int i = 461012;
		System.out.format("The value of i is: %d%n", i);
		
		LocalDateTime now = LocalDateTime.now();  

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		
		System.out.println(dtf.format(now));
		
	

	}

}
