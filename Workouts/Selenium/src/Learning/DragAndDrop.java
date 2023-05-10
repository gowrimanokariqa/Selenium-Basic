package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(options);
	
	//open respective page
	driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
	
	//clicking on Browser menu & opening the Window page
	driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt39']")).click();
	driver.findElement(By.xpath("//span[text()='Drag']")).click();
	
	//Drag using x and y offset
	WebElement dragable = driver.findElement(By.id("form:conpnl"));
	Actions action = new Actions(driver);
	action.dragAndDropBy(dragable, 60, 60).build().perform();

	//Drag and Drop function
	WebElement drag = driver.findElement(By.id("form:drag"));
	WebElement drop = driver.findElement(By.id("form:drop"));
	action.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Drag column
	WebElement fromColumn = driver.findElement(By.id("form:j_idt94:j_idt99"));
	WebElement toColumn =driver.findElement(By.id("form:j_idt94:j_idt95"));
	action.clickAndHold(fromColumn).moveToElement(toColumn).release(toColumn).build().perform();
	WebElement columnAlterToast = driver.findElement(By.xpath("//div[@role='alert']"));
	String toastMessage = columnAlterToast.getText();
	System.out.println("Column Altered Toast message was \n " + toastMessage);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.invisibilityOf(columnAlterToast));
	
	//Drag rows
	WebElement fromRow = driver.findElement(By.xpath("//div[@id='form:j_idt111']//td[text()='Bamboo Watch']"));
	WebElement toRow = driver.findElement(By.xpath("//div[@id='form:j_idt111']//td[text()='Blue T-Shirt']"));
	System.out.println(toRow.getLocation());
	action.dragAndDropBy(fromRow, 50, 70).build().perform();
	WebElement rowAlterToast = driver.findElement(By.xpath("//div[@role='alert']"));
	System.out.println("Row Altered toast message was \n  "+ rowAlterToast.getText());
	wait.until(ExpectedConditions.invisibilityOf(rowAlterToast));
	
	//resize image
	WebElement adjustor =driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
	action.dragAndDropBy(adjustor, 150, 35).build().perform();
	WebElement resizeToast = driver.findElement(By.xpath("//div[@role='alert']"));
	System.out.println("Image altered message was \n  "+ resizeToast.getText());
	wait.until(ExpectedConditions.invisibilityOf(resizeToast));
	
	//progress bar
	driver.findElement(By.id("form:j_idt119")).click();
	WebElement progressToast = driver.findElement(By.xpath("//div[@role='alert']"));
	wait.until(ExpectedConditions.visibilityOf(progressToast));
	String percent = driver.findElement(By.className("ui-progressbar-label")).getText();
	System.out.println("Progress bar value is "+ percent);
}
}
