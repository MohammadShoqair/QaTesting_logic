package testing;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing_class {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromeweb driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://127.0.0.1:5500/project.html");

		driver.manage().window().maximize();

		List<WebElement> numOfStudents = driver.findElements(By.tagName("option"));

		boolean isChecked = false;
		

		for (int i = 0; i < numOfStudents.size(); i++) {

			isChecked= numOfStudents.get(i).isSelected();
			
			if (!isChecked) {
				numOfStudents.get(i).click();
				if (i%2!=0) {
					driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();;
				}
				Thread.sleep(1000);
			}
			

		}
		
		driver.findElement(By.xpath("//*[@id=\"selectNow\"]")).click();
		
Date currenTime = new Date (); 
		
		String screenshotFileName = currenTime.toString().replace(":", "-");
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(".\\screenshots/" + screenshotFileName + ".png");
			FileUtils.copyFile(SrcFile,  DestFile);


	}

}
