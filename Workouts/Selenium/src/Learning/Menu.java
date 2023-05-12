package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Menu {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the Menu page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt42']")).click();
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		
		//click +customer from menu bar
		driver.findElement(By.xpath("//a[@role='menuitem']//following::span[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("(//*[@role='menuitem']//following::span[contains(text(),'New')])[1]")).click();
		driver.findElement(By.xpath("(//*[@role='menuitem']//following::span[contains(text(),'Customer')])[2]")).click();
		System.out.println("Add Customer has been clicked");
		
		//Click on sakes from tab menu
		driver.findElement(By.xpath("//ul[@role='tablist']//span[contains(text(),'Sales')]")).click();
		System.out.println("Sales tab has beem clicked");
		
		//click Order-View from slider menu
		driver.findElement(By.xpath("(//span[contains(text(),'Orders')])[2]")).click();
		driver.findElement(By.xpath("(//*[@class='ui-slidemenu-wrapper']//a[@role='menuitem'])[7]")).click();
		System.out.println("View has been clicked");
		
		driver.manage().window().maximize();
		JavascriptExecutor js = ( JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	
		//click Tracker from Shipments menu
		driver.findElement(By.xpath("//a[contains(text(),'Shipments')]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Tracker')])[2]//parent::a[@role='menuitem']")).click();
		System.out.println("Tracker has been clicked");
		
		//Click update from option button from Menu
		driver.findElement(By.id("j_idt87:j_idt144_button")).click();
		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt144_menu']//following::a[1]")).click();
		System.out.println("Update has been clicked");
		
		//right click for menu option
		Actions action = new Actions(driver);
		WebElement context = driver.findElement(By.xpath("//h5[contains(text(),'Context Menu')]"));
		action.contextClick(context).perform();
		System.out.println("Right clicked on the text");
	}
}
