package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameWorkings {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the Frame page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt39']")).click();
		driver.findElement(By.xpath("//span[text()='Frame']")).click();
		
		//clicking on the Frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		
		//clicking on the nested frame		
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
		driver.switchTo().frame(frame);
		WebElement nestedFrame = driver.findElement(By.xpath("//iframe[@src='framebutton.xhtml']"));
		driver.switchTo().frame(nestedFrame);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		
		//count the Frame
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int frameCount = frames.size();
		System.out.println("Total no of frames in the application was "+frameCount);
	}

}
