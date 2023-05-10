package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.Alert;

public class AlertWorkings {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the Alert page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt39']")).click();
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		
		//clicking on simple alert, moving control to alert and click Ok from alert
		WebElement simpleDialog =driver.findElement(By.id("j_idt88:j_idt91"));
		simpleDialog.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//confirmation alert
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.accept();
		
		//sweetalert but inspectable
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		driver.findElement(By.id("j_idt88:j_idt98")).click();
		
		//sweetmodel alert but inspectable
		/*driver.findElement(By.id("j_idt88:j_idt100")).click();
		driver.findElement(By.xpath("(//a[@href='#']//following::span[@class='ui-icon ui-icon-closethick'])[1]")).click();*/
		
		//prompt alert
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("check");
		promptAlert.accept();
		
		//sweet confirmation
		driver.findElement(By.id("j_idt88:j_idt106")).click();
		driver.findElement(By.id("j_idt88:j_idt108")).click();
		
		//minimize and maximize
		driver.findElement(By.id("j_idt88:j_idt111")).click();
		WebElement hoverOnElement = driver.findElement(By.xpath("(//div[@id='j_idt88:j_idt112']//following::a)[2]"));		
		WebElement close = driver.findElement(By.xpath("(//div[@id='j_idt88:j_idt112']//following::a)[1]"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		action.moveToElement(hoverOnElement).perform();
		wait.until(ExpectedConditions.visibilityOf(hoverOnElement));
		action.moveToElement(hoverOnElement).click().perform();
		
		action.moveToElement(close).perform();
		wait.until(ExpectedConditions.visibilityOf(close));
		action.moveToElement(close).click().perform();
		
		driver.quit();	
	}
}
