package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the CheckBox page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();	
		
		//Basic Checkbox
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89']//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();

		//Notification
		driver.findElement(By.xpath("(//div[@id='j_idt87:j_idt91']//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean toast = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).isEnabled();
		System.out.println("Is the Toast enabled " + toast);
		
		//Select favorite language
		driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//td[3]//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
	
		//Tri-State Checkbox
		WebElement uniqueCheck= driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"));
		uniqueCheck.click();
		String firstClickMessage = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println("First Click mesage was "+ firstClickMessage);
		//Second Click
		uniqueCheck.click();
		System.out.println("Checkbox clicked Second Time");
		//Third Click
		uniqueCheck.click();
		System.out.println("Checkbox clicked Third Time");
		
		//Toggle Switch
		driver.findElement(By.id("j_idt87:j_idt100")).click();
		
		//Disabled Checkbox
		boolean IsCheckboxEnabled = driver.findElement(By.xpath("//div[@id='j_idt87:j_idt102']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled ui-state-disabled']")).isSelected();
		System.out.println("Is the check box enabled "+ IsCheckboxEnabled);
		
		//Select Multiple
		driver.findElement(By.id("j_idt87:multiple")).click();
		driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']//li[@data-item-value='Miami']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']//li[@data-item-value='London']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		driver.findElement(By.xpath("//a[@class='ui-selectcheckboxmenu-close ui-corner-all']")).click();
	}
	

}
