package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the TextBox page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//span[text()='Dropdown']")).click();	

		//Favorite Automation tool
		Select select = new Select(driver.findElement(By.className("ui-selectonemenu")));
		select.selectByVisibleText("Playwright");
		
		//Choose your preferred country.
		driver.findElement(By.id("j_idt87:country")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:country_items']//li[4]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("j_idt87:city"))));
		
		//Confirm Cities belongs to Country is loaded
		driver.findElement(By.id("j_idt87:city")).click();
		WebElement selected = driver.findElement(By.xpath("//ul[@id='j_idt87:city_items']//li[3]"));
		selected.click();
		String selectedValue = selected.getText();
		System.out.println("The Selected Value is "+selectedValue);
		
		//Choose the Course
		driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
		driver.findElement(By.xpath("//span[@id='j_idt87:auto-complete_panel']//following::li[contains(text(),'Appium')]")).click();
		
		//Choose language
		driver.findElement(By.id("j_idt87:lang")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:lang_items']//li[2]")).click();
		
		//Select 'Two' irrespective of the language chosen
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("j_idt87:value"))));
		driver.findElement(By.id("j_idt87:value")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:value_items']//li[@data-label='Two']")).click();
		
	}

}
