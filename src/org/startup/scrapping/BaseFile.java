package org.startup.scrapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseFile {

	String baseURL = "http://www.advocatekhoj.com/library/bareacts/index.php";

	void startJob(WebDriver driver) {
		try {
			driver.get(baseURL);
			WebElement mainDiv = driver.findElement(By
					.xpath("//*[@id='content_container']/table"));
			List<WebElement> tds = mainDiv.findElements(By.tagName("td"));
			System.out.println(tds.size());
			int sl = 1;
			for (int index = 1; index < tds.size() - 2; index = index + 2) {
				WebElement td = tds.get(index);
				String bareActNum = "";
				String bareActName = "";
				
				bareActNum = sl + "";
				bareActName = td.getText();
				System.out.println("bareActNum : " + bareActNum);
				System.out.println("bareActName : " + bareActName);
				
//				td.findElement(By.tagName("a")).click();
//				Thread.sleep(500);
//				WebElement contentDiv = driver.findElement(By.id("content_container"));
//				List<WebElement> descEl = contentDiv.findElements(By.tagName("p"));
//				descEl.get(descEl.size());
				
				sl++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			driver.quit();
			driver.close();
		}
		
	}

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new BaseFile().startJob(driver);
	}
}
