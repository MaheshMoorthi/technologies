package org.macys;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Macy {
	public static void main(String[] args) throws InterruptedException, ParseException {
		
		int count=0;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahesh\\eclipse-workspace\\macys\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.macys.com/shop/mens-clothing/sale-clearance?id=9559&tagid=4295993_01_08&ctype=G&cm_re=2020.12.16-_-HOMEPAGE_INCLUDE_1_row_01-_-CATEGORY%20--%205125%20--%20:men");
//		Thread.sleep(2000);
//		Actions a=new Actions(driver);
//		a.sendKeys(Keys.ESCAPE).perform();
//		WebElement e = driver. findElement(By.id("globalSearchInputField"));
//		e.sendKeys("men"+Keys.ENTER);
		 
		Set<String> s=new LinkedHashSet<>();
		List<String> l=new LinkedList<>();
		List<String> l1=new LinkedList<>();
		Thread.sleep(3000);
		
		List<WebElement> elements = driver.findElements(By.className("productDetail"));
		 System.out.println(elements.isEmpty());
		for (WebElement webElement : elements) {
			String text = webElement.getText();
			//System.out.println(text);
			s.add(text);
			l.add(text);		
		}
		System.out.println( "total number of products: "+s.size());
		System.out.println( "total number of products: "+l.size());
		System.out.println("total number of duplicates: "+ (s.size()-l.size()));
		
		
		List<String> l3=new LinkedList<>();
		List<WebElement> elements2 = driver.findElements(By.xpath("//span[@class='regular originalOrRegularPriceOnSale']"));
		for (WebElement webElement : elements2) {
			String text = webElement.getText();
			
			l3.add(text);
			
		}
		List<Integer> A=new ArrayList<>();
		
		System.out.println("Above 4000 inr products prices are ");
		for (String li : l3) {
			String substring = li.substring(4);
			//String substring2 = substring.substring(5);
			String replace = substring.replace(',', '0');
			String substring2 = replace.substring(0,5);
			int sizeint = NumberFormat.getIntegerInstance().parse(substring2).intValue();
		int price=sizeint/10;
		if (price>4000) {
			
			System.out.println(price);
			
		}
		}
		
		
	
	}

	}
