package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the Calendar page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt41']")).click();
		driver.findElement(By.xpath("//li[@id='menuform:m_calendar']//span[text()='Calendar']")).click();
		
		//click the Previous button
		driver.findElement(By.xpath("//button[contains(text(),'Previous')]")).click();
		String previousMonth = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText();
		System.out.println("Previous month is "+previousMonth );
		
		//Click Current date
		driver.findElement(By.xpath("//button[contains(text(),'Current Date')]")).click();
		
		//click the Previous button
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		String nextMonth = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText();
		System.out.println("Next month is "+nextMonth );
		
		driver.findElement(By.xpath("//button[contains(text(),'Current Date')]")).click();
		
		//Click on the Month 
		driver.findElement(By.xpath("//button[contains(text(),'Month')]")).click();
		String currentMonth = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText();
		System.out.println("Current month is "+currentMonth );
		
		//Click on the Week 
		driver.findElement(By.xpath("//button[contains(text(),'Week')]")).click();
		String currentWeek = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText();
		System.out.println("Current week is "+currentWeek );
		
		//Click on the Day 
		driver.findElement(By.xpath("//button[contains(text(),'Day')]")).click();
		String currentDay = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText();
		System.out.println("Current Day is "+currentDay );
		
		//Event Creation
		driver.findElement(By.xpath("//button[contains(text(),'Month')]")).click();
		driver.findElement(By.xpath("//td[@data-date='2023-05-01']//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt87:title")));
		
		driver.findElement(By.id("j_idt87:title")).sendKeys("Test Event");
		WebElement from =driver.findElement(By.id("j_idt87:from_input"));
		from.clear();
		from.sendKeys("01/05/2023 09:00");
		from.sendKeys(Keys.TAB);
		WebElement to= driver.findElement(By.id("j_idt87:to_input"));
		to.clear();
		to.sendKeys("01/05/2023 10:00");
		to.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();		
	}	
}
