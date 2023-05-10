package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWorkings {

	public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			
			//open respective page
			driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
			
			//clicking on Element menu & opening the Wait page
			driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
			driver.findElement(By.xpath("//span[text()='Waits']")).click();
			
			//Wait for Visibility (1 - 10 Sec)
			driver.findElement(By.id("j_idt87:j_idt89")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt87:j_idt90")));
			System.out.println("Element has appeared");
			
			//Wait for Invisibility (1 - 10 Sec
			driver.findElement(By.id("j_idt87:j_idt92")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt87:j_idt93")));
			System.out.println("Element has disappeared");
			
			//Wait for Clickability
			driver.findElement(By.id("j_idt87:j_idt95")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt87:j_idt96")));
			System.out.println("Waited till the clickability of the item");
			
			//Wait for the text change
			String oldText = driver.findElement(By.id("j_idt87:j_idt99")).getText();
			driver.findElement(By.id("j_idt87:j_idt98")).click();
			wait.until(ExpectedConditions.textToBe(By.id("j_idt87:j_idt99"), "Did you notice?"));
			System.out.println("Text has been changed from "+oldText +" to Did you notice?");
	}

}
