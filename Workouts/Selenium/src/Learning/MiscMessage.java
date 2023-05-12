package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiscMessage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the Message page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt43']")).click();
		driver.findElement(By.xpath("(//*[@id='menuform:m_message']//*[contains(text(),'Message')])[1]")).click();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Message under Messages section
		driver.findElement(By.id("j_idt89:j_idt90")).click();
		driver.findElement(By.id("j_idt89:j_idt91")).click();
		driver.findElement(By.id("j_idt89:j_idt92")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt89:messages']//span[@class='ui-icon ui-icon-close']")));
		driver.findElement(By.xpath("//*[@id='j_idt89:messages']//span[@class='ui-icon ui-icon-close']")).click();
		
		//MEssage under Growl section
		driver.findElement(By.id("j_idt94:j_idt95")).click();
		driver.findElement(By.id("j_idt94:j_idt96")).click();
		driver.findElement(By.id("j_idt94:j_idt97")).click();
	}
}
