package Learning;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GridWorkings {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		//clicking on Element menu & opening the Grid page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt41']")).click();
		driver.findElement(By.xpath("//li[@id='menuform:m_crud']//span[text()='Grid']")).click();
		
		//perform bulk delete
		driver.findElement(By.xpath("//*[@id='form:dt-products:j_idt96']//div[@id='form:dt-products_head_checkbox']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form:delete-products-button']")));
		driver.findElement(By.xpath("//*[@id='form:delete-products-button']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form:j_idt159']//span[contains(text(),'Yes')]")));
		driver.findElement(By.xpath("//*[@id='form:j_idt159']//span[contains(text(),'Yes')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@aria-label='Close']//span[@class='ui-icon ui-icon-closethick'])[3]")));
		driver.findElement(By.xpath("(//a[@aria-label='Close']//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		
		//Add new Product
		driver.findElement(By.id("form:j_idt90")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form:name']")));
		driver.findElement(By.xpath("//input[@id='form:name']")).sendKeys("Wall Clock");
		driver.findElement(By.id("form:description")).sendKeys("Digital Clock with lowest price");
		driver.findElement(By.xpath("(//input[@id='form:category:2']//following::div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		WebElement price = driver.findElement(By.id("form:price_input"));
		price.click();
		price.sendKeys("13");
		driver.findElement(By.id("form:quantity_input")).sendKeys("1");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Added')]")));
		boolean sucessAlert = driver.findElement(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Added')]")).isDisplayed();
		System.out.println("Is sucess alert displayed "+sucessAlert);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = ( JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
		//Update the Added Product
		driver.findElement(By.xpath("//*[@aria-label='Last Page']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-pencil']")));
		driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-pencil']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form:name']")));
		driver.findElement(By.id("form:name")).clear();
		driver.findElement(By.id("form:name")).sendKeys("Digital Wall Clock");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Updated')]")));
		String updateAlert = driver.findElement(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Updated')]")).getText();		
		System.out.println("Message in the Update alert was " + updateAlert);
		
		//Delete one product
		driver.findElement(By.xpath("//*[@aria-label='First Page']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form:dt-products:0:j_idt115")));
		driver.findElement(By.id("form:dt-products:0:j_idt115")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Yes')])[1]")));
		driver.findElement(By.xpath("(//span[contains(text(),'Yes')])[1]")).click();
		System.out.println("First Product deleted sucessfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Removed')]")));
		String deleteAlert = driver.findElement(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Removed')]")).getText();		
		System.out.println("Message in the Update alert was " + deleteAlert);
		
		//download function
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-growl-message']//span[contains(text(),'Product Removed')]")));
		driver.findElement(By.xpath("//*[@id='form:j_idt93']//span[contains(text(),'Export')]")).click();
		System.out.println("Data downloaded");	
	}

}
