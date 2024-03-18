package Basic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import commonUtils.JavaUtil;



public class AjioTest {

	JavaUtil ju=new JavaUtil();
	@Test
	public void ajio1() throws IOException
	{
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://www.ajio.com/");
		
		WebElement women = d.findElement(By.xpath("//span[text()='WOMEN']"));
		Actions a = new Actions(d);
		a.moveToElement(women);
		a.perform();
		
		d.findElement(By.xpath("(//a[text()='Sunglasses & Frames'])[2]")).click();
		
		d.findElement(By.cssSelector("img[alt='Product image of FOSSIL Women Gradient Cat-Eye Sunglasses-FO013']")).click();
		
		Set<String> ids = d.getWindowHandles();
		
		for (String b : ids) 
		{
			String title = d.switchTo().window(b).getTitle();
			System.out.println(title);
			
			if (title.contains("Buy Grey Sunglasses for Women by FOSSIL Online | Ajio.com")) 
			{
			   break;	
			}
			
		}
		
		d.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		d.findElement(By.xpath("//span[text()='GO TO BAG']")).click();
		
		TakesScreenshot ts = (TakesScreenshot)d;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		int num = ju.getRandomNumber();
	    File destfile = new File("./Ajio/bag.png"+num);
	    FileUtils.copyFile(tempfile, destfile);
		
		
		
		
		
		
	}
}
